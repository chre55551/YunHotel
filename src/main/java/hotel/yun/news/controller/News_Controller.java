package hotel.yun.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.news.service.News_Service;

@Controller
@RequestMapping("")
public class News_Controller {

	News_Service service;
	

}
