package hotel.yun.news.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Customer;
import hotel.yun.news.model.News;
import hotel.yun.news.service.News_Service;
import hotel.yun.ordered.model.Ordered;


@Controller
@RequestMapping("/news")
//@SessionAttributes({ "news_id", "news_date", "news_updated_date", "news_content"})
public class News_Controller {
	
	@Autowired
	News_Service service;

	//後台
	@GetMapping("/newsindex")
	public String indexNews(Model model,HttpSession session){
		String kk = (String) session.getAttribute("BLoginOK");
		if (kk != null) {
		return "news/newsindex";
		} else {
			return "login/PleaseLoginInBS";
		}
	}

	//關於我們
	@GetMapping("/Aboutus")
	public String aboutus(Model model){
		return "news/Aboutus";
	}
//---------------------------------------------------------------
	@GetMapping("/showinsertNews")
	public String ShowNews(Model model) {
		News nw = new News();
		model.addAttribute("NWS", nw);
		return "news/AddNews";
	}
	@PostMapping("/insertNews")
	public String Insert(
			@RequestParam(value="news_date") Date news_date,
			@RequestParam(value="news_content") String news_content,
			Model model) {
		News nw=new News();
		nw.setNews_date(news_date);
		nw.setNews_content(news_content);
		News NWS=service.insert(nw);
		model.addAttribute("NWS", NWS);
		System.out.println("insert sucess");
		return "news/NewAddSucess";
}

//---------------------------------------------------------------
	@GetMapping("/queryNew")
	public String QueryNew(Model model,HttpSession session) {
		return "news/QueryNew";
	}	
	@PostMapping("/getaNew")
	public String GetaNew(@ModelAttribute("nws") News nw,Model model) {
		News news = service.queryNewID(nw.getNews_id());
		model.addAttribute("NWS", news);
		return "/news/GetaNew";
	}
	
	@GetMapping("/showAllNews")
	public String GetNews(Model model) {
		List<News> beans = service.queryAllNews();
		model.addAttribute(beans);      
		return "news/ShowNews";
	}
	
	@GetMapping("/outsideNews")
	public String OutsideNews(Model model) {
		List<News> beans = service.queryAllNews();
		model.addAttribute(beans);      
		return "news/outsideNews";
	}
//---------------------------------------------------------------
	@GetMapping("/update/{news_id}")
	public String update(Model model, @PathVariable int news_id) {
		News nw = service.queryNewID(news_id);
		model.addAttribute("UpdateNew", nw);
		return "news/UpdateNew";
	}
	@PostMapping("/update/{news_id}")
	public String modify(
		Model model,
		@PathVariable(value = "news_id", required = false) int news_id,
		@RequestParam(value = "news_date", required = false) Date news_date,
		@RequestParam(value = "news_updated_date", required = false) Date news_updated_date,
		@RequestParam(value = "news_content", required = false) String news_content,
		HttpServletRequest request) {
		News news = service.queryNewID(news_id);
		
		if(news.getNews_id() != 0) {
			news.setNews_updated_date(news_updated_date);
			news.setNews_content(news_content);
		}
		service.update(news);	
		
		model.addAttribute("news", news);
		return "redirect:../showAllNews";
	}

//---------------------------------------------------------------	
	@GetMapping("/DeleteNew/{news_id}")
	public String deleteNew(@PathVariable("news_id") int news_id) {
		service.delete(news_id);	
		System.out.println("delete sucess");
		return "redirect:/news/showAllNews";
	}
	
}
