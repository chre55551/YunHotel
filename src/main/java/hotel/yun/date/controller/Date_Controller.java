package hotel.yun.date.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.date.service.Date_Service;

@Controller
@RequestMapping("/date")
public class Date_Controller {

	@Autowired
	Date_Service dservice;
}
