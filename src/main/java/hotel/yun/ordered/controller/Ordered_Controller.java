package hotel.yun.ordered.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedToMeals;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.service.Ordered_Service;

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
	CustomerService cser;
	
	
//---------------------------------------------------------------
		//後台的進入點
		@GetMapping("/indexOrdered")
		public String indexOrdered(Model model){
			return "ordered/ordered";
		
		}
//---------------------------------------------------------------
	//新增
	// 送出空白的Bean來接訂餐的屬性，Jsp input的name要對到DB的名稱
	@GetMapping("/insertMealsOd")
	public String ShowMealsOrdered( Model model) {
		Ordered od = new Ordered();
		model.addAttribute("odd", od);
		return "ordered/insertMealsOd";
	}
	// 讓使用者輸入，就可以新增進去，取他的值導到查詢頁面
	@PostMapping("/insertMealsOrdered")
	public String insertMealsOrdered(
			@RequestParam(value="chinese_name") String chinese_name,
			@RequestParam(value="mobile_phone") String mobile_phone,
			@RequestParam(value="number_of_meals") int number_of_meals,
			@RequestParam(value="meals_ordered_time") Date meals_ordered_time,
			Model model) {
		//用姓名手機撈顧客，若是存在此顧客就將撈出來的Customer塞進 od.setCustomer(customer);
		//若是不存在就做以下這些事情
		Customer customer = new Customer(chinese_name,mobile_phone);
//		customer.setChinese_name(chinese_name);
//		customer.setMobile_phone(mobile_phone);
		OrderedToMeals otm = new OrderedToMeals(number_of_meals,meals_ordered_time);
//		otm.setNumber_of_meals(number_of_meals);
//		otm.setMeals_ordered_time(meals_ordered_time);
		Ordered od = new Ordered();
		od.setCustomer(customer);
		od.setOrderedToMeals(otm);
		Ordered odd = service.insert(od);
		System.out.println("puipui");
		model.addAttribute("odd", odd);
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
			@RequestParam(value="room_number") int room_number,
			@RequestParam(value="room_ordered_time") Date room_ordered_time,
			Model model) {

		Customer customer = new Customer(chinese_name,idcard_number,birthday,address,mobile_phone);
		OrderedToRoom otr = new OrderedToRoom(room_ordered_time,room_number);
		Ordered od = new Ordered();
		od.setCustomer(customer);
		od.setOrderedToRoom(otr);
		Ordered odd = service.insert(od);
		System.out.println("puipui");
		model.addAttribute("odd", odd);
//		return null;
		return "ordered/customerRoomOd";//將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp
	}
//--------------------------------------------------
	//查詢
	@GetMapping("/thisOrdered")
	public String ThisOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
		Ordered ordered = service.queryOrderNum(odd.getOrdered_number());
		model.addAttribute("ordered_status", ordered.getOrderedStatus().getOrdered_status());
		model.addAttribute("payment_status",ordered.getOrderedPayment().getPayment_status());
		model.addAttribute("ordered", ordered);
		return "ordered/ThisOrdered";//依訂單號查到他的訂單
	}
	
	@GetMapping("/showAllOrdered")
	public String OrderedList(@ModelAttribute("odd") Ordered odd,Model model) {
		List<Ordered> Ordered = service.queryAll(odd.getOrdered_number());
		model.addAttribute("OrderedList",Ordered);
		return "ordered/thisOrderedAll";//進到查詢到的全部訂單，需再ThisOrdered裡設超連結進來
	}
	
	@PostMapping("/getCustomerOrder")
	public String getCustomerOrder(@ModelAttribute("odd") Ordered odd, Model model,HttpSession session) {
		//等小魏寫好取到顧客名子和手機的方法，我再取用
//		List<Ordered> CustomerOrdered = service.queryCustomerToOrdered();
//		model.addAttribute("Ordered",CustomerOrdered);
		return "ordered/customerOrdered";
	}	
	
	@PostMapping("/showDateToOrdered")
	public String showDateToOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
		List<Ordered> Ordered = service.queryDateToOrdered(odd.getOrdered_date());
		model.addAttribute("showDateToOrdered",Ordered);
		return "ordered/dateToOrdered";//進到該日期的所有訂單
	}
//-----------------------------------------------------------	
	//更新
	@PostMapping("/thisOrdered/{ordered_number}")
	public String update(@ModelAttribute("odd") Ordered odd,Model model) {
		Ordered ThisOrdered = service.queryOrderNum(odd.getOrdered_number());
		ThisOrdered.setOrdered_number(ThisOrdered.getOrdered_number());
		ThisOrdered.setCustomer(ThisOrdered.getCustomer());
		ThisOrdered.setOrderedToMeals(ThisOrdered.getOrderedToMeals());
		ThisOrdered.setOrderedToRoom(ThisOrdered.getOrderedToRoom());
		ThisOrdered.setOrderedStatus(ThisOrdered.getOrderedStatus());
		ThisOrdered.setOrderedPayment(ThisOrdered.getOrderedPayment());
		ThisOrdered.setOrdered_accounts(ThisOrdered.getOrdered_accounts());
		ThisOrdered.setOrdered_date(ThisOrdered.getOrdered_date());
		ThisOrdered.setNote(ThisOrdered.getNote());
	Ordered afterOrdered = service.update(ThisOrdered);
	model.addAttribute("updateOdered", afterOrdered);
		return "/ordered/thisOrdered";//依訂單到查詢到的訂單，再做修改
	}
	
	
//---------------------------------------------------------
	//刪除
	// 從訂單編號刪除一筆訂單
	@PostMapping("/DeleteOrdred/{ordered_number}")
	public String delete(@PathVariable("ordered_number") int ordered_number) {
		service.delete(ordered_number);
		return "redirect:/thisOrderedAll";
	}
}
