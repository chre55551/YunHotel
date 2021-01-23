package hotel.yun.bmember.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.bmember.service.BmemberService;
import hotel.yun.news.model.News;
import hotel.yun.ordered.model.Ordered;

@Controller
@RequestMapping("/bmember")
//@SessionAttributes({ "bs_id", "bs_account", "bs_password", "bs_email", "authority", "user_id" })
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
		return "redirect:/InsertBmemberOK";

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
//	@GetMapping(value = "/mem/{id}")
//	public String showDataForm(@PathVariable("id") Integer id, Model model) {
//		BmemberBean member = BmemberBean.
//		model.addAttribute(member);
//		return "crm/updateMember";

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
}