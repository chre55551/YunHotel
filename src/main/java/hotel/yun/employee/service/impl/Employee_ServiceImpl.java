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
	public Employee_basic query(Integer employee_id) {
		
		return emDao.query(employee_id);	
	}
	@Override
	public Employee_work query_work(int employee_work_id) {
		
		return emDao.query_work(employee_work_id);	
	}
	@Override
	public Employee_info query_info(int employee_info_id) {
		
		return emDao.query_info(employee_info_id);	
	}
	@Override
	public Employee_status query_status(int employee_status_id) {
		
		return emDao.query_status(employee_status_id);	
	}

	@Override
	public List<Employee_basic> queryAll() {
		
		return emDao.queryAll();
	}
	@Override
	public List<Employee_work> queryAll_work() {
		
		return emDao.queryAll_work();
	}
	@Override
	public List<Employee_info> queryAll_info() {
		
		return emDao.queryAll_info();
	}
	@Override
	public List<Employee_status> queryAll_status() {
		
		return emDao.queryAll_status();
	}
	
	@Override
	public Employee_basic update(Employee_basic emBean) {
		return emDao.update(emBean);
	}

	@Override
	public void delete(int employee_id) {
		emDao.delete(employee_id);
	}
	@Override
	public void delete_work(int employee_work_id) {
		emDao.delete_work(employee_work_id);
	}
	@Override
	public void delete_info(int employee_info_id) {
		emDao.delete_info(employee_info_id);
	}
	@Override
	public void delete_status(int employee_status_id) {
		emDao.delete_status(employee_status_id);
	}
}
