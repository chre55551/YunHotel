package hotel.yun.room.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/")
public class RoomController {

	ServletContext context;
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	RoomService service;
	
	
	@Autowired
	public void setService(RoomService service) {
		this.service = service;
	}
}
