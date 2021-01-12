package hotel.yun.employee.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.employee.dao.Employee_Dao;
import hotel.yun.employee.model.Employee_basic;

@Repository
public class Employee_DaoImpl implements Serializable, Employee_Dao{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Employee_basic insert(Employee_basic emBean) {
		Session session = factory.getCurrentSession();
		session.save(emBean);
		return emBean;
	}
	
	@Override
	public Employee_basic query(int employee_id) {
		
		return null;
	}

	@Override
	public List<Employee_basic> queryAll() {
		
		return null;
	}

	@Override
	public Employee_basic update(Employee_basic emBean) {
		
		return null;
	}

	@Override
	public boolean delete(int employee_id) {
		
		return false;
	}
}
