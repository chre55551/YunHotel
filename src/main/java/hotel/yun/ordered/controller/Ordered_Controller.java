package hotel.yun.ordered.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;
import hotel.yun.date.service.Date_Service;
import hotel.yun.meals.model.Meals;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToMeals;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.model.Room;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller {

	private static final String String = null;

	@Autowired
	ServletContext context;

	@Autowired
	Ordered_Service service;

	@Autowired
	RoomService rser;

	@Autowired
	CustomerService cser;

	@Autowired
	Date_Service dser;

//-----------------------------------------------------------------------------------------------------
	// 後台的進入點
	@GetMapping("/indexOrdered")
	public String indexOrdered(Model model) {
		return "ordered/ordered";
	}

	// 新增的分流
	@GetMapping("/insertIndex")
	public String insertIndex(Model model) {
		return "ordered/insertIndex";
	}

	// 查詢的分流
	@GetMapping("/queryIndex")
	public String queryIndex(Model model) {
		return "ordered/queryIndex";
	}

	// 結帳分流
	@GetMapping("/checkoutIndex")
	public String checkoutIndex(Model model) {
		return "ordered/checkoutIndex";
	}

//-----------------------------------------------------------------------------------------------------
	// 新增
	// 後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台 送出空白的Bean來接訂餐的屬性，Jsp input的name要對到DB的名稱
	// 訂餐~~~~~~~~~
	@GetMapping("/insertMealsOd")
	public String ShowMealsOrdered(Model model, HttpSession session) {
		String kk = (String)session.getAttribute("LoginOK");
		if(kk!=null) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertMealsOd";
		}else {
			return "login/PleaseLoginInBS";
		}
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@PostMapping("/insertMealsOrdered")
	public String insertMealsOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "mealsnum_of_people") int mealsnum_of_people,
			@RequestParam(value = "mdate") Date mdate, @RequestParam(value = "time_period") String time_period,
			@RequestParam(value = "note") String note, Model model, HttpSession session) {
		// 用姓名手機撈顧客，若是存在此顧客就將撈出來的Customer塞進 od.setCustomer(customer);
		// 若是不存在就做以下這些事情
		Ordered od = new Ordered();
		od.setNote(note);
		Customer customer = new Customer(chinese_name, mobile_phone);
		try {
			Customer CExist = cser.query(customer);
			od.setCustomer(CExist);
		} catch (Exception e) {
			od.setCustomer(customer);
			e.printStackTrace();
		}
		OrderedToMeals otm = new OrderedToMeals();
		otm.setmealsnum_of_people(mealsnum_of_people);// 這是人數
		try {// 根據時間跟時段撈出 mdate 並把它放進 otm 裡
			Mdate md = dser.queryByDatePeriod(mdate, time_period);
			otm.setMdate(md);
		} catch (Exception e) {// 若此時段不存在就建一個新的
			Mdate md = new Mdate();
			md.setMdate(mdate);
			md.setTime_period(time_period);
			e.printStackTrace();
			otm.setMdate(md);
		}
		if (mealsnum_of_people < 2) {
			Integer k = otm.getMdate().getTable_two_order();
			otm.getMdate().setTable_two_order(k++);
		} else if (mealsnum_of_people < 4) {
			Integer k = otm.getMdate().getTable_four_order();
			otm.getMdate().setTable_four_order(k++);
		} else if (mealsnum_of_people < 6) {
			Integer k = otm.getMdate().getTable_six_order();
			otm.getMdate().setTable_six_order(k++);
		}
		od.setOrderedToMeals(otm);

		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ordered/customerMealsOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp
	}

//-----------------------------------------------------------------------------------------------------
	// 後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台 送出空白的Bean來接訂房的屬性，Jsp
	// input的name要對到DB的名稱
	@GetMapping("/insertRoomOd")
	public String ShowRoomOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertRoomOd";
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面 訂房~~~~~~~~~‵
	@PostMapping("/insertRoomOrdered")
	public String insertRoomOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "idcard_number") String idcard_number,
			@RequestParam(value = "mobile_phone") String mobile_phone, @RequestParam(value = "birthday") Date birthday,
			@RequestParam(value = "address") String address, @RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "room_type", required = false) String room_type, // 可以不用
			@RequestParam(value = "rdate", required = false) Date rdate,
			@RequestParam(value = "rdateEnd", required = false) Date rdateEnd,
			@RequestParam(value = "note") String note, Model model, HttpSession session) {
		DateTime rdateDT = DateToDateTime(rdate);
		DateTime rdateEndDT = DateToDateTime(rdateEnd);
		Set<DateTime> range = getDateRange(rdateDT, rdateEndDT);// 產生 入住日期至退房日期的所有日期
		Room room = rser.queryRoomByName(room_name);// 根據房名撈出該房間
		Room room1 = rser.queryRoomByName(room_name);// 根據房名撈出該房間
		Set<Rdate> rdates = room.getRdates(); // 根據房間取出所有 rdate
		Set<Rdate> rdates1 = room1.getRdates(); // 根據房間取出所有 rdate

		Ordered od = new Ordered();
		od.setNote(note);
		Customer customer = new Customer(chinese_name, idcard_number, birthday, address, mobile_phone);
		try {
			Customer CExist = cser.query(customer);// 根據姓名手機找顧客，若有此顧客，輸入資料設進去
			CExist.setIdcard_number(idcard_number);
			CExist.setAddress(address);
			CExist.setBirthday(birthday);
			od.setCustomer(CExist);
		} catch (Exception e) {// 若無，則新增一個顧客塞進 OD
			od.setCustomer(customer);
			e.printStackTrace();
		}

		OrderedToRoom otr = new OrderedToRoom();// 新增房間訂單

		for (DateTime d : range) {
			Date date = dateTimeToDate(d);
			try {
				Rdate rd = dser.queryByRoomDate(date);// 嘗試根據日期找出 Rdate 物件
				rdates.add(rd);// 加到 set<Rdate>中
				rdates1.add(rd);// 加到 set<Rdate>中
			} catch (Exception e) {// 若不存在此日期，new 一個加到資料庫
				Rdate r = new Rdate();
				r.setRdate(date);
				dser.insert(r);
				rdates.add(r);// 加到 set<Rdate>中
				rdates1.add(r);// 加到 set<Rdate>中
			}
		}

		otr.setRdates(rdates1);

		room.setRdates(rdates);// 房間跟日期的多對多關係
		rser.update(room);// 房間跟日期關係存入資料庫

		otr.setRoom(room);// 將房間放入訂單
		service.insertOTR(otr);

		od.setOrderedToRoom(otr);

		OrderedStatus os = new OrderedStatus();
		os.setStatus_id(1);
		od.setOrderedStatus(os);

		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
			model.addAttribute("rdates", odd.getOrderedToRoom().getRdates());
			model.addAttribute("room", odd.getOrderedToRoom().getRoom());
			System.out.println("insert otr success!!!");
		} catch (Exception e) {
			System.out.println("insert otr fail!!!");
		}

		return "ordered/customerRoomOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp(暫定)
	}

//-----------------------------------------------------------------------------------------------------
	// 前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台的新增!!!!!!
	// 送出空白的表單，來接住使用者輸入的值 訂位~~~~
	@GetMapping("/outsideInsertMealsOd")
	public String outsideShowMealsOrdered(Model model, HttpSession session) {
		if(session.getAttribute("LoginOK")!=null) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/outsideInsertMealsOd";
		}else {
			return "customer/Login";
		}
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@PostMapping("/outsideCustomerMealsOd")
	public String outsideinsertMealsOrdered(/*
											 * @RequestParam(value = "chinese_name",required = false) String
											 * chinese_name,
											 * 
											 * @RequestParam(value = "mobile_phone",required = false) String
											 * mobile_phone,
											 */
			@RequestParam(value = "mealsnum_of_people") int mealsnum_of_people,
			@RequestParam(value = "mdate") Date mdate, @RequestParam(value = "time_period") String time_period,
			@RequestParam(value = "note") String note, Model model, HttpSession session) {

		// 用姓名手機撈顧客，若是存在此顧客就將撈出來的Customer塞進 od.setCustomer(customer);
		// 若是不存在就做以下這些事情
		Ordered od = new Ordered();
		od.setNote(note);

		Customer ct = new Customer();

		try {
			String ac = (String) session.getAttribute("LoginOK");
			ct = cser.queryByAc(ac);
			od.setCustomer(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}

		OrderedToMeals otm = new OrderedToMeals();
		otm.setmealsnum_of_people(mealsnum_of_people);// 這是人數
		try {// 根據時間跟時段撈出 mdate 並把它放進 otm 裡
			Mdate md = dser.queryByDatePeriod(mdate, time_period);
			otm.setMdate(md);
		} catch (Exception e) {// 若此時段不存在就建一個新的
			Mdate md = new Mdate();
			md.setMdate(mdate);
			md.setTime_period(time_period);
			e.printStackTrace();
			otm.setMdate(md);
		}
		if (mealsnum_of_people < 2) {
			Integer k = otm.getMdate().getTable_two_order();
			otm.getMdate().setTable_two_order(k++);
		} else if (mealsnum_of_people < 4) {
			Integer k = otm.getMdate().getTable_four_order();
			otm.getMdate().setTable_four_order(k++);
		} else if (mealsnum_of_people < 6) {
			Integer k = otm.getMdate().getTable_six_order();
			otm.getMdate().setTable_six_order(k++);
		}
		od.setOrderedToMeals(otm);

		System.out.println(od);
		System.out.println(od);
		System.out.println(od);
		System.out.println(od);
		System.out.println(od);
		
		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ct", ct);
		return "ordered/outsideCustomerMealsOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp

	}

//-----------------------------------------------------------------------------------------------------
	// 前台的
	@GetMapping("/outsideInsertRoomOd")
	public String outsideShowRoomOrdered(@RequestParam(value = "rdate", required = false) String rdate,
			@RequestParam(value = "rdateEnd", required = false) String rdateEnd, Model model, HttpSession session) {
		if(session.getAttribute("LoginOK")!=null) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		try {
		model.addAttribute("rdate", rdate);
		model.addAttribute("rdateEnd", rdateEnd);
		}catch(Exception e) {
			
		}
		return "ordered/outsideInsertRoomOd";}else {
			return "customer/Login";
		}
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面 訂房~~~~~~~~~‵
//	@SuppressWarnings("rawtypes")
	@PostMapping("/outsideCustomerRoomOd")
	public String outsideinsertRoomOrdered(
			@RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "room_type", required = false) String room_type, // 可以不用
			@RequestParam(value = "rdate", required = false) Date rdate,
			@RequestParam(value = "rdateEnd", required = false) Date rdateEnd,
			@RequestParam(value = "note") String note, Model model, HttpSession session) {

		DateTime rdateDT = DateToDateTime(rdate);
		DateTime rdateEndDT = DateToDateTime(rdateEnd);
		Set<DateTime> range = getDateRange(rdateDT, rdateEndDT);// 產生 入住日期至退房日期的所有日期
		Set<Rdate> rdates = new HashSet<>();

		for (DateTime d : range) {
			Date date = dateTimeToDate(d);
			try {
				Rdate rd = dser.queryByRoomDate(date);// 嘗試根據日期找出 Rdate 物件
				rdates.add(rd);// 加到 set<Rdate>中
			} catch (Exception e) {// 若不存在此日期，new 一個加到資料庫
				Rdate r = new Rdate();
				r.setRdate(date);
				dser.insert(r);
				rdates.add(r);// 加到 set<Rdate>中
			}
		}

		Ordered od = new Ordered();
		od.setNote(note);

		Customer ct = new Customer();
		try {
			String ac = (String) session.getAttribute("LoginOK");
			ct = cser.queryByAc(ac);
			od.setCustomer(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}

		OrderedToRoom otr = new OrderedToRoom();
		Room room = new Room();

		room = rser.queryRoomByName(room_name);// 根據房名撈出該房間
//		System.out.println(room.getRoomType().getRoom_price());
//		System.out.println(room.getRoomType().getRoom_price());
//		System.out.println(room.getRoomType().getRoom_price());
//		System.out.println(room.getRoomType().getRoom_price());
		room.setRdates(rdates);// 房間跟日期的多對多關係
		rser.update(room);// 房間跟日期關係存入資料庫
		otr.setRdates(rdates);

		otr.setRoom(room);// 將房間放入訂單
		service.insertOTR(otr);

		od.setOrderedToRoom(otr);

//		OrderedStatus os = new OrderedStatus();
//		os.setStatus_id(1);
//		od.setOrderedStatus(os);
		
//		OrderedPayment op = new OrderedPayment();
//		op.setPayment_id(1);
//		od.setOrderedPayment(op);

		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
			model.addAttribute("ct", odd.getCustomer());
			model.addAttribute("rdates", odd.getOrderedToRoom().getRdates());
			model.addAttribute("room", odd.getOrderedToRoom().getRoom());
			System.out.println("insert otr success!!!");
		} catch (Exception e) {
			System.out.println("insert otr fail!!!");
		}

		return "ordered/outsideCustomerRoomOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp(暫定)
	}

//-----------------------------------------------------------------------------------------------------
	// 寫在後台需要從顧客查詢到他的訂單
	@GetMapping("/customerToOrdered")
	public String getCustomerOrder(Model model, HttpSession session) {
		return "ordered/customerToOrdered";
	}

	// 查到我顧客訂單的詳細資料
	@GetMapping("/thisOrdered/{ordered_number}")
	public String singleOrdered(@PathVariable(value = "ordered_number") int ordered_number, Model model,
			HttpSession session) {
		Ordered ordered = service.queryOrderNum(ordered_number);
		model.addAttribute("ordered", ordered);
		try {
			model.addAttribute("room", ordered.getOrderedToRoom().getRoom());
			model.addAttribute("roomType", ordered.getOrderedToRoom().getRoom().getRoomType());
			model.addAttribute("rdates", ordered.getOrderedToRoom().getRdates());

		} catch (Exception e) {

		}
		try {
			model.addAttribute("mdate", ordered.getOrderedToMeals().getMdate());
		} catch (Exception e) {

		}
		
		try {
			model.addAttribute("meals", ordered.getOrderedToMeals().getMeals());
		} catch (Exception e) {

		}
		return "ordered/thisOrdered";
	}

//-----------------------------------------------------------------------------------------------------
	
	@GetMapping("/outsideQueryMyOd")
	public String outsideQueryMyOd(Model model, HttpSession session) {
		if(session.getAttribute("LoginOK")!=null) {
			return "ordered/outsideQueryMyOd";
		}else {
				return "customer/Login";
				}
	}
	
	// 前台 需要從顧客查詢到他的訂單 ~~~~~~~~~~~~~~~~~~~
	
	@RequestMapping("/outsideQueryCustomerOd")
	public String outsideQueryCustomerOd(Model model, HttpSession session) {

		Customer ct = new Customer();

		try {
			String ac = (String) session.getAttribute("LoginOK");
			ct = cser.queryByAc(ac);
			List<Ordered> odl = ct.getOrdered();
			Set<Ordered> set = new HashSet<Ordered>(); 
			List<Ordered> newList = new ArrayList<Ordered>(); 
			for (Iterator<Ordered> iter = odl.iterator(); iter.hasNext();) {
				Object element = iter.next(); if (set.add((Ordered) element)) newList.add((Ordered) element); 
				}
			odl.clear(); 
			odl.addAll(newList);
			
			List<Room> rooms = new ArrayList<>();
			List<Set<Rdate>> rdates = new ArrayList<>();
			List<Mdate> mdates = new ArrayList<>();

//			Set<Ordered> set = new HashSet<>(odl);
//			odl.clear();
//			odl.addAll(set);
			
//			List<Integer> num = new ArrayList();
//			List<Ordered> odl = new ArrayList();
//			odlllll.
//			for(Ordered odd:odlllll) {
//				set.add(odd);
//			}
//			for(Ordered odd:set) {
//				odd.getOrdered_number();
//			}
			for(Ordered od:odl) {
				try {
					Room room = od.getOrderedToRoom().getRoom();
					Set<Rdate> rdatesSet = od.getOrderedToRoom().getRdates();
					rdates.add(rdatesSet);
					rooms.add(room);
				}catch(Exception e) {
					
				}
				try {
					Mdate mdate = od.getOrderedToMeals().getMdate();
					mdates.add(mdate);
				}catch(Exception e) {
					
				}
			}
			
			model.addAttribute("odl", odl);
			model.addAttribute("rooms",rooms);
			model.addAttribute("mdates",mdates);
			
			
//			java.lang.String gson = new Gson().toJson(odl);
			// List<Object> list = new ArrayList<Object>();
//			model.addAttribute("gson", gson);
			
//			Ordered[] a = new Ordered[i1];
			
//			for (int i = 0; i < odl.size(); i++) {
//				Ordered getcu = odl.get(i);
////				a[i]=odl.get(i);
//				model.addAttribute("onum",getcu.getOrdered_number());
//				model.addAttribute("odate",getcu.getOrdered_date());
//				model.addAttribute("name",getcu.getCustomer().getChinese_name());
//				model.addAttribute("phone", getcu.getCustomer().getMobile_phone());
//				model.addAttribute("ostatus", getcu.getOrderedStatus().getOrdered_status());
//				model.addAttribute("oBill", getcu.getOrderedPayment().getBill_status());
//			}
//			model.addAttribute("a", a);
//			for (int i = 0;i < a.length; i++) {
//				Room room = a[i].getOrderedToRoom().getRoom();
//				Set<Rdate> rdates = a[i].getOrderedToRoom().getRdates();
//				Mdate mdate = a[i].getOrderedToMeals().getMdate();
//				List<Meals> meals = a[i].getOrderedToMeals().getMeals();
//				model.addAttribute("room"+i,room);
//				model.addAttribute("mdate"+i,mdate);
//				model.addAttribute("meals"+i,meals);
//				model.addAttribute("room"+i,room);
//			}
//			JSONObject json1 = new JSONObject(a);
//			model.addAttribute("json",json1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "ordered/outsideQueryCustomerOd";

	}

	// 查到顧客訂單的詳細資料
	@RequestMapping("/outsidethisOrdered")
	public String outsidesingleOrderedss(
//			@PathVariable(value = "chinese_name") String chinese_name,
//			@PathVariable(value = "mobile_phone") String mobile_phone,
			Model model, HttpSession session) {

//		Ordered ordered = service.queryOrderNum(ordered_number);
//		model.addAttribute("ordered", ordered);

		Ordered od = new Ordered();
		Customer ct = new Customer();
		try {
			String ac = (String) session.getAttribute("LoginOK");
			ct = cser.queryByAc(ac);
			List<Ordered> odl = ct.getOrdered();
			List<Object> list = new ArrayList<Object>();
			model.addAttribute("odl", odl);
			for (Ordered qq : odl) {
				Integer i = qq.getOrdered_number();
				list.add(i);
				System.out.println(i);

				model.addAttribute("od" + od.getOrdered_number(), qq);
				model.addAttribute("odc" + od.getOrdered_number(), qq.getCustomer());
				try {
					model.addAttribute("otr" + od.getOrdered_number(), qq.getOrderedToRoom());
					model.addAttribute("otrr" + od.getOrdered_number(), qq.getOrderedToRoom().getRoom());
					model.addAttribute("otrrt" + od.getOrdered_number(), qq.getOrderedToRoom().getRoom().getRoomType());
					model.addAttribute("otrd" + od.getOrdered_number(), qq.getOrderedToRoom().getRdates());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					model.addAttribute("otm" + od.getOrdered_number(), qq.getOrderedToMeals());
					model.addAttribute("otmmd" + od.getOrdered_number(), qq.getOrderedToMeals().getMdate());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				model.addAttribute("os" + od.getOrdered_number(), qq.getOrderedStatus());
				model.addAttribute("op" + od.getOrdered_number(), qq.getOrderedPayment());
			}
			model.addAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//			model.addAttribute("status", od.getOrderedStatus());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			model.addAttribute("payment", ordered.getOrderedPayment());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			model.addAttribute("room", ordered.getOrderedToRoom().getRoom());
//			model.addAttribute("roomType", ordered.getOrderedToRoom().getRoom().getRoomType());
//			model.addAttribute("rdates", ordered.getOrderedToRoom().getRdates());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			model.addAttribute("mdate", ordered.getOrderedToMeals().getMdate());
//			model.addAttribute("mdate", ordered.getOrderedToMeals().getMeals());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "ordered/outsidethisOrdered";
	}

//-----------------------------------------------------------------------------------------------------
	// 更新s
	// 從查詢取值後，送出這個空白表單
	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") int ordered_number, Model model, HttpSession session) {
		Ordered ThisOrdered = service.queryOrderNum(ordered_number);
		model.addAttribute("updateOdered", ThisOrdered);
//		System.out.println(ThisOrdered.getOrderedToRoom().getRdates());
		try {
			model.addAttribute("OTR", ThisOrdered.getOrderedToRoom());
			model.addAttribute("room", ThisOrdered.getOrderedToRoom().getRoom());
			model.addAttribute("roomType", ThisOrdered.getOrderedToRoom().getRoom().getRoomType());
			List<Date> dateList = new ArrayList<Date>();
			for (Rdate rdate : ThisOrdered.getOrderedToRoom().getRdates()) {
				dateList.add(rdate.getRdate());
			}
			dateList.sort((a1, a2) -> {
				return a1.compareTo(a2);
			});
			model.addAttribute("firstDay", dateList.get(0));
			model.addAttribute("lastDay", dateList.get(dateList.size() - 1));
			model.addAttribute("Rdates", ThisOrdered.getOrderedToRoom().getRdates());
		} catch (Exception e) {

		}
		try {
			model.addAttribute("OTM", ThisOrdered.getOrderedToMeals());
			model.addAttribute("Meals", ThisOrdered.getOrderedToMeals().getMeals());
			model.addAttribute("Mdate", ThisOrdered.getOrderedToMeals().getMdate());
			model.addAttribute("time_period", ThisOrdered.getOrderedToMeals().getMdate().getTime_period());
		} catch (Exception e) {

		}
		return "ordered/updateOrdered";// 依訂單到查詢到的訂單，送出可修改的空白表單，再做修改
	}

	// 發送修改的請求
	@PostMapping("/updatecheck/{ordered_number}")
	public String updateCustomerOd(@PathVariable(value = "ordered_number", required = false) Integer ordered_number, // 不能修改
			@RequestParam(value = "chinese_name", required = false) String chinese_name, // 不能修改
			@RequestParam(value = "mobile_phone", required = false) String mobile_phone, // 不能修改
			@RequestParam(value = "birthday", required = false) Date birthday,
			@RequestParam(value = "idcard_number", required = false) String idcard_number,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "room_name", required = false) String room_name,
			@RequestParam(value = "rdate", required = false) Date rdate,
			@RequestParam(value = "rdateEnd", required = false) Date rdateEnd,
			@RequestParam(value = "mealsnum_of_people", required = false) Integer mealsnum_of_people,
			@RequestParam(value = "mdate", required = false) Date mdate,
			@RequestParam(value = "time_period", required = false) String time_period,
			@RequestParam(value = "ordered_accounts", required = false) Integer ordered_accounts,
			@RequestParam(value = "ordered_status", required = false) String ordered_status,
			@RequestParam(value = "bill_status", required = false) String bill_status,
//			@RequestParam(value = "ordered_last_update", required = false) Timestamp ordered_last_update,
			@RequestParam(value = "note", required = false) String note, Model model, HttpSession session) {

		Ordered ordered = service.queryOrderNum(ordered_number.intValue());

		if (ordered.getCustomer() != null) {
			ordered.getCustomer().setBirthday(birthday);
			ordered.getCustomer().setIdcard_number(idcard_number);
			ordered.getCustomer().setAddress(address);
		}
		try {	
			DateTime rdateDT = DateToDateTime(rdate);
			DateTime rdateEndDT = DateToDateTime(rdateEnd);
			Set<DateTime> range = getDateRange(rdateDT, rdateEndDT);// 產生 入住日期至退房日期的所有日期
			Set<Rdate> rdates = new HashSet<>();

			for (DateTime d : range) {
				Date date = dateTimeToDate(d);
				try {
					Rdate rd = dser.queryByRoomDate(date);// 嘗試根據日期找出 Rdate 物件
					rdates.add(rd);// 加到 set<Rdate>中
				} catch (Exception e) {// 若不存在此日期，new 一個加到資料庫
					Rdate r = new Rdate();
					r.setRdate(date);
					dser.insert(r);
					rdates.add(r);// 加到 set<Rdate>中
				}
			}

			if (ordered.getOrderedToRoom() != null) {
				Room room = rser.queryByRoomNum(room_name);
				ordered.getOrderedToRoom().setRoom(room);
				ordered.getOrderedToRoom().setRdates(rdates);
			}

			if (ordered.getOrderedToRoom().getRdates() != null) {
				ordered.getOrderedToRoom().setRdates(rdates);
			}

			try {
				service.updateOTR(ordered.getOrderedToRoom());
				rser.update(ordered.getOrderedToRoom().getRoom());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception qqq) {
			
		}

		if (ordered.getOrderedToMeals() != null) {
			ordered.getOrderedToMeals().setmealsnum_of_people(mealsnum_of_people);
		}

		Mdate md = new Mdate();
		md.setMdate(mdate);
		md.setTime_period(time_period);
		
		if (ordered.getOrderedToMeals().getMdate() != null) {
			try {
				Mdate mda = dser.queryByMealDate(md);
				ordered.getOrderedToMeals().setMdate(mda);
			}catch(Exception e) {
				ordered.getOrderedToMeals().setMdate(md);
			}
		}

		if (ordered.getOrderedStatus() != null) {
			OrderedStatus os = service.queryStatusByS(ordered_status);
			ordered.setOrderedStatus(os);
		}
		
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		System.out.println(bill_status);
		
		if (ordered.getOrderedPayment() != null) {
			OrderedPayment op = service.queryPaymentBys(bill_status);
			ordered.setOrderedPayment(op);
		}

		ordered.setNote(note);

		service.updateCustomerOd(ordered);

		Ordered odAfter = service.queryOrderNum(ordered_number.intValue());
		model.addAttribute("ordered", odAfter);
		return "ordered/thisOrdered";
	}

//-----------------------------------------------------------------------------------------------------
	// 刪除
	// 從訂單編號刪除一筆訂單
	@GetMapping("/DeleteOrdred/{ordered_number}")
	public String delete(@PathVariable("ordered_number") int ordered_number, HttpSession session) {
		service.delete(ordered_number);
		return "ordered/deleteFinish";
	}

//-----------------------------------------------------------------------------------------------------
	public DateTime DateToDateTime(Date d) {
		String str = d.toString();
		return DateTime.parse(str);
	}

	// 88888
	public Set<DateTime> getDateRange(DateTime start, DateTime end) {
		Set<DateTime> ret = new HashSet<DateTime>();
		DateTime tmp = start;
		DateTime tmpend = end.plusDays(-1);
		while (tmp.isBefore(tmpend) || tmp.equals(tmpend)) {
			ret.add(tmp);
			tmp = tmp.plusDays(1);
		}
		return ret;
	}

	public Date dateTimeToDate(DateTime d) {
		java.util.Date date = d.toDate();
		Date sd = new java.sql.Date(date.getTime());
		return sd;
	}

	public Set<Rdate> dateTimeSetToRdateSet(Set<DateTime> sd) {
		Set<Rdate> rdates = new HashSet<>();
		for (DateTime d : sd) {
			Rdate r = new Rdate();
			Date date = dateTimeToDate(d);
			r.setRdate(date);
			rdates.add(r);
		}
		return rdates;
	}
}



