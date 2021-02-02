package hotel.yun.meals2.controller;



import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.yun.meals2.model.Meals2;
import hotel.yun.meals2.service.Meals2_Service;
import hotel.yun.news.model.News;



@Controller
@RequestMapping("/meals2")
public class Meals2_Controller {
	
	@Autowired	
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	Meals2_Service service;
	
	
	@Autowired
	public void setService(Meals2_Service service) {
		this.service = service;
	}
	
//--------------------------------------------------------------------------------------	
	// 後台的進入點
	@GetMapping("/IndexMeals2")
	public String IndexMeals2(Model model) {
		return "meals2/IndexMeals2";

	}
	
	
	@GetMapping("/AddMeals2")
	public String ShowMeals2(Model model) {
		Meals2 ms = new Meals2();
		model.addAttribute("MES", ms);
		return "meals2/AddMeals2";
	}
	@PostMapping("/insertMeals2")
	public String Insert(
			@RequestParam(value="meals2_type") String meals2_type,
			@RequestParam(value="meals2_name") String meals2_name,
			@RequestParam(value="meals2_price") double meals2_price,
			@RequestParam(value="meals2_stock") int    meals2_stock,
			Model model) {
		Meals2 ms=new Meals2();
		ms.setMeals2_type(meals2_type);
		ms.setMeals2_name(meals2_name);
		ms.setMeals2_price(meals2_price);
		ms.setMeals2_stock(meals2_stock);
		
		Meals2 MES = service.insert(ms);
		model.addAttribute("MES", MES);
		System.out.println("insert sucess");
		return "meals2/Meals2AddSucess";
}
	
	
	//---------------------------------------------------------------
		@GetMapping("/queryMeals2")
		public String Meals2(Model model,HttpSession session) {
			return "news/QueryMeals2";
		}	
		@PostMapping("/getaMeals2")
		public String GetaNew(@ModelAttribute("mes") Meals2 ms,Model model) {
			Meals2 meals2 = service.queryID(ms.getMeals2_id());
			model.addAttribute("MES", meals2);
			return "/meals2/GetaMeals";
		}
		
		@GetMapping("/ShowMeals2")
		public String GetMeals2(Model model) {
			List<Meals2> beans = service.queryAll();
			model.addAttribute(beans);      
			return "meals2/ShowMeals2";
		}
	
		@GetMapping("/outsideMeals2")
		public String OutsideMeals2(Model model) {
			List<Meals2> beans = service.queryAll();
			model.addAttribute(beans);      
			return "meals2/outsideMeals2";
		}
	
	
	
	
	
	
}
