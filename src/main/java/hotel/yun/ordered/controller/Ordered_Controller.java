package hotel.yun.ordered.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;

@Controller
@RequestMapping("/hotel.yun.ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller {

	@Autowired
	ServletContext context;

	@Autowired
	Ordered_Service service;

//	@Autowired
//	Ordered od;
	
	// 本方法於新增時，送出空白的表單讓使用者輸入資料
//	@GetMapping("/Ordred")
//	public String ShowOrdered(Model model) {
//		Ordered od = new Ordered();
//		model.addAttribute("ordered", od);
//		return "ordered/InsertOrdered";
//	}
	// 讓使用者輸入
	@PostMapping("/InsertOrdred")
	public String insert(@ModelAttribute("odd") Ordered odd, Model model,HttpServletRequest request,BindingResult result) {
		service.insert(odd);
		
		return "ordered/ThisOrdered";//將來直接進該筆訂單明細，會跟單筆訂單查是同個jsp
	}
//-------------------------------------
	@PostMapping("/thisOrdered")
	public String ThisOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
		Ordered Ordered = service.queryOrderNum(odd.getOrdered_number());
		model.addAttribute("ThisOrdered", Ordered);
		return "ThisOrdered";//依訂單號查到他的訂單
	}
	
	@GetMapping("/showAllOrdered")
	public String OrderedList(@ModelAttribute("odd") Ordered odd,Model model) {
		List<Ordered> Ordered = service.queryAll(odd.getOrdered_number());
		model.addAttribute("OrderedList",Ordered);
		return "ordered/ThisOrderedAll";//進到查詢到的全部訂單，需再THhisOrdered裡設超連結進來
	}
	
	@PostMapping("/getCustomerOrder")
	public String getCustomerOrder(@ModelAttribute("odd") Ordered odd, Model model,HttpSession session) {
		//等小魏寫好取到顧客名子和手機的方法，我再取用
//		List<Ordered> CustomerOrdered = service.queryCustomerToOrdered();
//		model.addAttribute("Ordered",CustomerOrdered);
		return "ordered/CustomerOrdered";
	}	
	
	@PostMapping("/showDateToOrdered")
	public String showDateToOrdered(@ModelAttribute("odd") Ordered odd,Model model) {
		List<Ordered> Ordered = service.queryDateToOrdered(odd.getOrdered_date());
		model.addAttribute("showDateToOrdered",Ordered);
		return "ordered/DateToOrdered";//進到該日期的所有訂單
	}
//-----------------------------------------------------------	
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
		ThisOrdered.setIv_no(ThisOrdered.getIv_no());
		ThisOrdered.setNote(ThisOrdered.getNote());
	Ordered afterOrdered = service.update(ThisOrdered);
	model.addAttribute("updateOdered", afterOrdered);
		return "/ordered/ThisOrdered";//依訂單到查詢到的訂單，再做修改
	}
	
	
//---------------------------------------------------------
	// 從訂單編號刪除一筆訂單
	@PostMapping("/DeleteOrdred/{ordered_number}")
	public String delete(@PathVariable("ordered_number") int ordered_number) {
		service.delete(ordered_number);
		return "redirect:/ThisOrderedAll";
	}
}
