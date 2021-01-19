package hotel.yun.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "BackstageIndex";
	}
	
	@GetMapping("/YunPage")
	public String fronthome() {
		return "Index";
	}
	
}
