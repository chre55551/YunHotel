package hotel.yun.bmember.dao.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import hotel.yun.bmember.dao.BmemberDao;
import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Customer;


@Repository
public class BmemberDaoImpl implements Serializable, BmemberDao {

	private static final long serialVersionUID = 1L;

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(BmemberBean nBean) {
		Session session = factory.getCurrentSession();
		session.save(nBean);

	}

	@Override
	public BmemberBean queryMemberID(int bs_id) {
		Session session = factory.getCurrentSession();
		BmemberBean bb = session.get(BmemberBean.class, bs_id);
		if (bb == null)
			System.out.println("會員編號" + bs_id + "找不到");
		return bb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BmemberBean> queryAllMember() {
		Session session = null;
		session = factory.getCurrentSession();
		String hql = "FROM BmemberBean";
		List<BmemberBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;

	}

	@Override
	public BmemberBean update(BmemberBean nbean) {
		Session session = factory.getCurrentSession();
		session.update(nbean);
		return nbean;
	}

	@Override
	public boolean delete(int bs_id) {
		Session session = factory.getCurrentSession();
		BmemberBean onemember = new BmemberBean();
		onemember.setBs_id(bs_id);
		session.delete(onemember);
		return false;
	}

	public BmemberBean checkIdPassword(String account, String password) {
		BmemberBean mb = null;
		String hql = "FROM BmemberBean m WHERE m.bs_account = :mid and m.bs_password = :pwsd";
		Session session = factory.getCurrentSession();
		try {
			mb = (BmemberBean) session.createQuery(hql).setParameter("mid", account).setParameter("pwsd", password)
					.getSingleResult();
			return mb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BmemberBean getCustomerById(int bs_id) {

		BmemberBean bean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM BmemberBean cb WHERE cb.bs_id = :id";
		try {
			bean = (BmemberBean) session.createQuery(hql).setParameter("id", bs_id).getSingleResult();
		} catch (NoResultException e) {
			; // 表示查無紀錄
		}

		return bean;

	}


		@SuppressWarnings("unchecked")
		@Override
		public List<Customer> queryAllMember1() {
			Session session = null;
			session = factory.getCurrentSession();
			String hql = "FROM BmemberBean";
			List<Customer> list = new ArrayList<>();
			list = session.createQuery(hql).getResultList();
			System.out.println(list);
			return list;
		}
}
