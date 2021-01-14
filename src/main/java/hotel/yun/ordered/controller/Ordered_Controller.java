package hotel.yun.ordered.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;

@Controller
@RequestMapping("/hotel.yun.ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller {

	@Autowired
	ServletContext context;

	@Autowired
	Ordered_Service service;

	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping("/ShowOrdered")
	public String ShowOrdered(Model model) {
		Ordered od = new Ordered();
		model.addAttribute("ordered", od);
		return "ordered/InsertOrdered";
	}
	// 讓使用者輸入
	@PostMapping("/ShowOrdered")
	public String insert(@ModelAttribute("od") Ordered od, Model model) {
		service.insert(od);
		return "redirect";
	}

	// 從訂單編號刪除一筆訂單
	@DeleteMapping("/ShowOrdered/{ordered_number}")
	public String delete(@PathVariable("ordered_number") int ordered_number) {
		service.delete(ordered_number);
		return "redirect:/ShowOrdered";
	}
}
