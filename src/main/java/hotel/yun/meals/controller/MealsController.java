package hotel.yun.meals.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.meals.service.MealsService;


@Controller
@RequestMapping("/meals")
@SessionAttributes({ "meals_id", "meals_name", "meals_price", "meals_stock", "meals_image", "meals_typeid"})
public class MealsController {
	ServletContext context;
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	MealsService service;
	
	
	@Autowired
	public void setService(MealsService service) {
		this.service = service;
	}
	
	//後台的進入點
	@GetMapping("/IndexMeals")
	public String IndexMeals(Model model){
		return "room/IndexMeals";
	
	}
	
	//官網的美食佳餚
	@GetMapping("/Delicious")
	public String RoomIntroduction(Model model){
		return "meals/Delicious";
	
	}
}
