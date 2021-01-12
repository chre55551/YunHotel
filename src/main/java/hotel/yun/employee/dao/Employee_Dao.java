package hotel.yun.employee.dao;

import java.util.List;

import hotel.yun.employee.model.Employee_basic;

public interface Employee_Dao {
	
	public Employee_basic insert(Employee_basic emBean);
	public boolean query(Integer employee_id);
	public List<Employee_basic> queryAll();
	public Employee_basic update(Employee_basic embean);
	public void delete(Integer employee_id) ;
	
}
