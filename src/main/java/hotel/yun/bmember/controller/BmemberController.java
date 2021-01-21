package hotel.yun.bmember.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.bmember.model.bmemberbean;
import hotel.yun.bmember.service.BmemberService;

@Controller
@RequestMapping("/bmember")
@SessionAttributes({ "bs_id", "bs_account", "bs_password", "bs_email", "authority", "user_id" })
public class BmemberController {

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	BmemberService service;

	@Autowired
	public BmemberService getService() {
		return service;
	}

	// 後台
	@GetMapping("/IndexMember")
	public String indexMember(Model model) {
		return "bmember/IndexMember";

	}
//------------------------------------------------------------------------------------------------------
	// 新增

	@GetMapping("/InsertBmemberBM")
	public String InsertBmemberBM(Model model) {
		bmemberbean bm = new bmemberbean();
		model.addAttribute("bmm", bm);
		return "bmember/InsertBmemberBM";
	}

	@PostMapping("/InsertBmemberBB")
	public String Insert(@RequestParam(value = "bs_account") String bs_account,
			@RequestParam(value = "bs_password") String bs_password, @RequestParam(value = "bs_email") String bs_email,
			@RequestParam(value = "authority") String authority, @RequestParam(value = "user_id") String user_id,
			Model model) {
		bmemberbean BM = new bmemberbean();
		BM.setBs_account(bs_account);
		BM.setBs_password(bs_password);
		BM.setBs_email(bs_email);
		BM.setAuthority(authority);
		BM.setUser_id(user_id);
		bmemberbean BMS = service.insert(BM);
		model.addAttribute("BMS", BMS);
		return "bmember/InsertBmemberOK";

	}
	
	

//------------------------------------------------------------------------------------------------
	// 刪除
	@DeleteMapping(value = "/DeleteBmember/{bs_id}")
	public String delete(@PathVariable("bs_id") int bs_id) {
		service.delete(bs_id);
		return "redirect:/InsertBmemberOK";

	}
//----------------------------------------------------------------------------------------------------
	// 顯示所有會員
	@GetMapping("/Bmembers")
	public String getCustomers(Model model) {
		List<bmemberbean> beans = service.queryAllMember();
		model.addAttribute(beans);

		return "bmember/ShowBmember";
	}

}
