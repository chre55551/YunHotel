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




@Controller


@SessionAttributes({"employee_id", "employee_work_id","employee_info_id"})
public class Employee_Controller {
	
	
	@Autowired
	Employee_Service service;


	
	@PostMapping("/thisEmployee")
	public String ThisEmployee(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		Employee_basic beans = service.query(pojo.getEmployee_id());
		model.addAttribute("ThisEmployee", beans);
		return "/Employee/ThisEmployee";//依訂單號查到他的訂單
	}
	
	@GetMapping("/employees")
	public String getEmployees(@ModelAttribute("pojo") Employee_basic pojo,Model model) {
		List<Employee_basic> beans = service.queryAll(pojo.getEmployee_id());
		model.addAttribute(beans);      
		// 若屬性物件為CustomerBean型別的物件，則預設的識別字串 ==> customerBean
		// 若屬性物件為List<CustomerBean>型別的物件，則預設的識別字串 ==> customerBeanList
		System.out.println("getEmployees");
		return "employee/ShowEmployees";
	}
	
	@PostMapping("/ertOrdred")
	public String insert(@ModelAttribute("pojo") Employee_basic pojo, Model model,HttpServletRequest request,BindingResult result) {
		service.insert(pojo);
		
		return "ordered/ThisOrdered";
	}
	
	@GetMapping("/modifyEmployee/{id}")
	public String editEmployeeForm(Model model, @PathVariable Integer employee_info_id) {
		Employee_basic bean = service.query(employee_info_id);
		bean.setEmployee_info(bean.getEmployee_info());
		model.addAttribute("Employee_basic", bean);
		return "employee/EditEmployeeForm";
	}
	
	@GetMapping("/thisEmployee/{Employee_id}")
	public String thisEmployee(Model model) {
		Employee_basic bean = new Employee_basic();
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
	
	@RequestMapping("/employee/index")
	public String home() {
		return "employee/empindex";
	}
	
	
}
