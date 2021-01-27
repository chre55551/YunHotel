package hotel.yun.ordered.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;
import hotel.yun.date.service.Date_Service;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToMeals;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller {

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
//-----------------------------------------------------------------------------------------------------
	// 新增
	// 後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台 送出空白的Bean來接訂餐的屬性，Jsp input的name要對到DB的名稱 訂餐~~~~~~~~~
	@GetMapping("/insertMealsOd")
	public String ShowMealsOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertMealsOd";
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@PostMapping("/insertMealsOrdered")
	public String insertMealsOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "mealsnum_of_people") int mealsnum_of_people,
			@RequestParam(value = "mdate") Date mdate, @RequestParam(value = "time_period") String time_period,
			@RequestParam(value = "note") String note, Model model) {
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
	//   後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台後台   送出空白的Bean來接訂房的屬性，Jsp input的name要對到DB的名稱
	@GetMapping("/insertRoomOd")
	public String ShowRoomOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertRoomOd";
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面   訂房~~~~~~~~~‵
	@PostMapping("/insertRoomOrdered")
	public String insertRoomOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "idcard_number") String idcard_number,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "birthday") Date birthday,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "room_type",required = false) String room_type,//可以不用
			@RequestParam(value = "rdate", required = false) Date rdate,
			@RequestParam(value = "rdateEnd", required = false) Date rdateEnd,
			@RequestParam(value = "note") String note, 
			Model model) {
		DateTime rdateDT = DateToDateTime(rdate);
		DateTime rdateEndDT = DateToDateTime(rdateEnd);
		Set<DateTime> range = getDateRange(rdateDT,rdateEndDT);//產生 入住日期至退房日期的所有日期
		Set<Rdate> rdates = new HashSet<>();
		
		Ordered od = new Ordered();
		od.setNote(note);
		Customer customer = new Customer(chinese_name, idcard_number, birthday, address, mobile_phone);
		try {
			Customer CExist = cser.query(customer);//根據姓名手機找顧客，若有此顧客，輸入資料設進去
			CExist.setIdcard_number(idcard_number);
			CExist.setAddress(address);
			CExist.setBirthday(birthday);
			od.setCustomer(CExist);
		} catch (Exception e) {//若無，則新增一個顧客塞進 OD
			od.setCustomer(customer);
			e.printStackTrace();
		}
		
		OrderedToRoom otr = new OrderedToRoom();//新增房間訂單
		
	    for(DateTime d:range) {
	    	Date date = dateTimeToDate(d);
	    	try {
	    		Rdate rd = dser.queryByRoomDate(date);//嘗試根據日期找出 Rdate 物件
	    		rdates.add(rd);//加到 set<Rdate>中
	    	}catch(Exception e) {//若不存在此日期，new 一個加到資料庫
	    		Rdate r = new Rdate();
	    		r.setRdate(date);
	    		dser.insert(r);
	    		rdates.add(r);//加到 set<Rdate>中
	    	}
	    }
	    
	    otr.setRdates(rdates);
	    
	    Room room = new Room();//新增空的房間
	    
	    try {
	    	room = rser.queryByRoomNum(room_name); //嘗試取出房號
	    	otr.setRoom(room); //將取出的房號放入房間訂單
	    	System.out.println("queryByRoomNum sucess!!!");
	    } catch (Exception eee) {
	    	room.setRoom_name(room_name);
	    	otr.setRoom(room);
	    	System.out.println("queryByRoomNum fail!!!");
	    }		
	    room.setRdates(rdates);//房間跟日期的多對多關係
	    rser.save(room);//存入資料庫
	    
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
	//前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台前台的新增!!!!!!  
	//送出空白的表單，來接住使用者輸入的值 訂位~~~~
	@GetMapping("/outsideInsertMealsOd")
	public String outsideShowMealsOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/outsideInsertMealsOd";
	}
	
	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@GetMapping("/outsideInsertMealsOrdered")
	public String outsideinsertMealsOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "mealsnum_of_people") int mealsnum_of_people,
			@RequestParam(value = "mdate") Date mdate, @RequestParam(value = "time_period") String time_period,
			@RequestParam(value = "note") String note, Model model) {
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
		return "ordered/outsideCustomerMealsOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp

	}
	
//-----------------------------------------------------------------------------------------------------
	//前台的
	@GetMapping("/outsideInsertRoomOd")
	public String outsideShowRoomOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/outsideInsertRoomOd";
	}

	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面   訂房~~~~~~~~~‵
	@SuppressWarnings("rawtypes")
	@PostMapping("/outsideInsertRoomOrdered")
	public String outsideinsertRoomOrdered(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "idcard_number") String idcard_number,
			@RequestParam(value = "mobile_phone") String mobile_phone, @RequestParam(value = "birthday") Date birthday,
			@RequestParam(value = "address") String address, @RequestParam(value = "room_type") String room_type,
			@RequestParam(value = "rdate", required = false) Date rdate,
			@RequestParam(value = "note") String note, Model model) {
		Ordered od = new Ordered();
		od.setNote(note);
		Customer customer = new Customer(chinese_name, idcard_number, birthday, address, mobile_phone);
		try {
			Customer CExist = cser.query(customer);
			CExist.setIdcard_number(idcard_number);
			CExist.setAddress(address);
			CExist.setBirthday(birthday);
			od.setCustomer(CExist);
		} catch (Exception e) {
			od.setCustomer(customer);
			e.printStackTrace();
		}
		OrderedToRoom otr = new OrderedToRoom();
		Room rm = new Room();
		try {
			Rdate rd = dser.queryByRoomDate(rdate);
			Set<Rdate> list = new HashSet();
			list.add(rd);
			otr.setRdates(list);
		}catch(Exception e) {
			Rdate rd = new Rdate();
			rd.setRdate(rdate);
			Set<Rdate> list = new HashSet();
			list.add(rd);
			otr.setRdates(list);
		}
		try {
			RoomType r = rser.queryByRoomType(room_type);
			rm.setRoomType(r);
			otr.setRoom(rm);
		} catch (Exception e) {
			RoomType r = new RoomType();
			r.setRoom_type(room_type);
			rm.setRoomType(r);
			otr.setRoom(rm);
		}
		od.setOrderedToRoom(otr);
		try {
			Rdate rd = dser.queryByRoomDate(rdate);
			Set<Rdate> list = new HashSet();
			list.add(rd);
			otr.setRdates(list);
		} catch (Exception e) {
			Rdate rd = new Rdate();
			rd.setRdate(rdate);
			Set<Rdate> list = new HashSet();
			list.add(rd);
			otr.setRdates(list);
		}
		od.setOrderedToRoom(otr);

		OrderedStatus os = new OrderedStatus();
		os.setStatus_id(1);
		od.setOrderedStatus(os);

		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
			model.addAttribute("rdates", odd.getOrderedToRoom().getRdates());
			model.addAttribute("mdate", odd.getOrderedToMeals().getMdate().getMdate());
			model.addAttribute("roomname", odd.getOrderedToRoom().getRoom().getRoom_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return null;
		return "ordered/outsideCustomerRoomOd";// 將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp(暫定)
	}
//-----------------------------------------------------------------------------------------------------
	// 查詢
//	@GetMapping("/thisOrdered")
//	public String ThisOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
//		Ordered ordered = service.queryOrderNum(odd.getOrdered_number());
//		model.addAttribute("ordered_status", ordered.getOrderedStatus().getOrdered_status());
//		model.addAttribute("payment_status",ordered.getOrderedPayment().getPayment_status());
//		model.addAttribute("ordered", ordered);
//		return "ordered/thisOrdered";//依訂單號查到他的訂單
//	}

	@GetMapping("/showAllOrdered")
	public String OrderedList(@ModelAttribute("odd") Ordered odd, Model model) {
		List<Ordered> Ordered = service.queryAll(odd.getOrdered_number());
		model.addAttribute("OrderedList", Ordered);
		return "ordered/thisOrderedAll";// 進到查詢到的全部訂單，需再ThisOrdered裡設超連結進來
	}
//-----------------------------------------------------------------------------------------------------
	// 寫在後台需要從顧客查詢到他的訂單
	@GetMapping("/customerToOrdered")
	public String getCustomerOrder(Model model, HttpSession session) {
		return "ordered/customerToOrdered";
	}


	// 查到我顧客訂單的詳細資料
	@RequestMapping("/thisOrdered/{ordered_number}")
	public String singleOrdered(@PathVariable(value = "ordered_number") int ordered_number, Model model) {
		Ordered ordered = service.queryOrderNum(ordered_number);
		model.addAttribute("ordered", ordered);
		try {
		model.addAttribute("rdates", ordered.getOrderedToRoom().getRdates());
		}catch(Exception e) {
			
		}
		try {
		model.addAttribute("mdate", ordered.getOrderedToMeals().getMdate());
		}catch(Exception e) {
			
		}
		return "ordered/thisOrdered";
	}

	// 寫在後台需要從日期查詢到他的訂單
//	@GetMapping("/dateToThisOrdered")
//	public String DateToOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
//		List<Ordered> Ordered = service.queryDateToOrdered(odd.getOrdered_date());
//		model.addAttribute("Ordered",Ordered);
//		return "ordered/dateToOrdered";//進到該日期的所有訂單
//	
//-----------------------------------------------------------------------------------------------------
	// 前台 需要從顧客查詢到他的訂單 ~~~~~~~~~~~~~~~~~~~
	@GetMapping("/outsideCustomerToOrdered")
	public String getCustomerOrderss(Model model, HttpSession session) {
		return "ordered/outsideCustomerToOrdered";
	}


	// 查到顧客訂單的詳細資料
	@RequestMapping("/outsidethisOrdered/{ordered_number}")
	public String singleOrderedss(@PathVariable(value = "ordered_number") int ordered_number, Model model) {
		Ordered ordered = service.queryOrderNum(ordered_number);
		model.addAttribute("ordered", ordered);
		try {
		model.addAttribute("rdates", ordered.getOrderedToRoom().getRdates());
		}catch(Exception e) {
			
		}
		try {
		model.addAttribute("mdate", ordered.getOrderedToMeals().getMdate());
		}catch(Exception e) {
			
		}
		return "ordered/outsidethisOrdered";
	}
	
//-----------------------------------------------------------------------------------------------------
	// 更新
	// 從查詢取值後，送出這個空白表單
	@GetMapping("/update/{id}")
	public String update(@PathVariable(value = "id") int ordered_number, Model model) {
		Ordered ThisOrdered = service.queryOrderNum(ordered_number);
		model.addAttribute("updateOdered", ThisOrdered);
		System.out.println(ThisOrdered.getOrderedToRoom().getRdates());
		try {
			model.addAttribute("OTR",ThisOrdered.getOrderedToRoom());
			model.addAttribute("room",ThisOrdered.getOrderedToRoom().getRoom());
			model.addAttribute("roomType",ThisOrdered.getOrderedToRoom().getRoom().getRoomType());
			List<Date> dateList = new ArrayList<Date>();
			for(Rdate rdate:ThisOrdered.getOrderedToRoom().getRdates()) {
				dateList.add(rdate.getRdate());
			}
			dateList.sort((a1, a2) -> {
				return a1.compareTo(a2);
			});
			model.addAttribute("firstDay",dateList.get(0));
			model.addAttribute("lastDay",dateList.get(dateList.size()-1));
			model.addAttribute("Rdates",ThisOrdered.getOrderedToRoom().getRdates());
		}catch(Exception e){
			
		}
		try {
			model.addAttribute("OTM",ThisOrdered.getOrderedToMeals());
			model.addAttribute("Meals",ThisOrdered.getOrderedToMeals().getMeals());
			model.addAttribute("Mdate",ThisOrdered.getOrderedToMeals().getMdate());
			model.addAttribute("time_period",ThisOrdered.getOrderedToMeals().getMdate().getTime_period());
		}catch(Exception e){
			
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
			@RequestParam(value = "note", required = false) String note, Model model) {

		Ordered ordered = service.queryOrderNum(ordered_number.intValue());

		if (ordered.getCustomer() != null) {
			ordered.getCustomer().setBirthday(birthday);
			ordered.getCustomer().setIdcard_number(idcard_number);
			ordered.getCustomer().setAddress(address);
		}
		
		if (ordered.getOrderedToRoom() != null) {
			ordered.getOrderedToRoom().getRoom().setRoom_name(room_name);
//			else {
////				OrderedToRoom otr = new OrderedToRoom();
////				otr.setRoom_number(room_number.intValue());
////				ordered.setOrderedToRoom(otr);
//			}
		}
		
		if(ordered.getOrderedToRoom().getRdates()!=null) {
			try {
			Rdate rd = dser.queryByRoomDate(rdate);
			ordered.getOrderedToRoom().getRdates().add(rd);
			}catch(Exception e) {
				Rdate rd = new Rdate();
				rd.setRdate(rdate);
				ordered.getOrderedToRoom().getRdates().add(rd);
			}
		}
		
		if(ordered.getOrderedToMeals()!=null) {
			ordered.getOrderedToMeals().setmealsnum_of_people(mealsnum_of_people);
		}
		
		if(ordered.getOrderedToMeals().getMdate()!=null) {
			ordered.getOrderedToMeals().getMdate().setMdate(mdate);
			ordered.getOrderedToMeals().getMdate().setTime_period(time_period);
		}
		
		if (ordered.getOrderedStatus() != null) {
			ordered.getOrderedStatus().setOrdered_status(ordered_status);
		} else {
			OrderedStatus os = new OrderedStatus();
			os.setOrdered_status(ordered_status);
			ordered.setOrderedStatus(os);
		}
		if (ordered.getOrderedPayment() != null) {
			ordered.getOrderedPayment().setBill_status(bill_status);
		} else {
			OrderedPayment op = new OrderedPayment();
			op.setBill_status(bill_status);
			ordered.setOrderedPayment(op);
		}
		
//		ordered.setOrdered_accounts(ordered_accounts);
//		ordered.setOrdered_last_update(ordered_last_update);
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
	public String delete(@PathVariable("ordered_number") int ordered_number) {
		service.delete(ordered_number);
		return "ordered/deleteFinish";
	}
//-----------------------------------------------------------------------------------------------------
	public DateTime DateToDateTime(Date d) {
		String str = d.toString();
		return DateTime.parse(str);
	}
	
    public Set<DateTime> getDateRange(DateTime start, DateTime end) {
        Set<DateTime> ret = new HashSet<DateTime>();
        DateTime tmp = start;
        DateTime tmpend = end.plusDays(-1);
        while(tmp.isBefore(tmpend) || tmp.equals(tmpend)) {
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
    
    public Set<Rdate> dateTimeSetToRdateSet(Set<DateTime> sd){
    	Set<Rdate> rdates = new HashSet<>();
    	for(DateTime d:sd) {
    		Rdate r = new Rdate();
    		Date date = dateTimeToDate(d);
    		r.setRdate(date);
    		rdates.add(r);
    	}
    	return rdates;
    }
}
