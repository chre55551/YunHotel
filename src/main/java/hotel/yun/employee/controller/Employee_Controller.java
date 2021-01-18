package hotel.yun.employee.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/hotel.yun.employee")

@SessionAttributes({"employee_id", "employee_work_id","employee_info_id"})
public class Employee_Controller {
	
	@Autowired
	ServletContext context;
	
	
	@Autowired
	Employee_Service service;

	@Autowired
	Employee_basic em;
	
	@PostMapping("/thisEmployee")
	public String ThisEmployee(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		Employee_basic beans = service.query(em.getEmployee_id());
		model.addAttribute("ThisEmployee", beans);
		return "/Employee/ThisEmployee";//依訂單號查到他的訂單
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee_basic> beans = service.queryAll(em.getEmployee_id());
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
	
	@GetMapping("/insertEmployee")
	public String showEmployeeForm(Model model) {
		System.out.println("1. 本方法送出新增Employee資料的空白表單");
		Employee_basic bean = new Employee_basic();
		bean.setEmployee_name(null);
		bean.setEmployee_department(null);
		bean.setEmployee_position(null);
		bean.setEmployee_info(null);
		bean.setEmployee_work(null);
		model.addAttribute("Employee_basic", bean);
		return "employee/EmployeeForm";
	}
	
	@DeleteMapping(value="/modifyEmployee/{id}")
	public String deleteEmployeeData(@PathVariable Integer employee_id) {
		System.out.println(11122233);
		service.delete(employee_id);	
		return "redirect:../employees";
	}
	
	@RequestMapping("/index")
	public String home() {
		return "employee/index";
	}
	
	
}
