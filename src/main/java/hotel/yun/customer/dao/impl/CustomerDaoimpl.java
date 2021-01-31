package hotel.yun.customer.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
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
	public List<Customer> queryAll() {
		Session session = null;
		session = factory.getCurrentSession();
		String hql = "FROM Customer and Member";
		List<Customer> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;

	}

	@SuppressWarnings("unchecked")

//		@Override
//	public Customer update(String u) {
//		Member mn = null;
//		String hql = "FROM Member m WHERE m.account = :mid";
//		Session session = factory.getCurrentSession();
//		mn = (Member) session.createQuery(hql).setParameter("mid", u).getSingleResult();
//		Customer c = mn.getCustomer();
//		c.setAddress(u);
//		c.setBirthday(null);
//		c.setChinese_name(u);
//		c.setIdcard_number(u);
//		c.setMobile_phone(u);
//		mn.setAccount(u);
//		mn.setEmail(u);
//		mn.setGender(u);
//		mn.setHome_phone(u);
//		mn.setJob(u);
//		mn.setPassword(u);
//	
//		return c;
//	}


	

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
	
	@Override
	public Customer memquerycut(Customer c) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Customer cu WHERE cu.member_id = :md" ;

		Customer customer = (Customer) session.createQuery(hql).setParameter("md", c.getChinese_name()).getSingleResult();
		return customer;
	}
	
	@Override
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

	@Override
	public Customer queryByAc(String s) {
		Member mn = null;
		String hql = "FROM Member m WHERE m.account = :mid";
		Session session = factory.getCurrentSession();
		mn = (Member) session.createQuery(hql).setParameter("mid", s).getSingleResult();
		Customer c = mn.getCustomer();
		
		return c;
	}

	@Override
	public Customer queryByAc1(String s) {
		Member mn = null;
		String hql = "FROM Member m WHERE m.account = :mid";
		Session session = factory.getCurrentSession();
		mn = (Member) session.createQuery(hql).setParameter("mid", s).getSingleResult();
		Customer c = mn.getCustomer();
		
		return c;
	}

	@Override
	public Customer update(Customer cu) {
//		Customer c = query(cu);
		Session session = factory.getCurrentSession();
		session.update(cu);
		return cu;
	}
	
}
	
