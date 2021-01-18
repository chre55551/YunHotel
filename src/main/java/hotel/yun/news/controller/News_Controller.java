package hotel.yun.news.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.news.model.News;
import hotel.yun.news.service.News_Service;

@Controller
@RequestMapping("/hotel.yun.news")
@SessionAttributes({ "news_id", "news_date", "news_updated_date", "news_content"})
public class News_Controller {
	
	@Autowired
	News_Service service;
	//@Autowired
	News nw;
	
	@PostMapping("/insertNews")
	public String Insert(@ModelAttribute("nws") News nw, Model model,HttpServletRequest request,BindingResult result) {
		service.insert(nw);
		return "news/GetaNew";
	}
	
	@PostMapping("/getaNew")
	public String GetaNew(@ModelAttribute("nws") News nw,Model model) {
		News news = service.queryNewID(nw.getNews_id());
		model.addAttribute("GetaNew", news);
		return "/news/GetaNew";
	}
	
	@GetMapping("/showNews")
	public String GetNews(Model model) {
		List<News> beans = service.queryAllNews();
		model.addAttribute(beans);      
		System.out.println("queryAllNews...");
		return "news/GetAllNews";
	}
	
	@PostMapping("/getaNew/{news_id}")
	public String update(@ModelAttribute("nws") News nw,Model model) {
		News thenew = service.queryNewID(nw.getNews_id());
		thenew.setNews_id(thenew.getNews_id());
		thenew.setNews_date(thenew.getNews_date());
		thenew.setNews_updated_date(thenew.getNews_updated_date());
		thenew.setNews_content(thenew.getNews_content());
		
		News afternew = service.update(thenew);
		model.addAttribute("updatenew", afternew);
		return "/news/GetaNew";
	}

	
	//前端網頁按按鈕送出請求，()內是前端的東東
	@DeleteMapping("/DeleteNew/{news_id}")
	public String deleteNew(@PathVariable int news_id) {
		service.delete(news_id);	
		return "redirect:news/GetAllNews";
	}

}
