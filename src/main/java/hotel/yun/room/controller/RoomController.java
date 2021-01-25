package hotel.yun.room.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import hotel.yun.room.model.RoomType;
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
		List<RoomType> rm = service.queryAllRoomType();
		model.addAttribute("rom", rm);
		return "room/QueryAllRooms";
	}
	
	
	
//	@GetMapping("/QueryAllRooms")
//	public String QueryAllRooms(Model model) {
//		model.addAttribute("Rooms", RoomService.queryAll());
//		return "room/QueryAllRooms";
//	}
	@GetMapping("/ShowBlankQueryForm")
	public String ShowBlankQueryForm(Model model,HttpSession session) {
		return "room/ShowBlankQueryForm";
	}	
	
	
	
	//查詢單筆房型
	@PostMapping("/ShowQueryRoom")
	public String ShowQueryRoom(@ModelAttribute("rom") RoomType rm,Model model) {
		RoomType roomtype = service.queryRoomType_id(rm.getRoom_typeid());
		model.addAttribute("rom", roomtype);
		return "room/ShowQueryRoom";
	}
	
	
    //送出空白新增表單
	@GetMapping("/ShowBlankInsertForm")
	public String ShowBlankInsertForm( Model model) {
		RoomType rmt = new RoomType();
		model.addAttribute("rom", rmt);
		return "room/ShowBlankInsertForm";
		}
	
	
	//新增房型
	@PostMapping("/InsertRoom")
	public String InsertRoom(
			@RequestParam String room_type,
			@RequestParam double room_price,
			@RequestParam int room_stock,		
			@RequestParam(value="room_image",required=false) MultipartFile room_image,
			 Model model,HttpServletRequest request) throws IOException {
			System.out.println(room_type);
			System.out.println(room_price);
			System.out.println(room_stock);
			System.out.println(room_image);
			
		byte[] img = room_image.getBytes();
		String img_name = room_image.getOriginalFilename();
		try {
			Blob ri = new SerialBlob(img);
			RoomType rt = new RoomType(room_type, room_price, room_stock, ri, img_name);
			service.saveRoomType(rt);
			model.addAttribute("roomType", rt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "room/ShowInsertRoom";
	}
	
//	@PostMapping(value="/CompanyRegister")
//	 public String companyRegister(
//	   @RequestParam String companyName,
//	   @RequestParam String uniformNumbers,
//	   @RequestParam Integer categories,
//	   @RequestParam String account,
//	   @RequestParam String password,
//	   @RequestParam String phone,
//	   @RequestParam String email,
//	   @RequestParam(value="brand",required=false)MultipartFile logo,
//	   @RequestParam(value="busR",required=false)MultipartFile busRC,
//	//   HttpServletResponse response
//	   SessionStatus sessionStatus
//	   ) throws IOException {
//	  
//	  /////////////////存圖片轉成Byte陣列////////////////////
//
//	  //用getBytes方法把上傳的MultipartFile logo 轉成 byte[]
//	  byte[] logoB = logo.getBytes();
//	  byte[] busRCB = busRC.getBytes();
//
//	    try {
//	     //再把Byte[]轉成Blob物件
//	     Blob logoblob = new javax.sql.rowset.serial.SerialBlob(logoB);
//	     Blob busRCblob = new javax.sql.rowset.serial.SerialBlob(busRCB);
//	     //取得logo 的Filename
//	     String logoName = logo.getOriginalFilename();
//	     String busRCName = busRC.getOriginalFilename();
//	     //得到的參數塞到建構子                  Blob物件  Filename
//	     Company cmp = new Company(companyName,logoblob,logoName,uniformNumbers,categories,account,password,email,phone,busRCblob,busRCName);
//	     //呼叫Service新增到資料庫
//	     cmpService.addCompany(cmp);
//	    e04
//	    } catch (SerialException e) {
//	     // TODO Auto-generated catch block
//	     e.printStackTrace();
//	    } catch (SQLException e) {
//	     // TODO Auto-generated catch block
//	     e.printStackTrace();
//	    }
//	    
//	  /////////////////存圖片轉成Byte陣列////////////////////
//	  //密碼洩漏問題
//	  sessionStatus.setComplete();
//	  return "redirect:/index";
//	  
//	  
//	 }
	
	
}
