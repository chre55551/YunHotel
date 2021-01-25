package hotel.yun.employee.controller;

import java.util.List;

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

import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_work;
import hotel.yun.employee.service.Employee_Service;




@Controller
@RequestMapping("/employee")
@SessionAttributes({"employee_id", "employee_work_id","employee_info_id"})
public class Employee_Controller {
	
	
	@Autowired
	Employee_Service service;
	
	@PostMapping("/insertEmployee")
	public String Insert(@RequestParam(value="employee_name") String employee_name,
			@RequestParam(value="employee_department") String employee_department,
			@RequestParam(value="employee_position") String employee_position,
			@RequestParam(value="employee_workyears") int employee_workyears,
			@RequestParam(value="employee_salary") int employee_salary,
//			@RequestParam(value="working_hours") int working_hours,
//			@RequestParam(value="holiday_hours") int holiday_hours,
			@RequestParam(value="employee_gender") String employee_gender,
			@RequestParam(value="employee_age") int employee_age,
			@RequestParam(value="employee_address") String employee_address,
			@RequestParam(value="employee_mobile") String employee_mobile,
			@RequestParam(value="employee_phone") String employee_phone,
			@RequestParam(value="employee_email") String employee_email,
			@RequestParam(value="emergency_contact") String emergency_contact,
			@RequestParam(value="employee_image") byte[] employee_image,
			Model model) {
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
		Ibeans.setEmployee_image(employee_image);
		Employee_basic NBbeans =service.insert(Bbeans);
		Employee_work NWbeans =service.insert_work(Wbeans);
		Employee_info NIbeans =service.insert_info(Ibeans);
		model.addAttribute("NBbeans", NBbeans);
		model.addAttribute("NWbeans", NWbeans);
		model.addAttribute("NIbeans", NIbeans);
		System.out.println("insert sucess");
		return "employee/insertSucess";
}
	

	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping("/insertEmp")
	public String ShowEmployee(Model model) {
		Employee_basic Bbeans = new Employee_basic();
		Employee_work Wbeans = new Employee_work();
		Employee_info Ibeans = new Employee_info();
		model.addAttribute("NBbeans", Bbeans);
		model.addAttribute("NWbeans", Wbeans);
		model.addAttribute("NIbeans", Ibeans);
		return "employee/insertEmployee";
	}
	
	@PostMapping("/thisEmployee")
	public String ThisEmployee(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		Employee_basic beans = service.query(pojo.getEmployee_id());
		model.addAttribute("Employee_basic", beans);
		model.addAttribute("null", beans);
		return "/Employee/ThisEmployee";//依訂單號查到他的訂單
	}
	
	@GetMapping("/showAllemployees")
	public String getEmployees(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		List<Employee_basic> beans = service.queryAll(pojo.getEmployee_id());
		model.addAttribute(beans);      
		// 若屬性物件為CustomerBean型別的物件，則預設的識別字串 ==> customerBean
		// 若屬性物件為List<CustomerBean>型別的物件，則預設的識別字串 ==> customerBeanList
		System.out.println("getEmployees");
		return "employee/ShowEmployees";
	}
	
	
	@GetMapping("/modifyEmployee/{id}")
	public String editEmployeeForm(Model model, @PathVariable Integer employee_info_id) {
		Employee_basic bean = service.query(employee_info_id);
		bean.setEmployee_info(bean.getEmployee_info());
		model.addAttribute("Employee_basic", bean);
		return "employee/EditEmployeeForm";
	}
	
	@GetMapping("/thisEmployee/{Employee_id}")
	public String updateEmployee(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		Employee_basic bean = service.query(pojo.getEmployee_id());
		bean.setEmployee_id(bean.getEmployee_id());
		bean.setEmployee_name(bean.getEmployee_name());
		bean.setEmployee_department(bean.getEmployee_department());
		bean.setEmployee_position(bean.getEmployee_position());
		bean.setEmployee_info(bean.getEmployee_info());
		bean.setEmployee_work(bean.getEmployee_work());
		Employee_basic afterBean = service.update(bean);
		model.addAttribute("updateEmployee", afterBean);
		return "employee/thisEmployee";
	}
	
	@DeleteMapping(value="/modifyEmployee/{id}")
	public String deleteEmployeeData(@PathVariable Integer employee_id) {
		System.out.println(11122233);
		service.delete(employee_id);	
		return "employee/employees";
	}
	//後台的進入點
	@GetMapping("/empindex")
	public String homeEmployee(Model model) {
		return "employee/empindex";
	}
	
	//新增的分流
	@GetMapping("/insertEmployee")
	public String insertEmployee(Model model){
		return "employee/insert";
	}
	
	//查詢的分流
	@GetMapping("/queryEmployee")
	public String queryEmployee(Model model){
		return "employee/query";
	}
}
