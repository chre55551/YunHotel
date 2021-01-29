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

import org.joda.time.DateTime;
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
	@PostMapping("/customerToOrdered/orderedCreated")
	public @ResponseBody List<Ordered> orderedCreatedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status" ,required = false) String ordered_status,
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
//				if (o.getOrderedStatus().getOrdered_status() == "已成立") 
				{
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
	@PostMapping("/customerToOrdered/orderedFinished")
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
	@PostMapping("/customerToOrdered/orderedAll")
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
	public @ResponseBody List<Room> roomTypeToAvailableRooms(@RequestParam(value = "room_type") String room_type,
			@RequestParam(value = "rdate") Date rdate,
			@RequestParam(value = "rdateEnd") Date rdateEnd,
			Model model, HttpSession session) {
		DateTime rdateDT = DateToDateTime(rdate);
		DateTime rdateEndDT = DateToDateTime(rdateEnd);
		Set<DateTime> range = getDateRange(rdateDT,rdateEndDT);//產生 入住日期至退房日期的所有日期
		Set<Rdate> rdates = dateTimeSetToRdateSet(range);
		

		try {
//			Set<Room>[] array = new Set[2];
			List<Room> list = new ArrayList<>();//先創一個空的 list 後續會用於儲存可使用的房間
			Set<Room> rooms = rser.queryAllRoomByRoomType(room_type);//根據輸入的房型去撈出所有房間
			for(Room room:rooms) {//每一間房間
				System.out.println(room.getRoom_name());
				System.out.println("puipui");
				System.out.println(room.getRoom_name());
				System.out.println("puipui");
				System.out.println(room.getRoom_name());
				System.out.println("puipui");
				System.out.println(room.getRoom_name());
				boolean room_is_space = true;//預設此房間為可以使用
				Set<Rdate> room_rdates = room.getRdates();//單間房間撈出的所有已經訂房的時段
				for(Rdate rd:room_rdates) {//那間房間的每個已定的時段
					for(Rdate rda:rdates) {//撈出他要訂的每一天
						int i = rd.getRdate().compareTo(rda.getRdate());
						if(i==0) {//若是有欲訂的任何一天與房間的已訂時間重覆，則房間不能使用
							room_is_space = false;
						}
					}				
//					if(rd.getRdate()==rdate) {//判斷該時段是否有人訂房
//						room_is_space = false;//若有 room_is_space 為 false
//						
//					}
				}
				if(room_is_space) {//若該房間可以使用 將其加入list
					list.add(room);
				}
			}
			Collections.sort(list,new RoomSort());
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//---------------------------------------------------------------------------------------------------------------------
	
	// 寫在前台需要從顧客查詢到他的訂單 AJAX 取出已成立~~~~~~~~~~~~~~~~~
	@PostMapping("/outsideCustomerToOrdered/orderedCreated")
	public @ResponseBody List<Ordered> outsideOrderedCreatedAjax(@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status" ,required = false) String ordered_status,
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
//				if (o.getOrderedStatus().getOrdered_status() == "已成立") 
		//		{
					returnlist.add(o);
		//		}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出已結單~~~~~~~~~~~~~~~~~~~
	@PostMapping("/outsideCustomerToOrdered/orderedFinished")
	public @ResponseBody List<Ordered> outsideOrderedFinishedAjax(
			@RequestParam(value = "chinese_name") String chinese_name,
			@RequestParam(value = "mobile_phone") String mobile_phone,
			@RequestParam(value = "ordered_status") String ordered_status,
			Model model, HttpSession session) {
		Customer c = new Customer(chinese_name, mobile_phone);
		try {
			Customer customer = cser.query(c);
			List<Ordered> CustomerOrdered = service.queryCustomerToOrdered(customer.getCustomer_id());
			List<Ordered> returnlist = new ArrayList<Ordered>();
			for (Ordered o : CustomerOrdered) {
			//	if (o.getOrderedStatus().getOrdered_status() == "已結單") {
					returnlist.add(o);
				//}
			}
			return returnlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 寫在後台需要從顧客查詢到他的訂單 AJAX 取出      全部訂單~~~~~~~~~~~~~~~
	@PostMapping("/outsideCustomerToOrdered/orderedAll")
	public @ResponseBody List<Ordered> outsideOrderedAllAjax(
			@RequestParam(value = "chinese_name") String chinese_name,
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
	
//---------------------------------------------------------------------------------------------------------------------
	public DateTime DateToDateTime(Date d) {
		String str = d.toString();
		return DateTime.parse(str);
	}
    public Set<DateTime> getDateRange(DateTime start, DateTime end) {
        Set<DateTime> ret = new HashSet<DateTime>();
        DateTime tmp = start;
        DateTime tmpend = end.plusDays(-1);
        while(tmp.isBefore(tmpend) || tmp.equals(tmpend)) {
            ret.add(tmp);
            tmp = tmp.plusDays(1);
        }
        return ret;
    }
    
    public Date dateTimeToDate(DateTime d) {
    	java.util.Date date = d.toDate();
    	Date sd = new java.sql.Date(date.getTime());
    	return sd;
    }
    
    public Set<Rdate> dateTimeSetToRdateSet(Set<DateTime> sd){
    	Set<Rdate> rdates = new HashSet<>();
    	for(DateTime d:sd) {
    		Rdate r = new Rdate();
    		Date date = dateTimeToDate(d);
    		r.setRdate(date);
    		rdates.add(r);
    	}
    	return rdates;
    }
	
}
