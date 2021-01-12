package hotel.yun.ordered.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;

@Repository
public class Ordered_DaoImpl implements Serializable, Ordered_Dao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Ordered insert(Ordered oBean) {
		Session session = factory.getCurrentSession();
		session.save(oBean);
		return oBean;
	}

	@Override
	public Ordered query(int ordered_number) {
		Ordered od = null;
		Session session = factory.getCurrentSession();
		od = session.get(Ordered.class, ordered_number);
		return od;
	}
	
	//依照訂單編號來查詢整筆訂單資料
	@SuppressWarnings("unchecked")
	@Override							//為何用String?
	public List<Ordered> queryOrderAll(String ordered_number) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Ordered od WHERE od.ordered_number = :onb";
		list = session.createQuery(hql).setParameter("onb", ordered_number).getResultList();
		return list;
	}
	
	//可以從顧客ID去取顧客的所有訂單資料
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> getcustomer(String customer_id) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql ="FROM Ordered od WHERE od.customer_id = :cid";
		list = session.createQuery(hql).setParameter("cid", customer_id).getResultList();
		return list;
	}
	//可查詢該日期的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryDateToOrdered(String ordered_date) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql ="FROM Ordered od WHERE od.ordered_date = :odd";
		list = session.createQuery(hql).setParameter("cid", ordered_date).getResultList();
		return list;
	}
	
	@Override
	public Ordered update(Ordered oBean) {
		
		return null;
	}

	//依照訂單編號來刪除整筆資料
	@Override
	public void delete(int ordered_number) {
	Session session = factory.getCurrentSession();
	Ordered od = new Ordered();
	od.setOrdered_number(ordered_number);
	session.delete(od);
	}



}
