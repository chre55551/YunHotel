package hotel.yun.customer.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.dao.CustomerDao;
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;

@Repository
public class CustomerDaoimpl implements Serializable, CustomerDao {
	private static final long serialVersionUID = 1L;

	@Autowired
	SessionFactory factory;

	@Override
	public Customer insertC(Customer cBean) {
		Session session = factory.getCurrentSession();
		session.save(cBean);
		return cBean;
	}

	@Override
	public Member insertM(Member mBean) {
		Session session = factory.getCurrentSession();
		session.save(mBean);
		return mBean;
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
	public Customer query(Customer c) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer cu WHERE cu.chinese_name = :cn and cu.mobile_phone = :mp";

		Customer customer = (Customer) session.createQuery(hql).setParameter("cn", c.getChinese_name())
				.setParameter("mp", c.getMobile_phone()).getSingleResult();
		return customer;
	}

	public Member checkIdPassword(String account, String password) {
		Member mb = null;
		String hql = "FROM Member m WHERE m.account = :mid and m.password = :pwsd";
		Session session = factory.getCurrentSession();
		try {
			mb = (Member) session.createQuery(hql).setParameter("mid", account).setParameter("pwsd", password)
					.getSingleResult();
			return mb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
