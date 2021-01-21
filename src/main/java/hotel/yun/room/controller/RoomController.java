package hotel.yun.room.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import hotel.yun.room.model.Room;
import hotel.yun.room.service.RoomService;

@Controller
@RequestMapping("/room")
@SessionAttributes({ "room_id", "room_name", "room_typeid"})
public class RoomController {

	ServletContext context;
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	RoomService service;
	
	
	@Autowired
	public void setService(RoomService service) {
		this.service = service;
	}
	
	
	//後台的進入點
	@GetMapping("/IndexRoom")
	public String IndexRoom(Model model){
		return "room/IndexRoom";
	
	}
	
	//官網的房型介紹
	@GetMapping("/RoomIntroduction")
	public String RoomIntroduction(Model model){
		return "room/RoomIntroduction";
	
	}
	
    //查詢所有房型
	@GetMapping("/QueryAllRooms")
	public String QueryAllRooms(Model model) {
		List<Room> rm = service.queryAll();
		model.addAttribute("rom", rm);
		return "room/QueryAllRooms";
	}
	
	
	//查詢單筆房型
	@GetMapping("/queryRoom")
	public String QueryRoom(@ModelAttribute("rom") Room rm,Model model) {
		Room room = service.queryRoom_id(rm.getRoom_id());
		model.addAttribute("rom", room);
		return "room/ShowRoom";
	}
	
	
    //送出空白表單
	@GetMapping("/ShowBlankRoomform")
	public String ShowBlankRoomform( Model model) {
		Room rm = new Room();
		model.addAttribute("rom", rm);
		return "room/ShowBlankRoomform";
		}
	
	
	//新增房型
	@PostMapping("/InsertRoom")
	public String InsertRoom(@ModelAttribute("rom") Room rm, Model model,HttpServletRequest request,BindingResult result) {
		service.save(rm);
		return "room/InsertRoom";
	}
	
	
}
