package hotel.yun.login.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.bmember.service.BmemberService;
import hotel.yun.login.model.LoginBean;



@Controller
@RequestMapping("/login")
@SessionAttributes({ "LoginOK" })
public class LoginController {
	
	ServletContext context;
	@Autowired
	BmemberService ms;

	@GetMapping("/BLogin")
	public String loginfromindex(Model model) {
		BmemberBean bm = new BmemberBean();
		model.addAttribute("bl", bm);
		return "login/BLogin";
	}

	@PostMapping("/login")
	public String loginbutton(@ModelAttribute("bl") LoginBean lb, Model m, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("進來登入");
		BmemberBean mb = null;
		HttpSession session = request.getSession();
		mb = ms.checkIdPassword(lb.getAccount(), lb.getPassword());

		if (mb != null) {
			m.addAttribute("LoginOK", mb);
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
}