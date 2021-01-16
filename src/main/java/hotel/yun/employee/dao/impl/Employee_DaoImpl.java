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
		
		Employee_basic bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_basic.class, employee_id);
		return bean;
	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_basic> queryAll() {
		// 查詢所有紀錄

			String hql = "FROM Employee_basic"; 
			List<Employee_basic> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).getResultList();
			return allEmployees;
		}

	@Override
	public Employee_basic update(Employee_basic emBean) {
		Session session = factory.getCurrentSession();
		session.update(emBean);
		return emBean;
		
	}
	

	// 刪除紀錄
	@Override
	public void delete(int employee_id) {
		Session session = factory.getCurrentSession();
		Employee_basic emBean = new Employee_basic();
		emBean.setEmployee_id(employee_id);
		session.delete(emBean);
	}
//	public void delete(int employee_id,String employee_name,String employee_department,String employee_position)  {
//		Session session = factory.getCurrentSession();
//		Transaction tx =null;
//		try {
//			Employee_basic emBean = new Employee_basic(employee_id,employee_name,employee_department,employee_position);
//			session.delete(emBean);   
//		} catch(Exception e){
//			String classname5 =  e.getCause().getClass().getName();
//			String classname4 =  e.getClass().getName();
//			if ( classname5.equalsIgnoreCase("org.hibernate.StaleStateException") || 
//				classname4.equalsIgnoreCase("org.hibernate.StaleStateException")	
//			) {
//				throw new RecordNotFoundException("要刪除的紀錄不存在: 主鍵值為: " + employee_id);
//			} else {
//				throw new RecordNotFoundException("刪除紀錄時發生異常", e);
//			}
//		}
//		return;
//	}
}
