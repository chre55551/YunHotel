package hotel.yun.customer.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Member;
import hotel.yun.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;

	}

	@Autowired
	CustomerService service;
//登入------------------------------------------------------------------------------------------------------

	@GetMapping("/Login")
	public String loginfromindex(Model model) {
		BmemberBean bm = new BmemberBean();
		model.addAttribute("bl", bm);
		return "customer/Login";
	}

	@PostMapping("/login")
	public String loginbutton(@RequestParam(value = "account") String ac, @RequestParam(value = "password") String pw,
			Model m, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("進來登入");
		System.out.println(ac);
		System.out.println(pw);
		Member mb = null;
		HttpSession session = request.getSession();
		mb = service.checkIdPassword(ac, pw);

		if (mb != null) {
			session.setAttribute("LoginOK", mb.getAccount());
//			session.setAttribute("Authority", mb.getAuthority());
			System.out.println("登入成功");
		} else {
			System.out.println("登入失敗");
			return "loginForm";
		}

		return "redirect: " + request.getContextPath();
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model, SessionStatus status, RedirectAttributes redirectAtt) {
		String name = "";
		System.out.println("Logout");
		BmemberBean memberBean = (BmemberBean) session.getAttribute("LoginOK");
		if (memberBean != null) {
			name = memberBean.getBs_account();
		} else {
			name = "訪客";
		}
		String farewellMessage = name + "已登出，期待您再次蒞臨本網站";
		redirectAtt.addFlashAttribute("logoutmessage", farewellMessage);
		// 登出時執行下列兩敘述

		status.setComplete();// 移除@SessionAttributes({"LoginOK"}) 標示的屬性物件

		session.invalidate();

		// 此敘述不能省略
		return "redirect:/";
	}


//------------------------------------------------------------------------------------------------
//註冊

	@GetMapping("/register")
	public String InsertBmemberBM(Model model, HttpSession session) {
		Member bm = new Member();
		model.addAttribute("cr", bm);
		return "customer/register";

	}

	@PostMapping("/registerOK")
	public String insert(@ModelAttribute("bb") BmemberBean bm, Model model, BindingResult result) {
		bm.getBs_account();
		bm.getBs_password();
		bm.getBs_email();
		bm.getAuthority();
		bm.getUser_id();
//	System.out.println(
//			bm.getBs_account() + bm.getBs_password() + bm.getBs_email() + bm.getAuthority() + bm.getUser_id());
//		service.insertM(bm);
		model.addAttribute("bb", bm);

		return "bmember/InsertBmemberOK";//
	}
}
