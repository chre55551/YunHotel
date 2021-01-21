package hotel.yun.bmember.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.bmember.model.bmemberbean;
import hotel.yun.bmember.service.BmemberService;
import hotel.yun.ordered.model.Ordered;

@Controller
@RequestMapping("/bmember")
@SessionAttributes({ "bs_id", "bs_account", "bs_password", "bs_email","authority","user_id"})
public class BmemberController {
	
	@Autowired
	ServletContext context;

	
	BmemberService service;
	
	@Autowired
	public BmemberService getService() {
		return service;
	}
	
	
	//後台
	@GetMapping("/IndexMember")
	public String indexMember(Model model){
		return "bmember/IndexMember";
	
	}
	//新增
		// 送出空白的Bean來接訂餐的屬性，Jsp input的name要對到DB的名稱
		@GetMapping("/InsertBmemberBM")
		public String ShowMealsOrdered( Model model) {
			bmemberbean bm = new bmemberbean();
			model.addAttribute("bmm", bm);
			return "bmember/InsertBmemberBM";
}
}