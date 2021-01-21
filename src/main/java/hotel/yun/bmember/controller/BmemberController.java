package hotel.yun.bmember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.bmember.service.BmemberService;

@Controller
@RequestMapping("/bmember")
@SessionAttributes({ "bs_id", "bs_account", "bs_password", "bs_email","authority","user_id"})
public class BmemberController {
	

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
}