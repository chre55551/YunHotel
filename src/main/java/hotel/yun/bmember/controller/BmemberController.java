package hotel.yun.bmember.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.bmember.service.BmemberService;
import hotel.yun.login.model.LoginBean;
import hotel.yun.news.model.News;
import hotel.yun.ordered.model.Ordered;

@Controller
@RequestMapping("/bmember")
@SessionAttributes({ "bs_id", "bs_account", "bs_password", "bs_email", "authority", "user_id" })
public class BmemberController {

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	BmemberService service;

//	@Autowired
//	public BmemberService getService() {
//		return service;
//	}

	// 後台
	@GetMapping("/IndexMember")
	public String indexMember(Model model) {
		return "bmember/IndexMember";

	}
//------------------------------------------------------------------------------------------------------
	// 新增

	@GetMapping("/InsertBmemberBM")
	public String InsertBmemberBM(Model model) {
		BmemberBean bm = new BmemberBean();
		model.addAttribute("bb", bm);
		return "bmember/InsertBmemberBM";
	}

	@PostMapping("/insertbmemberbb")
	public String insert(@ModelAttribute("bb") BmemberBean bm, Model model, BindingResult result) {
		bm.getBs_account();
		bm.getBs_password();
		bm.getBs_email();
		bm.getAuthority();
		bm.getUser_id();
		System.out.println(
				bm.getBs_account() + bm.getBs_password() + bm.getBs_email() + bm.getAuthority() + bm.getUser_id());
		service.insert(bm);

		return "bmember/InsertBmemberOK";//
	}

//------------------------------------------------------------------------------------------------
	// 刪除
	@DeleteMapping("/DeleteBmember/{bs_id}")
	public String delete(@PathVariable("bs_id") int bs_id) {
		service.delete(bs_id);
		return "redirect:/GetaBmember";

	}

//----------------------------------------------------------------------------------------------------
	// 顯示所有會員
	@GetMapping("/showAllMembers")
	public String list(Model model) {
		model.addAttribute("members", service.queryAllMember());
		return "/ShowBmember";
	}

//-----------------------------------------------------------------------------------------------------
	// 修改
	@PostMapping("/UpdateBmember/{Bs_id}")
	public String update(@ModelAttribute("bb") BmemberBean bm,Model model) {
		BmemberBean bb = service.queryMemberID(bm.getBs_id());
		bb.setBs_id(bb.getBs_id());
		bb.setBs_account(bb.getBs_account());
		bb.setBs_password(bb.getBs_password());
		bb.setBs_email(bb.getBs_email());
		bb.setBs_account(bb.getBs_account());
		bb.setAuthority(bb.getAuthority());
		bb.setUser_id(bb.getUser_id());
		
		BmemberBean ubm = service.update(bb);
		model.addAttribute("qbm", ubm);
		return "/bmember/GetaBmember";
	}
//------------------------------------------------------------------------------------------------------

	// 查詢

	@GetMapping("/QueryBmember")
	public String QueryNew(Model model, HttpSession session) {
		return "bmember/QueryBmember";
	}

	@PostMapping("/GetaBmember")
	public String GetaNew(@RequestParam("bs_account") int bs_account, Model model) {
		BmemberBean bb = service.queryMemberID(bs_account);
		System.out.println(bb.getBs_id());
		model.addAttribute("qbm", bb);
		return "/bmember/GetaBmember";
	}
	
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
		mb = service.checkIdPassword(lb.getAccount(), lb.getPassword());

		if (mb != null) {
			session.setAttribute("LoginOK", mb);
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