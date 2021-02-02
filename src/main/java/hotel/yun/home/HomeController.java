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
	
	
	//測試用
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/OtherFacilities")
	public String OtherFacilities() {
		return "OtherFacilities";
	}
	
}
