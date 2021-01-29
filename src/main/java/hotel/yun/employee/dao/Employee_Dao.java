package hotel.yun.employee.dao;

import java.util.List;

import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_status;
import hotel.yun.employee.model.Employee_work;

public interface Employee_Dao {
	
	public Employee_basic insert(Employee_basic emBean);
	public Employee_work insert_work(Employee_work emBean);
	public Employee_info insert_info(Employee_info emBean);
	public Employee_status queryS(int i);
	public Employee_basic query(Integer employee_id);
	public Employee_work query_work(int employee_work_id);
	public Employee_info query_info(int employee_info_id);
	public Employee_status query_status(int employee_status_id);
	public List<Employee_basic> queryAll();
	public List<Employee_work> queryAll_work();
	public List<Employee_info> queryAll_info();
	public List<Employee_status> queryAll_status();
	public Employee_basic update(Employee_basic embean);
	public void delete(int employee_id) ;
	public void delete_work(int employee_work_id) ;
	public void delete_info(int employee_info_id) ;
	public void delete_status(int employee_status_id) ;
	
}
