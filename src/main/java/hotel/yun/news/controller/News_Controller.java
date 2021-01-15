package hotel.yun.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.yun.news.model.News;
import hotel.yun.news.service.News_Service;

@Controller
@RequestMapping("")
public class News_Controller {
	
	@Autowired
	News_Service service;
	
	@GetMapping("/ShowNews")
	public String getNews(Model model) {
		List<News> beans = service.queryAllNews();
		model.addAttribute(beans);      
		System.out.println("queryAllNews...");
		return "news/News";
	}
	
	//前端網頁按按鈕送出請求，()內是前端的東東
	@DeleteMapping(value="/modifyNews/{news_id}")
	public String deleteNew(@PathVariable int news_id) {
		service.delete(news_id);	
		return "redirect:news/News";
	}

}
