package hotel.yun.customer.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.customer.dao.CustomerDao;
import hotel.yun.customer.model.Customer;


@Repository
public class CustomerDaoimpl implements Serializable,CustomerDao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	
	@Override
	public Customer insert(Customer cBean) {
		Session session = factory.getCurrentSession();
		session.save(cBean);
		return cBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> queryAll(int customer_id) {
		List<Customer> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer cu WHERE cu.customer_id = :onb";
		list = session.createQuery(hql).setParameter("onb", customer_id).getResultList();
		return list;
	}

	@Override
	public Customer update(Customer cBean) {
		Session session = factory.getCurrentSession();
		return null;
	}

	@Override
	public void delete(int customer_id) {
		Session session = factory.getCurrentSession();
		Customer cu = new Customer();
		cu.setCustomer_id(customer_id);
		session.delete(cu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> query(String chinese_name, String mobile_phone) {
		List<Customer> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer cu WHERE cu.chinese_name = :cn"+
		"FROM Customer cu WHERE cu.mobile_phone = :mp";
		
		list = session.createQuery(hql).setParameter("cn", chinese_name).getResultList();
		return list;
	}

}
