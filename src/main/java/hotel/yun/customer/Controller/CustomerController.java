package hotel.yun.customer.Controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

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
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.model.Rdate;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.room.model.Room;

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
	public String InserMember(Model model, HttpSession session) {
		Member bm = new Member();
		model.addAttribute("cr", bm);
		return "customer/register";

	}

	@PostMapping("/registerOK")
	public String insertMember(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "idcard_number") String idcard_number,
			@RequestParam(value = "mobile_phone") String mobile_phone, @RequestParam(value = "birthday") Date birthday,
			@RequestParam(value = "address") String address, @RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password, @RequestParam(value = "gender") String gender,
			@RequestParam(value = "home_phone") String home_phone, @RequestParam(value = "job") String job,
			@RequestParam(value = "email") String email, Model model) {
				
		Customer c = new Customer( chinese_name,  idcard_number,birthday, address, mobile_phone);
		Member m = new Member(account,password,gender,home_phone,job,email);
		c.setChinese_name(chinese_name);
		c.setIdcard_number(idcard_number);
		c.setBirthday(birthday);
		c.setAddress(address);
		c.setMobile_phone(mobile_phone);
		Customer rc = service.insertC(c);
		model.addAttribute("rcc", rc);
		
		m.setAccount(account);
		m.setPassword(password);
		m.setGender(gender);
		m.setHome_phone(home_phone);
		m.setJob(job);
		m.setEmail(email);
		Member rm = service.insertM(m);
		model.addAttribute("rmm",rm);
		
		
		
		
		return "customer/registerOK";

	}
}
