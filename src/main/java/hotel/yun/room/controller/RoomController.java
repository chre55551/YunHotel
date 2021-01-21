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
	public String indexRoom(Model model){
		return "room/IndexRoom";
	
	}
	

	@GetMapping("/ShowRooms")
	public String ShowRooms(Model model) {
		List<Room> rm = service.queryAll();
		model.addAttribute("rom", rm);
		return "room/ShowRooms";
	}
	
	@PostMapping("InsertRoom")
	public String Insert(@ModelAttribute("rom") Room rm, Model model,HttpServletRequest request,BindingResult result) {
		service.save(rm);
		return "room/InsertRoom";
	}
	@PostMapping("/ShowRoom")
	public String GetaNew(@ModelAttribute("rom") Room rm,Model model) {
		Room room = service.queryRoom_id(rm.getRoom_id());
		model.addAttribute("GetaNew", room);
		return "room/ShowRoom";
	}
	
	
	
	
	
	
}
