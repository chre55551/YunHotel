package hotel.yun.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.employee.dao.Employee_Dao;
import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_status;
import hotel.yun.employee.model.Employee_work;
import hotel.yun.employee.service.Employee_Service;
import hotel.yun.ordered.model.OrderedStatus;



@Transactional
@Service
public class Employee_ServiceImpl implements Employee_Service {
	
	@Autowired
	private Employee_Dao emDao;

	public void setEmDao(Employee_Dao emDao) {
		this.emDao = emDao;
	}
	
	@Override
	public Employee_basic insert(Employee_basic emBean) {
		Employee_status ods  = emDao.queryS(1);
		emBean.setEmployee_status(ods);
		return emDao.insert(emBean);
	}
	
	@Override
	public Employee_work insert_work(Employee_work emBean) {
		
		return emDao.insert_work(emBean);
	}
	
	@Override
	public Employee_info insert_info(Employee_info emBean) {
		
		return emDao.insert_info(emBean);
	}

	@Override
	public Employee_basic query(int employee_id) {
		
		return emDao.query(employee_id);	
	}

	@Override
	public List<Employee_basic> queryAll(int employee_id) {
		
		return emDao.queryAll(employee_id);
	}
	
	@Override
	public Employee_basic update(Employee_basic emBean) {
		return emDao.update(emBean);
	}

	@Override
	public void delete(int employee_id) {
		emDao.delete(employee_id);
	}
}
