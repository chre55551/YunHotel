package hotel.yun.employee.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.employee.dao.Employee_Dao;
import hotel.yun.employee.model.Employee_basic;
import hotel.yun.employee.model.Employee_info;
import hotel.yun.employee.model.Employee_status;
import hotel.yun.employee.model.Employee_work;
import hotel.yun.news.model.News;
import hotel.yun.ordered.model.OrderedStatus;


@Repository
public class Employee_DaoImpl implements Serializable, Employee_Dao{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	//新增員工資料
	@Override
	public Employee_basic insert(Employee_basic emBean) {
		Session session = factory.getCurrentSession();
		session.save(emBean);
		return emBean;
	}
	@Override
	public Employee_work insert_work(Employee_work emBean) {
		Session session = factory.getCurrentSession();
		session.save(emBean);
		return emBean;
	}
	@Override
	public Employee_info insert_info(Employee_info emBean) {
		Session session = factory.getCurrentSession();
		session.save(emBean);
		return emBean;
	}
	
	@Override
	public Employee_status queryS(int i) {
		Session session = factory.getCurrentSession();
		Employee_status ods = session.get(Employee_status.class, i);
		return ods;
	}
	
	//依照員工編號來查詢該員工資料
	@Override
	public Employee_basic query(int employee_id) {
		Employee_basic bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_basic.class, employee_id);
		return bean;
	}
	@Override
	public Employee_work query_work(int employee_work_id) {
		Employee_work bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_work.class, employee_work_id);
		return bean;
	}
	@Override
	public Employee_info query_info(int employee_info_id) {
		Employee_info bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_info.class, employee_info_id);
		return bean;
	}
	@Override
	public Employee_status query_status(int employee_status_id) {
		Employee_status bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_status.class, employee_status_id);
		return bean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_basic> queryAll() {
		//依照員工編號查詢所有紀錄

			String hql = "FROM Employee_basic"; 
			List<Employee_basic> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).getResultList();
			return allEmployees;
		}
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_work> queryAll_work() {
		//依照員工編號查詢所有紀錄

			String hql = "FROM Employee_work"; 
			List<Employee_work> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).getResultList();
			return allEmployees;
		}
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_info> queryAll_info() {
		//依照員工編號查詢所有紀錄

			String hql = "FROM Employee_info"; 
			List<Employee_info> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).getResultList();
			return allEmployees;
		}
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_status> queryAll_status() {
		//依照員工編號查詢所有紀錄

			String hql = "FROM Employee_status"; 
			List<Employee_status> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).getResultList();
			return allEmployees;
		}
	//依照員工編號即可修改員工資料
//	@Override
//	public Employee_basic update(Employee_basic emBean) {
//		Session session = factory.getCurrentSession();
//		String hql = "UPDATE Employee_basic eb SET eb.employee_name  = :name "
//			+",eb.employee_department = :department"
//			+",eb.employee_position = :position"
//			+",eb.employee_work_id = :work"
//			+",eb.employee_info_id = :info"
//			+",eb.employee_status_id = :status_id"
//			+"WHERE eb.employee_id = :id";
//		session.createQuery(hql)
//				.setParameter("id",emBean.getEmployee_id())
//				.setParameter("name",emBean.getEmployee_name())
//				.setParameter("department",emBean.getEmployee_department() )
//				.setParameter("position",emBean.getEmployee_position() )
//				.setParameter("work",emBean.getEmployee_work())
//				.setParameter("info",emBean.getEmployee_info())
//				.executeUpdate();
//		return emBean;
//		
//	}
	@Override
	public Employee_basic update(Employee_basic embean) {
		Session session = factory.getCurrentSession();
		session.update(embean);
		return embean;
	}
	

	// 刪除紀錄
	@Override
	public void delete(int employee_id) {
		Session session = factory.getCurrentSession();
		Employee_basic emBean = new Employee_basic();
		emBean.setEmployee_id(employee_id);
		session.delete(emBean);
	}
	@Override
	public void delete_work(int employee_work_id) {
		Session session = factory.getCurrentSession();
		Employee_work emBean = new Employee_work();
		emBean.setEmployee_work_id(employee_work_id);
		session.delete(emBean);
	}
	@Override
	public void delete_info(int employee_info_id) {
		Session session = factory.getCurrentSession();
		Employee_info emBean = new Employee_info();
		emBean.setEmployee_info_id(employee_info_id);
		session.delete(emBean);
	}
	@Override
	public void delete_status(int employee_status_id) {
		Session session = factory.getCurrentSession();
		Employee_status emBean = new Employee_status();
		emBean.setEmployee_status_id(employee_status_id);
		session.delete(emBean);
	}

}
