package hotel.yun.employee.service;

import java.util.List;

import hotel.yun.employee.model.Employee_basic;

public interface Employee_Service {
	
	public Employee_basic insert(Employee_basic emBean);
	public Employee_basic query(int employee_id);
	public List<Employee_basic> queryAll();
	public Employee_basic update(Employee_basic embean);
	public void delete(int employee_id) ;
}
