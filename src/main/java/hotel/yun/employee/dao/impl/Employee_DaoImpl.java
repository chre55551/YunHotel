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
import hotel.yun.employee.model.Employee_work;


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
	
	//依照員工編號來查詢該員工資料
	@Override
	public Employee_basic query(int employee_id) {
		Employee_basic bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(Employee_basic.class, employee_id);
		return bean;
	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee_basic> queryAll(int Employee_basic_id) {
		//依照員工編號查詢所有紀錄

			String hql = "FROM Employee_basic eb WHERE eb.Employee_basic_id = :ebi"; 
			List<Employee_basic> allEmployees = null;
			Session session = factory.getCurrentSession();
			allEmployees = session.createQuery(hql).setParameter("ebi", Employee_basic_id).getResultList();
			return allEmployees;
		}
	//依照員工編號即可修改員工資料
	@Override
	public Employee_basic update(Employee_basic emBean) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE Employee_basic eb SET eb.employee_name  = :name "
			+",eb.employee_department = :department"
			+",eb.employee_position = :position"
			+",eb.employee_work_id = :work"
			+",eb.employee_info_id = :info"
			+",eb.employee_status_id = :status_id"
			+"WHERE eb.employee_id = :id";
		session.createQuery(hql)
				.setParameter("id",emBean.getEmployee_id())
				.setParameter("name",emBean.getEmployee_name())
				.setParameter("department",emBean.getEmployee_department() )
				.setParameter("position",emBean.getEmployee_position() )
				.setParameter("work",emBean.getEmployee_work())
				.setParameter("info",emBean.getEmployee_info())
				.executeUpdate();
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

}
