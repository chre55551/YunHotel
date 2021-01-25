package hotel.yun.employee.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.service.Employee_Service;
import hotel.yun.ordered.model.Ordered;




@Controller
@RequestMapping("/employee")
@SessionAttributes({"employee_id", "employee_work_id","employee_info_id"})
public class Employee_Controller {
	
	
	@Autowired
	Employee_Service service;
	
	

	// 本方法於新增時，送出空白的表單讓使用者輸入資料
	@GetMapping("/insertEmp")
	public String ShowEmployee(Model model) {
		Employee_basic beans = new Employee_basic();
		model.addAttribute("pojo", beans);
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
