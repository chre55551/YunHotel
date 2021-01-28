package hotel.yun.meals.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import hotel.yun.meals.model.Meals;
import hotel.yun.meals.model.MealsType;
import hotel.yun.meals.service.MealsService;
import hotel.yun.room.model.RoomType;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/meals")
@SessionAttributes({ "meals_id", "meals_name", "meals_price", "meals_stock", "meals_image", "meals_typeid" })
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

//--------------------------------------------------------------------------
	// 後台的進入點
	@GetMapping("/IndexMeals")
	public String IndexMeals(Model model) {
		return "meals/IndexMeals";
	}

	// 官網的美食佳餚
	@GetMapping("/Delicious")
	public String Delicious(Model model) {
		return "meals/Delicious";
	}
//新增--------------------------------------------------------------------------

//	// 後台新增餐點先給空白表單
//	@GetMapping("/insertToMs")
//	public String insertMeals(Model model) {
//		Meals ms = new Meals();
//		model.addAttribute("mes", ms);
//		return "meals/insertToMs";
//	}
//	
//	//新增餐點資訊
//	@PostMapping("/InsertMeals")
//	public String insertToMeals(@RequestParam String meals_name, @RequestParam float meals_price,
//			@RequestParam String meals_stock, @RequestParam MultipartFile meals_image, @RequestParam String meals_type,
//			Model model) throws IOException {
//
//		byte[] img = meals_image.getBytes();
//		// String img_name = meals_image.getOriginalFilename();
//
//		try {
//			SerialBlob mi = new SerialBlob(img);
//
//			MealsType mtBean = new MealsType();
//			mtBean.setMeals_type(meals_type);
//
//			Meals mBean = new Meals(meals_name, meals_price, meals_stock, mi);
//			mBean.setMeals_type(mtBean);
//			service.save(mBean);
//			model.addAttribute("mes", mBean);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "meals/insertToMeals";
//	}
//
////查詢--------------------------------------------------------------------------
//	// 查詢所有餐點
//	@GetMapping("/QueryAllMeals")
//	public String QueryAllMeals(Model model) {
//		List<Meals> mm = service.queryAll();
//		model.addAttribute(mm);
//		return "meals/QueryAllMeals";
//	}
//	
//	
//
//	// -------------
//	// 送出空白表單
//	@GetMapping("/ShowQueryMealsForm")
//	public String ShowQueryMealsForm(Model model, HttpSession session) {
//		return "meals/ShowQueryMealsForm";
//	}
//
//	// 查詢餐點類型
//	@PostMapping("/ShowQueryMeals")
//	public String ShowQueryMeals(@ModelAttribute("mom") MealsType mt, Model model) {
//		MealsType mealsType = service.queryMealsType_id(mt.getMeals_typeid());
//		model.addAttribute("mom", mealsType);
//		return "meals/ShowQueryMeals";
//	}
//
//	// 取得圖片
//	@GetMapping("/getImg")
//	@ResponseBody
//	public byte[] getImg(@ModelAttribute("mom") Meals m, Model model) throws Exception {
//		Meals meals = service.queryMeals_id(m.getMeals_id());
//
//		return meals.getMeals_image().getBytes(1l, (int) meals.getMeals_image().length());
//	}
//
////修改--------------------------------------------------------------------------
//	public String Update(Model model) {
//		return null;
//	}
//
////刪除--------------------------------------------------------------------------
//	
//	//送出空白的表單
//	@GetMapping("/ShowDeleteMealsForm")
//	public String ShowDeleteMealsForm(Model model, HttpSession session) {
//		return "meals/ShowDeleteMealsForm";
//	}
//	
//	//執行刪除後回到查詢
//	@GetMapping("/")
//	public String DeleteMeals(@PathVariable Integer meals_id) {
//		System.err.println("刪除成功");
//		service.delete(meals_id);
//		return "meals/ShowQueryMeals";
//	}
	// 查詢所有房型
	@GetMapping("/QueryAllMeals")
	public String QueryAllRooms(Model model) {
		List<Meals> rm = service.queryAll();
		model.addAttribute(rm);
//		model.addAttribute("rom", rm);
		return "meals/QueryAllMeals";
	}
}
