package hotel.yun.ordered.dao.impl;

import java.io.Serializable;
import java.sql.Date;
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
	
	//新增訂單資訊
	@Override
	public Ordered insert(Ordered oBean) {
		Session session = factory.getCurrentSession();
		session.save(oBean);
		return oBean;
	}

	//依照訂單編號來查詢該筆訂單
	@Override
	public Ordered queryOrderNum(int ordered_number) {
		Ordered od = null;
		Session session = factory.getCurrentSession();
		od = session.get(Ordered.class, ordered_number);
		return od;
	}
	
	//依照訂單編號來查詢所有訂單
	@SuppressWarnings("unchecked")
	@Override							
	public List<Ordered> queryAll(int ordered_number) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Ordered od WHERE od.ordered_number = :onb";
		list = session.createQuery(hql).setParameter("onb", ordered_number).getResultList();
		return list;
	}
	
	//可以從顧客ID去取顧客的所有訂單資料
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryCustomerToOrdered(int customer_id) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql ="FROM Ordered od WHERE od.customer_id = :cid";
		list = session.createQuery(hql).setParameter("cid", customer_id).getResultList();
		return list;
	}
	
	//可查詢該日期的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryDateToOrdered(Date ordered_date) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql ="FROM Ordered od WHERE od.ordered_date = :odd";
		list = session.createQuery(hql).setParameter("cid", ordered_date).getResultList();
		return list;
	}
	
	//依照訂單編號即可修改整張訂單
	@Override
	public Ordered update(Ordered odBean) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE Ordered od SET od.customer_id  = :customer "
				+ ", od.ordered_tomeals_id = :tomeals"
				+ ", od.ordered_toroom_id = :toroom"
				+ ", od.status_id = :status"
				+ ", od.payment_id = :payment"
				+ ", od.ordered_accounts = :accounts"
				+ ", od.ordered_date = :date"
				+ ", od.iv_no = :ivno"
				+ ", od.note = :note"
				+ "WHERE od.ordered_number = :number ";
		
		 session.createQuery(hql)
		        .setParameter("number",odBean.getOrdered_number())
		        .setParameter("customer",odBean.getCustomer())
		        .setParameter("tomeals",odBean.getOrderedToMeals())
		        .setParameter("toroom",odBean.getOrderedToRoom())
		        .setParameter("status",odBean.getOrderedStatus())
		        .setParameter("payment",odBean.getOrderedPayment())
		        .setParameter("accounts",odBean.getOrdered_accounts())
		        .setParameter("date",odBean.getOrdered_date())
		        .setParameter("ivno",odBean.getIv_no())
		        .setParameter("note",odBean.getNote())
		        .executeUpdate();
		return odBean;
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
