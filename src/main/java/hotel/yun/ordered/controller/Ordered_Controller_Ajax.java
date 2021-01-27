package hotel.yun.ordered.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;
import hotel.yun.date.model.Rdate;
import hotel.yun.date.service.Date_Service;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.model.Room;
import hotel.yun.room.service.RoomService;
import hotel.yun.room.util.RoomSort;

@Controller
@RequestMapping("/ordered")
@SessionAttributes({ "order_number", "customer_id", "ordered_tomeals_id", "ordered_toroom_id", "status_id",
		"payment_id" })
public class Ordered_Controller_Ajax {
	
	@Autowired
	ServletContext context;

	@Autowired
	Ordered_Service service;

	@Autowired
	RoomService rser;

	@Autowired
	CustomerService cser;

	@Autowired
	Date_Service dser;
	
	//-----------------以上是屬性--------------------

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出已成立~~~~~~~~~~~~~~~~~
	@GetMapping("/customerToOrdered/orderedCreated")
	public @ResponseBody List<Ordered> orderedCreatedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status,
			Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		System.out.println(c.getChinese_name());
		try {
			Customer customer = cser.query(c);
			System.out.println(customer.getChinese_name());
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
//			System.out.println(CustomerOrdered.get(0).getOrderedToRoom().getRdates().get(0).getRdate());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for (Ordered o : CustomerOrdered) {
				if (o.getOrderedStatus().getStatus_id() == 1) {
					returnlist.add(o);
				}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出已結單~~~~~~~~~~~~~~~~~~~
	@GetMapping("/customerToOrdered/orderedFinished")
	public @ResponseBody List<Ordered> orderedFinishedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status,
			Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for (Ordered o : CustomerOrdered) {
				if (o.getOrderedStatus().getOrdered_status() == "已結單") {
					returnlist.add(o);
				}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出      全部訂單~~~~~~~~~~~~~~~
	@GetMapping("/customerToOrdered/orderedAll")
	public @ResponseBody List<Ordered> orderedAllAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status,
			Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			return CustomerOrdered;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Ajax 根據房型找出所有房間
	@GetMapping("/roomtype/to/allrooms")
	public @ResponseBody List<Room> roomTypeToSllRooms(@RequestParam(value = "room_type") String room_type,
			Model model, HttpSession session) {
			Set<Room> ugly = rser.queryAllRoomByRoomType(room_type);
			List<Room> beauty= new ArrayList<Room>();
			for(Room r:ugly) {
				beauty.add(r);
			}
			Collections.sort(beauty,new RoomSort());
		return beauty;
	}
	
	
	
	// Ajax 根據日期房型查出所有可用的房間
	@PostMapping("/roomtype/to/availablerooms")
	public @ResponseBody Set<Room> roomTypeToAvailableRooms(@RequestParam(value = "room_type") String room_type,
			@RequestParam(value = "rdate") Date rdate,
			Model model, HttpSession session) {
		try {
			Set<Room>[] array = new Set[2];
			Set<Room> list = new HashSet<>();//先創一個空的 list 後續會用於儲存可使用的房間
			Set<Room> rooms = rser.queryAllRoomByRoomType(room_type);//根據輸入的房型去撈出所有房間
			for(Room room:rooms) {//每一間房間
				boolean room_is_space = true;//預設此房間為空
				Set<Rdate> room_rdates = room.getRdates();//單間房間撈出的所有已經訂房的時段
				for(Rdate rd:room_rdates) {//那間房間的每個已定的時段
					if(rd.getRdate()==rdate) {//判斷該時段是否有人訂房
						room_is_space = false;//若有 room_is_space 為 false
					}
				}
				if(room_is_space) {//若該房間為空 將其加入list
					list.add(room);
					array[0]=rooms;
					array[1]=list;
				}
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 
	
}
