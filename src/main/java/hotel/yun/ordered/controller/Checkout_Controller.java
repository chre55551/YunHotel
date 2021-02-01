package hotel.yun.ordered.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@PostMapping("/queryOrdered")
	public String queryOrdered(@RequestParam(value = "room_name") String room_name,
			@RequestParam(value = "rdateEnd") Date rdateEnd,
			@RequestParam(value = "roomnum_of_people") Integer roomnum_of_people,
			Model model, HttpSession session) {
		
		Room room = rser.queryRoomByName(room_name);
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(rdateEnd);
		c.add(Calendar.DAY_OF_MONTH, -1);
		Date lastUseDayd = (Date) c.getTime();
		Date lastUseDay = new java.sql.Date(lastUseDayd.getTime());
		Rdate rdate = dser.queryByRoomDate(lastUseDay);
		
		Ordered od = oser.queryOdByRoomAndRdate(room,rdate);
		model.addAttribute("od", od);
				return null;
	}
	
	@PostMapping("/room/checkout")
	public String checkoutRoom(@RequestParam(value = "roomnum_of_people") Integer roomnum_of_people,
			@RequestParam(value = "bill_status") String bill_status,
			Model model, HttpSession session) {
		 Ordered od = (Ordered)model.getAttribute("od");
		 od.getOrderedToRoom().setRoomnum_of_people((int)roomnum_of_people);
		 oser.room_checkout(od,bill_status);
		return null;
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
