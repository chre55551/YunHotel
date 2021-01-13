package hotel.yun.ordered.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;

@Controller
@RequestMapping("/hotel.yun.ordered")
//我的這個跨請求是只要設外鍵需要連結到另一個請求頁面，就要把它設進去沒錯吧?
@SessionAttributes({"order_number", "customer_id","ordered_tomeals_id","ordered_toroom_id","status_id","payment_id"})
public class Ordered_Controller {
	
	@Autowired
	ServletContext context;
	
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	Ordered_Service service;

	public void setService(Ordered_Service service) {
		this.service = service;
	}
	
	@PostMapping("")
	public String insert(@ModelAttribute Ordered bean) {
	
		return null;
		
	}
}
