package hotel.yun.meals2.controller;



import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//		@GetMapping("/outsideMeals2")
//		public String OutsideMeals2(Model model) {
//			List<Meals2> beans = service.queryAll();
//			model.addAttribute(beans);      
//			return "meals2/outsideMeals2";
//		}
	
		//---------------------------------------------------------------
		
		@GetMapping("/update/{meals2_id}")
		public String update(Model model, @PathVariable int meals2_id) {
			Meals2 ms = service.queryID(meals2_id);
			model.addAttribute("UpdateMeals2", ms);
			return "meals2/UpdateMeals2";
		}
		@PostMapping("/update/{meals2_id}")
		public String modify(
			Model model,
			@PathVariable(value = "meals2_id", required = false) int meals2_id,
			@RequestParam(value = "meals2_meals2_name", required = false) String meals2_name,
			@RequestParam(value = "meals2_meals2_type", required = false) String meals2_type,
			@RequestParam(value = "meals2_meals2_price", required = false) double meals2_price,
			@RequestParam(value = "meals2_meals2_stock", required = false) int meals2_stock,
			HttpServletRequest request) {
			Meals2 meals2 = service.queryID(meals2_id);
			
			if(meals2.getMeals2_id() != 0) {
				meals2.setMeals2_name(meals2_name);
				meals2.setMeals2_type(meals2_type);
				meals2.setMeals2_price(meals2_price);
				meals2.setMeals2_stock(meals2_stock);
				
			}
			service.update(meals2);	
			
			model.addAttribute("mes", meals2);
			return "redirect:../ShowMeals2";
		}
		
		

		
		
		
		
		
		
		
		
		
		
		//---------------------------------------------------------------
		
		@GetMapping("/DeleteMeals2/{meals2_id}")
		public String deleteMeals2(@PathVariable("meals2_id") int meals2_id) {
			service.delete(meals2_id);	
			System.out.println("delete sucess");
			return "redirect:/meals2/ShowMeals2";
		}
	
	
	
	
}
