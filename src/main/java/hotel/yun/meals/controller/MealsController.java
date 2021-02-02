//package hotel.yun.meals.controller;
//
//
//
//import javax.servlet.ServletContext;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//
//import hotel.yun.meals.model.Meals;
//
//import hotel.yun.meals.service.MealsService;
//
//
//@Controller
//@RequestMapping("/meals")
//@SessionAttributes({ "meals_id", "meals_name", "meals_price", "meals_stock", "meals_image", "meals_typeid" })
//public class MealsController {
//     
//	@Autowired	
//	ServletContext context;
//
//	@Autowired
//	public void setContext(ServletContext context) {
//		this.context = context;
//	}
//
//	MealsService service;
//
//	@Autowired
//	public void setService(MealsService service) {
//		this.service = service;
//	}
//
////--------------------------------------------------------------------------
//	// 後台的進入點
//	@GetMapping("/IndexMeals")
//	public String IndexMeals(Model model) {
//		return "meals/IndexMeals";
//	}
//
//	// 官網的美食佳餚
//	@GetMapping("/Delicious")
//	public String Delicious(Model model) {
//		return "meals/Delicious";
//	}
////新增--------------------------------------------------------------------------
//
////	// 後台新增餐點先給空白表單
////	@GetMapping("/insertToMs")
////	public String insertMeals(Model model) {
////		Meals ms = new Meals();
////		model.addAttribute("mes", ms);
////		return "meals/insertToMs";
////	}
////	
////	//新增餐點資訊
////	@PostMapping("/InsertMeals")
////	public String insertToMeals(@RequestParam String meals_name, @RequestParam float meals_price,
////			@RequestParam String meals_stock, @RequestParam MultipartFile meals_image, @RequestParam String meals_type,
////			Model model) throws IOException {
////
////		byte[] img = meals_image.getBytes();
////		// String img_name = meals_image.getOriginalFilename();
////
////		try {
////			SerialBlob mi = new SerialBlob(img);
////
////			MealsType mtBean = new MealsType();
////			mtBean.setMeals_type(meals_type);
////
////			Meals mBean = new Meals(meals_name, meals_price, meals_stock, mi);
////			mBean.setMeals_type(mtBean);
////			service.save(mBean);
////			model.addAttribute("mes", mBean);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return "meals/insertToMeals";
////	}
////
//////查詢--------------------------------------------------------------------------
////	// 查詢所有餐點
////	@GetMapping("/QueryAllMeals")
////	public String QueryAllMeals(Model model) {
////		List<Meals> mm = service.queryAll();
////		model.addAttribute(mm);
////		return "meals/QueryAllMeals";
////	}
////	
////	
////
////	// -------------
////	// 送出空白表單
////	@GetMapping("/ShowQueryMealsForm")
////	public String ShowQueryMealsForm(Model model, HttpSession session) {
////		return "meals/ShowQueryMealsForm";
////	}
////
////	// 查詢餐點類型
////	@PostMapping("/ShowQueryMeals")
////	public String ShowQueryMeals(@ModelAttribute("mom") MealsType mt, Model model) {
////		MealsType mealsType = service.queryMealsType_id(mt.getMeals_typeid());
////		model.addAttribute("mom", mealsType);
////		return "meals/ShowQueryMeals";
////	}
////
////	// 取得圖片
////	@GetMapping("/getImg")
////	@ResponseBody
////	public byte[] getImg(@ModelAttribute("mom") Meals m, Model model) throws Exception {
////		Meals meals = service.queryMeals_id(m.getMeals_id());
////
////		return meals.getMeals_image().getBytes(1l, (int) meals.getMeals_image().length());
////	}
////
//////修改--------------------------------------------------------------------------
////	public String Update(Model model) {
////		return null;
////	}
////
//////刪除--------------------------------------------------------------------------
////	
////	//送出空白的表單
////	@GetMapping("/ShowDeleteMealsForm")
////	public String ShowDeleteMealsForm(Model model, HttpSession session) {
////		return "meals/ShowDeleteMealsForm";
////	}
////	
////	//執行刪除後回到查詢
////	@GetMapping("/")
////	public String DeleteMeals(@PathVariable Integer meals_id) {
////		System.err.println("刪除成功");
////		service.delete(meals_id);
////		return "meals/ShowQueryMeals";
////	}
//	// 查詢所有房型
//	
//	
//	
//	
//	//自己改的
//	
////	@GetMapping("/QueryAllMeals")
////	public String QueryAllMeals(Model model) {
////		List<Meals> ms = service.queryAll();
////		model.addAttribute(ms);
//////		model.addAttribute("mes", ms);
////		return "meals/QueryAllMeals";
////	}
////	
////
////	// 送出空白查詢表單
////	@GetMapping("/ShowBlankQueryMealsForm")
////	public String ShowBlankQueryMealsForm(Model model, HttpSession session) {
////		return "meals/ShowBlankQueryMealsForm";
////	}
////	
////	
////	// 查詢單筆餐點
////	@PostMapping("/ShowQueryMeals")
////	public String ShowQueryMeals(@ModelAttribute("mes") Meals ms, Model model) {
////		Meals meals = service.queryMeals_id(ms.getMeals_id());
////		model.addAttribute("mes", meals);
////		
//////		MultipartFile picture = (MultipartFile) roomtype.getRoom_image();
//////		model.addAttribute("img", picture);
////		return "meals/ShowQueryMeals";
////	}
////	
////
////	// 送出空白新增表單
////	@GetMapping("/ShowBlankInsertMealsForm")
////	public String ShowBlankInsertMealsForm(Model model) {
////		Meals mes = new Meals();
////		model.addAttribute("mes", mes);
////		return "meals/ShowBlankInsertMealsForm";
////	}
////	
////	@PostMapping("/InsertMeals")
////	public String InsertMeals(
////			@RequestParam String meals_name, 
////			@RequestParam double meals_price,
////			@RequestParam String meals_stock
////			
////			)
////		 {
////		System.out.println(meals_name);
////		System.out.println(meals_price);
////		System.out.println(meals_stock);
////		
////
////
////		return "meals/ShowInsertMeals";
////	}
////	
//	@GetMapping("/ShowBlankInsertMealsForm")
//	public String ShowBlankInsertMealsForms(Model model) {
//		Meals ms = new Meals();
//		model.addAttribute("mes", ms);
//		return "meals/ShowBlankInsertMealsForm";
//	}
//	@PostMapping("/InsertMeals")
//	public String InsertMeals(
//			@RequestParam(value="meals_name") String meals_name,
//			@RequestParam(value="meals_price") double meals_price,
//			@RequestParam(value="meals_stock") String meals_stock,
//			Model model) {
//		Meals ms =new Meals();
//		ms.setMeals_name(meals_name);
//		ms.setMeals_price(meals_price);
//		ms.setMeals_stock(meals_stock);
//		Meals mes = service.save(ms);
//		model.addAttribute("mes", mes);
//		System.out.println("insert sucess");
//		return "meals/ShowInsertMeals";
//}
//
//	
//	
//	
//}
