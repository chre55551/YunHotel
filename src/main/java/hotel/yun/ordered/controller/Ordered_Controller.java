package hotel.yun.ordered.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;

@Controller
@RequestMapping("")
public class Ordered_Controller {
	
	@Autowired
	ServletContext context;
	
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	Ordered_Service service;

	public void setService(Ordered_Service service) {
		this.service = service;
	}
}
