package hotel.yun.employee.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_status;
import hotel.yun.employee.model.Employee_work;
import hotel.yun.employee.service.Employee_Service;

@Controller
@RequestMapping("/employee")
@SessionAttributes({ "employee_id", "employee_work_id", "employee_info_id" })
public class Employee_Controller {

	@Autowired
	Employee_Service service;

	@PostMapping("/insertEmployee")
	public String Insert(@RequestParam(value = "employee_name") String employee_name,
			@RequestParam(value = "employee_department") String employee_department,
			@RequestParam(value = "employee_position") String employee_position,
			@RequestParam(value = "employee_workyears") int employee_workyears,
			@RequestParam(value = "employee_salary") int employee_salary,
//			@RequestParam(value="working_hours") int working_hours,
//			@RequestParam(value="holiday_hours") int holiday_hours,
			@RequestParam(value = "employee_gender") String employee_gender,
			@RequestParam(value = "employee_age") int employee_age,
			@RequestParam(value = "employee_address") String employee_address,
			@RequestParam(value = "employee_mobile") String employee_mobile,
			@RequestParam(value = "employee_phone") String employee_phone,
			@RequestParam(value = "employee_email") String employee_email,
			@RequestParam(value = "emergency_contact") String emergency_contact,
			@RequestParam(value = "employee_image") byte[] employee_image, Model model) {
//					throws IOException {
//		byte[] img = employee_image.getBytes();
//		try {
//			Blob ri = new SerialBlob(img);

		Employee_basic Bbeans = new Employee_basic();
		Employee_work Wbeans = new Employee_work();
		Employee_info Ibeans = new Employee_info();
		Bbeans.setEmployee_name(employee_name);
		Bbeans.setEmployee_department(employee_department);
		Bbeans.setEmployee_position(employee_position);
		Wbeans.setEmployee_workyears(employee_workyears);
		Wbeans.setEmployee_salary(employee_salary);
		Ibeans.setEmployee_gender(employee_gender);
		Ibeans.setEmployee_age(employee_age);
		Ibeans.setEmployee_address(employee_address);
		Ibeans.setEmployee_mobile(employee_mobile);
		Ibeans.setEmployee_phone(employee_phone);
		Ibeans.setEmployee_email(employee_email);
		Ibeans.setEmergency_contact(emergency_contact);
//		Ibeans.setEmployee_image(employee_image);
		Bbeans.setEmployee_info(Ibeans);
		Bbeans.setEmployee_work(Wbeans);
		Employee_basic NBbeans = service.insert(Bbeans);
//		Employee_work NWbeans =service.insert_work(Wbeans);
//		Employee_info NIbeans =service.insert_info(Ibeans);
		model.addAttribute("NBbeans", NBbeans);
//		model.addAttribute("NWbeans", NWbeans);
//		model.addAttribute("NIbeans", NIbeans);
		System.out.println("insert sucess");
//		} catch (SerialException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "employee/insertSucess";
	}

	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping("/insertEmp")
	public String ShowEmployee(Model model) {
		Employee_basic Bbeans = new Employee_basic();
		Employee_work Wbeans = new Employee_work();
		Employee_info Ibeans = new Employee_info();
		Bbeans.setEmployee_info(Ibeans);
		Bbeans.setEmployee_work(Wbeans);
		model.addAttribute("NBbeans", Bbeans);
//		model.addAttribute("NWbeans", Wbeans);
//		model.addAttribute("NIbeans", Ibeans);
		return "employee/insertEmployee";
	}

	@PostMapping("/thisEmployee")
	public String ThisEmployee(@ModelAttribute("pojo") Employee_basic pojo, Model model) {
		Employee_basic beans = service.query(pojo.getEmployee_id());
		model.addAttribute("Employee_basic", beans);
		model.addAttribute("null", beans);
		return "/Employee/ThisEmployee";// 依訂單號查到他的訂單
	}

	@GetMapping("/showAllemployees")
	public String getEmployees(Model model) {
		List<Employee_basic> beans = service.queryAll();
//		List<Employee_work> wbeans = service.queryAll_work();
//		List<Employee_info> ibeans = service.queryAll_info();
//		List<Employee_status> sbeans = service.queryAll_status();
		model.addAttribute("embs", beans);
		// 若屬性物件為CustomerBean型別的物件，則預設的識別字串 ==> customerBean
		// 若屬性物件為List<CustomerBean>型別的物件，則預設的識別字串 ==> customerBeanList
		System.out.println("getEmployees");
		return "employee/showAllEmployee";
	}

	@GetMapping("/modifyEmployee/{id}")
	public String editEmployeeForm(Model model, @PathVariable Integer employee_info_id) {
		Employee_basic bean = service.query(employee_info_id);
		bean.setEmployee_info(bean.getEmployee_info());
		model.addAttribute("Employee_basic", bean);
		return "employee/EditEmployeeForm";
	}

//	@GetMapping("/updateEmployee/{Employee_id}")
//	public String updateEmployee(@ModelAttribute("pojo") Employee_basic bpojo,Model model
//			,Employee_work wpojo,Employee_info ipojo,Employee_status spojo) {
//		Employee_basic bean = service.query(bpojo.getEmployee_id());
//		Employee_work Wbeans = service.query_work(wpojo.getEmployee_work_id());
//		Employee_info Ibeans =service.query_info(ipojo.getEmployee_info_id());
//		Employee_status Sbeans = service.query_status(spojo.getEmployee_status_id());
//		bean.setEmployee_id(bean.getEmployee_id());
//		bean.setEmployee_name(bean.getEmployee_name());
//		bean.setEmployee_department(bean.getEmployee_department());
//		bean.setEmployee_position(bean.getEmployee_position());
//		bean.setEmployee_info(Ibeans);
//		bean.setEmployee_work(Wbeans);
//		bean.setEmployee_status(Sbeans);
//		Employee_basic afterBean = service.update(bean);
//		model.addAttribute("updateEmployee", afterBean);
//		return "employee/updateEmployee";
//	}
	@GetMapping("/updateEmployee/{employee_id}")
	public String updateEmployee(Model model, @PathVariable int employee_id
//			,@PathVariable int employee_work_id,@PathVariable int employee_info_id,
//			@PathVariable int employee_status_id
	) {
		Employee_basic bean = service.query(employee_id);
		model.addAttribute("Beans", bean);

		model.addAttribute("Beans", bean.getEmployee_name());
		model.addAttribute("department", bean.getEmployee_department());
		model.addAttribute("position", bean.getEmployee_position());
		model.addAttribute("work", bean.getEmployee_work());
		model.addAttribute("salary", bean.getEmployee_work().getEmployee_salary());
		model.addAttribute("workyears", bean.getEmployee_work().getEmployee_workyears());
		model.addAttribute("info", bean.getEmployee_info());
		model.addAttribute("age", bean.getEmployee_info().getEmployee_age());
		model.addAttribute("gender", bean.getEmployee_info().getEmployee_gender());
		model.addAttribute("address", bean.getEmployee_info().getEmployee_address());
		model.addAttribute("email", bean.getEmployee_info().getEmployee_email());
		model.addAttribute("mobile", bean.getEmployee_info().getEmployee_mobile());
		model.addAttribute("phone", bean.getEmployee_info().getEmployee_phone());
		model.addAttribute("phone", bean.getEmployee_info().getEmergency_contact());
		return "employee/updateEmployee";
	}

	@PostMapping("/updateEmployee/{employee_id}")
	public String updateEmployee2(Model model, @PathVariable(value = "employee_id", required = false) int employee_id,
			@RequestParam(value = "employee_name", required = false) String employee_name,
			@RequestParam(value = "employee_department", required = false) String employee_department,
			@RequestParam(value = "employee_position", required = false) String employee_position,
			@RequestParam(value = "employee_workyears", required = false) int employee_workyears,
			@RequestParam(value = "employee_salary", required = false) int employee_salary,
			@RequestParam(value = "employee_age", required = false) int employee_age,
			@RequestParam(value = "employee_gender", required = false) String employee_gender,
			@RequestParam(value = "employee_address", required = false) String employee_address,
			@RequestParam(value = "employee_mobile", required = false) String employee_mobile,
			@RequestParam(value = "employee_phone", required = false) String employee_phone,
			@RequestParam(value = "employee_email", required = false) String employee_email,
			@RequestParam(value = "emergency_contact", required = false) String emergency_contact,
			HttpServletRequest request) {
		Employee_basic bean = service.query(employee_id);
		service.update(bean);
		return "redirect:../showAllEmployee";
	}

	@GetMapping("/deleteEmployee/{employee_id}")
	public String deleteEmployeeBasic(@PathVariable("employee_id") int employee_id) {
		System.out.println("delete sucess");
		service.delete(employee_id);
		return "employee/showAllEmployee";
	}

//	@DeleteMapping(value="/modifyEmployee/{employee_work_id}")
//	public String deleteEmployeeWork(@PathVariable("employee_work_id") int employee_work_id) {
//		System.out.println("delete sucess");
//		service.delete(employee_work_id);	
//		return "employee/showAllemployees";
//	}
//	@DeleteMapping(value="/modifyEmployee/{employee_info_id}")
//	public String deleteEmployeeInfo(@PathVariable("employee_info_id") int employee_info_id) {
//		System.out.println("delete sucess");
//		service.delete(employee_info_id);	
//		return "employee/showAllemployees";
//	}
//	@DeleteMapping(value="/modifyEmployee/{employee_status_id}")
//	public String deleteEmployeeStatus(@PathVariable("employee_status_id") int employee_status_id) {
//		System.out.println("delete sucess");
//		service.delete(employee_status_id);	
//		return "employee/showAllemployees";
//	}
	// 後台的進入點
	@GetMapping("/empindex")
	public String homeEmployee(Model model, HttpSession session) {
		String kk = (String) session.getAttribute("BLoginOK");
		if (kk != null) {
			return "employee/empindex";
		} else {
			return "login/PleaseLoginInBS";
		}
	}

	// 新增的分流
	@GetMapping("/insertEmployee")
	public String insertEmployee(Model model) {
		return "employee/insert";
	}

	// 查詢的分流
	@GetMapping("/queryEmployee")
	public String queryEmployee(Model model) {
		return "employee/query";
	}
}
