package hotel.yun.employee.service;

import java.util.List;

import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_work;

public interface Employee_Service {
	
	public Employee_basic insert(Employee_basic emBean);
	public Employee_work insert_work(Employee_work emBean);	
	public Employee_info insert_info(Employee_info emBean);	
	public Employee_basic query(int employee_id);
	public List<Employee_basic> queryAll(int employee_id);//依照員工編號來查詢所有員工資料
	public Employee_basic update(Employee_basic embean);
	public void delete(int employee_id) ;
}
