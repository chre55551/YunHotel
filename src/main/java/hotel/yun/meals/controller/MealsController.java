package hotel.yun.meals.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.meals.service.MealsService;


@Controller
@RequestMapping("/")
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
}
