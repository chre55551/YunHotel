package hotel.yun.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import hotel.yun.customer.dao.CustomerDao;
import hotel.yun.customer.model.Customer;
@Repository
public class CustomerDaoimpl implements CustomerDao {
SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public CustomerDaoimpl() { 	}
	@Override
	public Customer getCustomerById(int id) {
		Customer bean = null;
		Session session = factory.getCurrentSession();
		String hql  = "FROM CustomerBean cb WHERE cb.customerId = :id";
		try {
			bean = (Customer)session.createQuery(hql)
									.setParameter("id", id)
									.getSingleResult();
		} catch(NoResultException e) {
			;  // 表示查無紀錄
		}
		
		return bean;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM CustomerBean";
		List<Customer> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public Object save(Customer bean) {
		Session session = factory.getCurrentSession();
		return session.save(bean);
	}

	@Override
	public void updateCustomer(Customer bean) {
		Session session = factory.getCurrentSession();
		session.update(bean);

	}

	@Override
	public void deleteCustomerByPrimaryKey(int key) {
		Session session = factory.getCurrentSession();
		Customer customer = new Customer(null, null, null, null, null);
		customer.setCustomer_id(key);
		session.delete(customer);

	}

}
