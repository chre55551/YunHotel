package hotel.yun.ordered.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
//---------------------------------------------------------------
		//後台的進入點
		@GetMapping("/indexOrdered")
		public String indexOrdered(Model model){
			return "ordered/ordered";
		}
		
		//新增的分流
		@GetMapping("/insertIndex")
		public String insertIndex(Model model){
			return "ordered/insertIndex";
		}
		
		//查詢的分流
		@GetMapping("/queryIndex")
		public String queryIndex(Model model){
			return "ordered/queryIndex";
		}
//---------------------------------------------------------------
	//新增
	// 送出空白的Bean來接訂餐的屬性，Jsp input的name要對到DB的名稱
	@GetMapping("/insertMealsOd")
	public String ShowMealsOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertMealsOd";
	}
	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@PostMapping("/insertMealsOrdered")
	public String insertMealsOrdered(
			@RequestParam(value="chinese_name") String chinese_name,
			@RequestParam(value="mobile_phone") String mobile_phone,
			@RequestParam(value="mealsnum_of_people") int mealsnum_of_people,
			@RequestParam(value="meals_ordered_time") Date meals_ordered_time,
			@RequestParam(value="time_period") String time_period,
			Model model) {
		//用姓名手機撈顧客，若是存在此顧客就將撈出來的Customer塞進 od.setCustomer(customer);
		//若是不存在就做以下這些事情
		Ordered od = new Ordered();
		Customer customer = new Customer(chinese_name,mobile_phone);
		try {
			Customer CExist = cser.query(customer);
			od.setCustomer(CExist);
		}catch(Exception e) {
			od.setCustomer(customer);	
			e.printStackTrace();
		}
		OrderedToMeals otm = new OrderedToMeals();
		otm.setmealsnum_of_people(mealsnum_of_people);// 這是人數
		try {// 根據時間跟時段撈出 mdate 並把它放進 otm 裡
			Mdate md = dser.queryByDatePeriod(meals_ordered_time, time_period);
			otm.setMdate(md);
		}catch(Exception e) {//若此時段不存在就建一個新的
			Mdate md = new Mdate();
			md.setMdate(meals_ordered_time);
			md.setTime_period(time_period);
			e.printStackTrace();
			otm.setMdate(md);
		}
		if(mealsnum_of_people<2) {
			 Integer k = otm.getMdate().getTable_two_order();
			 otm.getMdate().setTable_two_order(k++);
		}else if(mealsnum_of_people<4) {
			Integer k = otm.getMdate().getTable_four_order();
			otm.getMdate().setTable_four_order(k++);
		}else if(mealsnum_of_people<6) {
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

//		return null;
		return "ordered/customerMealsOd";//將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp
		
	}
	
	// 送出空白的Bean來接訂房的屬性，Jsp input的name要對到DB的名稱
	@GetMapping("/insertRoomOd")
	public String ShowRoomOrdered( Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertRoomOd";
	}
	
	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面(訂房)
	@PostMapping("/insertRoomOrdered")
	public String insertRoomOrdered(
			@RequestParam(value="chinese_name") String chinese_name,
			@RequestParam(value="idcard_number") String idcard_number,
			@RequestParam(value="mobile_phone") String mobile_phone,
			@RequestParam(value="birthday") Date birthday,
			@RequestParam(value="address") String address,
			@RequestParam(value="room_number") String room_name,
			@RequestParam(value="room_date") Date room_date,
			Model model) {
		Ordered od = new Ordered();
		Customer customer = new Customer(chinese_name,idcard_number,birthday,address,mobile_phone);
		try {
			Customer CExist = cser.query(customer);
			CExist.setIdcard_number(idcard_number);
			CExist.setAddress(address);
			CExist.setBirthday(birthday);
			od.setCustomer(CExist);
		}catch(Exception e) {
			od.setCustomer(customer);	
			e.printStackTrace();
		}
		OrderedToRoom otr = new OrderedToRoom();
		try {
			Room r = rser.queryByRoomNum(room_name);
			otr.setRoom(r);
		}catch(Exception e) {
			Room r = new Room();
			r.setRoom_name(room_name);
			otr.setRoom(r);
		}
		od.setOrderedToRoom(otr);
		try {
			Rdate rd = dser.queryByRoomDate(room_date);
			otr.setRdate(rd);
		}catch(Exception e) {
			Rdate rd = new Rdate();
			rd.setRoom_date(room_date);
			e.printStackTrace();
			otr.setRdate(rd);
		}
		od.setOrderedToRoom(otr);
		
		OrderedStatus os = new OrderedStatus();
		os.setStatus_id(1);
		od.setOrderedStatus(os);
		
		Ordered odd;
		try {
			odd = service.insert(od);
			model.addAttribute("odd", odd);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return null;
		return "ordered/customerRoomOd";//將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp(暫定)
	}
//--------------------------------------------------
	//查詢
//	@GetMapping("/thisOrdered")
//	public String ThisOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
//		Ordered ordered = service.queryOrderNum(odd.getOrdered_number());
//		model.addAttribute("ordered_status", ordered.getOrderedStatus().getOrdered_status());
//		model.addAttribute("payment_status",ordered.getOrderedPayment().getPayment_status());
//		model.addAttribute("ordered", ordered);
//		return "ordered/thisOrdered";//依訂單號查到他的訂單
//	}
	
	@GetMapping("/showAllOrdered")
	public String OrderedList(@ModelAttribute("odd") Ordered odd,Model model) {
		List<Ordered> Ordered = service.queryAll(odd.getOrdered_number());
		model.addAttribute("OrderedList",Ordered);
		return "ordered/thisOrderedAll";//進到查詢到的全部訂單，需再ThisOrdered裡設超連結進來
	}
	//寫在後台需要從顧客查詢到他的訂單
	@GetMapping("/customerToOrdered")
	public String getCustomerOrder(Model model,HttpSession session) {
		return "ordered/customerToOrdered";
	}	
	//寫在後台需要從顧客查詢到他的訂單 AJAX 取出已成立
	@PostMapping("/customerToOrdered/orderedCreated")
	public @ResponseBody List<Ordered> orderedCreatedAjax(
			@RequestParam(value="chinese_name") String chinese_name,
			@RequestParam(value="mobile_phone") String mobile_phone,
			@RequestParam(value="ordered_status") String ordered_status,
 Model model,HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
		Customer customer = cser.query(c);
		List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
		List<Ordered> returnlist = new ArrayList<Ordered>();
		for(Ordered o :CustomerOrdered) {
			if(o.getOrderedStatus().getStatus_id()==1) {
				returnlist.add(o);
			}
		}
		return returnlist;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	//寫在後台需要從顧客查詢到他的訂單 AJAX 取出已結單
		@PostMapping("/customerToOrdered/orderedFinished")
		public @ResponseBody List<Ordered> orderedFinishedAjax(
				@RequestParam(value="chinese_name") String chinese_name,
				@RequestParam(value="mobile_phone") String mobile_phone,
				@RequestParam(value="ordered_status") String ordered_status,
	 Model model,HttpSession session) {
			Customer c = new Customer(chinese_name, mobile_phone);
			try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for(Ordered o :CustomerOrdered) {
				if(o.getOrderedStatus().getOrdered_status()=="已完成") {
					returnlist.add(o);
				}
			}
			return returnlist;
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}	
	
		//寫在後台需要從顧客查詢到他的訂單 AJAX 取出全部訂單
		@PostMapping("/customerToOrdered/orderedAll")
		public @ResponseBody List<Ordered> orderedAllAjax(
				@RequestParam(value="chinese_name") String chinese_name,
				@RequestParam(value="mobile_phone") String mobile_phone,
				@RequestParam(value="ordered_status") String ordered_status,
	 Model model,HttpSession session) {
			Customer c = new Customer(chinese_name, mobile_phone);
			try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			return CustomerOrdered;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}	
		//查到我顧客訂單的詳細資料
		@RequestMapping("/thisOrdered/{ordered_number}")
		public String singleOrdered(@PathVariable(value = "ordered_number") int ordered_number,Model model) {
			Ordered ordered = service.queryOrderNum(ordered_number);
			model.addAttribute("ordered", ordered);
			return "ordered/thisOrdered";
		}
		
	//寫在後台需要從日期查詢到他的訂單
	@GetMapping("/dateToOrdered")
	public String showDateToOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
		return "ordered/dateToOrdered";//進到該日期的所有訂單
	}
//	@GetMapping("/dateToThisOrdered")
//	public String DateToOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
//		List<Ordered> Ordered = service.queryDateToOrdered(odd.getOrdered_date());
//		model.addAttribute("Ordered",Ordered);
//		return "ordered/dateToOrdered";//進到該日期的所有訂單
//	}
//-----------------------------------------------------------	
	//更新
//	@PostMapping("/thisOrdered/{ordered_number}")
//	public String update(@ModelAttribute("odd") Ordered odd,Model model) {
//		Ordered ThisOrdered = service.queryOrderNum(odd.getOrdered_number());
//		ThisOrdered.setOrdered_number(ThisOrdered.getOrdered_number());
//		ThisOrdered.setCustomer(ThisOrdered.getCustomer());
//		ThisOrdered.setOrderedToMeals(ThisOrdered.getOrderedToMeals());
//		ThisOrdered.setOrderedToRoom(ThisOrdered.getOrderedToRoom());
//		ThisOrdered.setOrderedStatus(ThisOrdered.getOrderedStatus());
//		ThisOrdered.setOrderedPayment(ThisOrdered.getOrderedPayment());
//		ThisOrdered.setOrdered_accounts(ThisOrdered.getOrdered_accounts());
//		ThisOrdered.setOrdered_date(ThisOrdered.getOrdered_date());
//		ThisOrdered.setNote(ThisOrdered.getNote());
//	Ordered afterOrdered = service.update(ThisOrdered);
//	model.addAttribute("updateOdered", afterOrdered);
//		return "/ordered/thisOrdered";//依訂單到查詢到的訂單，再做修改
//	}
	//從查詢取值後，送出這個空白表單
	@GetMapping("/update/{id}")
	public String update(
			@PathVariable(value="id") int ordered_number,
//			@RequestParam(value = "chinese_name") String chinese_name,
//			@RequestParam(value = "mobile_phone") String mobile_phone,
//			@RequestParam(value = "table_number") int table_number,
//			@RequestParam(value = "room_number") int room_number,
//			@RequestParam(value = "ordered_status") String ordered_status,
//			@RequestParam(value = "payment_status") String payment_status,
//			@RequestParam(value = "ordered_accounts") int ordered_accounts,
//			@RequestParam(value = "ordered_date") String note,
			Model model) {
		Ordered ThisOrdered = service.queryOrderNum(ordered_number);
			model.addAttribute("updateOdered", ThisOrdered);
		return "ordered/updateOrdered";//依訂單到查詢到的訂單，送出可修改的空白表單，再做修改
	}
	//發送修改的請求
	@PostMapping("/updatecheck/{ordered_number}")
	public String updateCustomerOd(
			@PathVariable(value = "ordered_number",required=false) Integer ordered_number,
			@RequestParam(value = "chinese_name" ,required=false) String chinese_name,
			@RequestParam(value = "mobile_phone",required=false) String mobile_phone,
			@RequestParam(value = "table_number",required=false) Integer table_number,
			@RequestParam(value = "room_number",required=false) Integer room_number,
			@RequestParam(value = "ordered_status",required=false) String ordered_status,
			@RequestParam(value = "payment_status",required=false) String payment_status,
			@RequestParam(value = "ordered_accounts",required=false) Integer ordered_accounts,
			@RequestParam(value = "note",required=false) String note,
			Model model) 
			{
		System.out.println(ordered_number);
		System.out.println(chinese_name);
		System.out.println(mobile_phone);
		System.out.println(table_number);
		System.out.println(room_number);
		System.out.println(ordered_status);
		System.out.println(payment_status);
		System.out.println(ordered_accounts);
		System.out.println(note);
		

		Ordered ordered = service.queryOrderNum(ordered_number.intValue());
		if(table_number!=null) {
			if(ordered.getOrderedToMeals()!=null) {
		ordered.getOrderedToMeals().setTable_number(table_number.intValue());
			}else {
				OrderedToMeals otm = new OrderedToMeals();
				otm.setTable_number(table_number.intValue());
				ordered.setOrderedToMeals(otm);
			}
		}
		if(room_number!=null) {
			if(ordered.getOrderedToRoom()!=null) {
				ordered.getOrderedToRoom().setRoom_number(room_number.intValue());
			}else {
				OrderedToRoom otr = new OrderedToRoom();
				otr.setRoom_number(room_number.intValue());
				ordered.setOrderedToRoom(otr);
			}
		}
		if(ordered.getOrderedStatus()!=null) {
			ordered.getOrderedStatus().setOrdered_status(ordered_status);
		}else {
			OrderedStatus os = new OrderedStatus();
			os.setOrdered_status(ordered_status);
			ordered.setOrderedStatus(os);
		}
		if(ordered.getOrderedPayment()!=null) {
		ordered.getOrderedPayment().setPayment_status(payment_status);
		}else {
			 OrderedPayment op = new OrderedPayment();
			 op.setPayment_status(payment_status);
			 ordered.setOrderedPayment(op);
		}
		ordered.setNote(note);
		
		System.out.println(ordered.getOrderedToMeals().getTable_number());
		System.out.println(ordered.getCustomer().getChinese_name());
		System.out.println(ordered.getCustomer().getMobile_phone());
		System.out.println(ordered.getOrderedToMeals().getTable_number());
		System.out.println(ordered.getOrderedToRoom().getRoom_number());
		System.out.println(ordered.getOrderedStatus().getOrdered_status());
		System.out.println(ordered.getOrderedPayment().getPayment_status());
		System.out.println(ordered.getOrdered_accounts());
		System.out.println(ordered.getNote());
		
		service.updateCustomerOd(ordered);
		
		Ordered odAfter = service.queryOrderNum(ordered_number.intValue());
		
		System.out.println(odAfter.getOrderedToMeals().getTable_number());
		System.out.println(odAfter.getCustomer().getChinese_name());
		System.out.println(odAfter.getCustomer().getMobile_phone());
		System.out.println(odAfter.getOrderedToMeals().getTable_number());
		System.out.println(odAfter.getOrderedStatus().getOrdered_status());
//		System.out.println(odAfter.getOrderedPayment().getPayment_status());
		System.out.println(odAfter.getOrdered_accounts());
		System.out.println(odAfter.getNote());
//		System.out.println(odAfter.getOrderedToRoom().getRoom_number());
		model.addAttribute("ordered",odAfter);
		return "ordered/thisOrdered";
	}
	
//---------------------------------------------------------
	//刪除
	// 從訂單編號刪除一筆訂單
	@GetMapping("/DeleteOrdred/{ordered_number}")
	public String delete(@PathVariable("ordered_number") int ordered_number) {
		service.delete(ordered_number);
		return "ordered/deleteFinish";
	}
}
