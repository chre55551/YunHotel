package hotel.yun.ordered.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.service.Date_Service;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller_Ajax {
	
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
	
	//-----------------以上是屬性--------------------

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出已成立~~~~~~~~~~~~~~~~~
	@PostMapping("/customerToOrdered/orderedCreated")
	public @ResponseBody List<Ordered> orderedCreatedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status, Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for (Ordered o : CustomerOrdered) {
				if (o.getOrderedStatus().getStatus_id() == 1) {
					returnlist.add(o);
				}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出已結單~~~~~~~~~~~~~~~~~~~
	@PostMapping("/customerToOrdered/orderedFinished")
	public @ResponseBody List<Ordered> orderedFinishedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status, Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for (Ordered o : CustomerOrdered) {
				if (o.getOrderedStatus().getOrdered_status() == "已結單") {
					returnlist.add(o);
				}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出      全部訂單~~~~~~~~~~~~~~~
	@PostMapping("/customerToOrdered/orderedAll")
	public @ResponseBody List<Ordered> orderedAllAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status, Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			return CustomerOrdered;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
