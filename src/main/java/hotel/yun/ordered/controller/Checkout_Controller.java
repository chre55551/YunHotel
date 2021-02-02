package hotel.yun.ordered.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.model.Rdate;
import hotel.yun.date.service.Date_Service;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.model.Room;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/checkout")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Checkout_Controller {

	@Autowired
	ServletContext context;

	@Autowired
	Ordered_Service oser;

	@Autowired
	RoomService rser;

	@Autowired
	CustomerService cser;

	@Autowired
	Date_Service dser;
	
	//--------------------------------------------------------------------------------------------------
	//一個可以輸入房號跟退房日期的頁面，點查詢後跳轉
	@GetMapping("/checkoutQueryRoomOd")
	public String queryCustcheck(Model model, HttpSession session) {
		return "ordered/checkoutQueryRoomOd";
	}
	//跳轉後，可以從房號查到該張訂單的詳細資訊
	@PostMapping("/checkoutRoomOd")
	public String queryOrdered(@RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "rdateEnd") Date rdateEnd,
//			@RequestParam(value = "roomnum_of_people") Integer roomnum_of_people,
			Model model, HttpSession session) {
		
		Room room = rser.queryRoomByName(room_name);
		Calendar c = Calendar.getInstance(); 
		c.setTime(rdateEnd);
		c.add(Calendar.DAY_OF_MONTH, -1);
//		java.util.Date d = c.getTime();
//		java.sql.Date(ud.getTime())
		Date lastUseDay =new  java.sql.Date(c.getTime().getTime());
//		Date lastUseDay = new java.sql.Date(lastUseDayd.getTime());
		Rdate rdate = dser.queryByRoomDate(lastUseDay);
		
		Ordered od = oser.queryOdByRoomAndRdate(room,rdate);
		System.out.println(od.getOrdered_number());
		System.out.println(od.getOrdered_number());
		System.out.println(od.getOrdered_number());
		System.out.println(od.getOrdered_number());
		System.out.println(od.getOrderedToRoom().getRdates());
		System.out.println(od.getOrderedToRoom().getRdates());
		System.out.println(od.getOrderedToRoom().getRdates());
		System.out.println(od.getOrderedToRoom().getRdates());
//		return "ordered/checkoutQueryRoomOd";
		model.addAttribute("od", od);
		model.addAttribute("room", od.getOrderedToRoom().getRoom());//房間
		model.addAttribute("rdates", od.getOrderedToRoom().getRdates());//退房日期
				return "ordered/checkoutRoomOd";
	}
	//開始做結帳，只需修改付款狀態跟確認訂房人數而已
	@PostMapping("/room/checkoutUpdate")
	public String checkoutRoom(@RequestParam(value = "roomnum_of_people") Integer roomnum_of_people,
			@RequestParam(value = "bill_status") String bill_status,
			Model model, HttpSession session) {
		 Ordered od = (Ordered)model.getAttribute("od");
		 od.getOrderedToRoom().setRoomnum_of_people((int)roomnum_of_people);
		 oser.room_checkout(od,bill_status);
		return "ordered/checkoutUpdate";
	}
	
	@PostMapping("/meals/checkout")
	public String checkoutRoom(Model model, HttpSession session) {
		
		return null;
	}
	
	@PostMapping("/test")
	public @ResponseBody Ordered checkOutRoomTest(@RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "rdateEnd") Date rdateEnd,
			@RequestParam(value = "roomnum_of_people",required = false) Integer roomnum_of_people,
			Model model, HttpSession session) {
		
		Room room = rser.queryRoomByName(room_name);
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(rdateEnd);
		c.add(Calendar.DAY_OF_MONTH, -1);
		java.util.Date lastUseDayd = c.getTime();
		Date lastUseDay = new java.sql.Date(lastUseDayd.getTime());
		Rdate rdate = dser.queryByRoomDate(lastUseDay);
		
		Ordered od = oser.queryOdByRoomAndRdate(room,rdate);
//		model.addAttribute("od", od);
				return od;
	}
	
}
