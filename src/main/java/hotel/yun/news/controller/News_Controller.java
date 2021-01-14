package hotel.yun.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.news.model.News;
import hotel.yun.news.service.News_Service;

@Controller
@RequestMapping("")
public class News_Controller {
	
	@Autowired
	News_Service service;
	
//	@PostMapping("/insertCustomer")
//	public String insertCustomerData(
//		@ModelAttribute News bean 
//		, BindingResult bindingResult 
//		) {
//		new CustomerValidator().validate(bean, bindingResult);
////		System.out.println("新增會員: " + bean);
//		    
//		if (bindingResult.hasErrors()) {
//			return "_01_customer/CustomerForm";
//		}
//
//		System.out.println("bean==>" + bean);
//		if (bean.getCustomerId() != null ) {
//			service.updateCustomer(bean);	
//		} 
//		bean.setRegisterTime(new Timestamp(System.currentTimeMillis()));
//		service.save(bean);
//		return "redirect:customers";
//	}
	
	//前端網頁按按鈕送出請求，()內是前端的東東
	@DeleteMapping(value="/modifyNews/{news_id}")
	public String deleteNew(@PathVariable int news_id) {
		service.delete(news_id);	
		return "redirect:../news";
	}

}
