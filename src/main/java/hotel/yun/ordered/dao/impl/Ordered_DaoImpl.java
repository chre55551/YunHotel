package hotel.yun.ordered.dao.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToMeals;
import hotel.yun.ordered.model.OrderedToRoom;

@Repository
public class Ordered_DaoImpl implements Serializable, Ordered_Dao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	//新增訂單資訊
	@Override
	public Ordered insert(Ordered oBean) throws Exception{
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
		Session session = factory.getCurrentSession();
		String hql ="from Ordered where customer_id = :cid";
		Query<Ordered> query= session.createQuery(hql);
		
		List<Ordered> list = query.setParameter("cid",customer_id).getResultList();
		return list;
	}
	
	//可查詢該日期的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryDateToOrdered(Date ordered_date) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql ="FROM Ordered od WHERE od.ordered_date = :odd";
		list = session.createQuery(hql)
				.setParameter("cid", ordered_date).getResultList();
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
				+ ", od.ordered_last_update = :lastupdate"
				+ ", od.ordered_finish_date = :finishdate"
				+ ", od.ordered_date = :date"
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
		        .setParameter("lastupdate",odBean.getOrdered_last_update())
		        .setParameter("finishdate",odBean.getOrdered_finish_date())
		        .setParameter("note",odBean.getNote())
		        .executeUpdate();
		return odBean;
	}
	//依顧客尋找的詳細訂單，來做更新
	@Override
	public void updateCustomerOd(Ordered odBean) {
		Session session = factory.getCurrentSession();
		Ordered customerOd = session.get(Ordered.class, odBean.getOrdered_number());
		if(odBean.getCustomer().getChinese_name()!=null) {
			customerOd.getCustomer().setChinese_name(odBean.getCustomer().getChinese_name());
		}
		if(odBean.getCustomer().getMobile_phone()!=null) {
			customerOd.getCustomer().setMobile_phone(odBean.getCustomer().getMobile_phone());
		}
		//-------------------------
		if(odBean.getOrderedToMeals().getTable_number()!=0) { //當更有更新值時
			if(customerOd.getOrderedToMeals()!=null) { //資料庫取出的 Ordered 有 OrderedToMeals 物件時
				customerOd.getOrderedToMeals().setTable_number(odBean.getOrderedToMeals().getTable_number()); // get後 set 更新值
			}else { // 當沒有 OrderedToMeals 物件時 new 一個塞進去 再塞桌號
				customerOd.setOrderedToMeals(new OrderedToMeals());
				customerOd.getOrderedToMeals().setTable_number(odBean.getOrderedToMeals().getTable_number());
			}
		}
		//-------------------------
		if(odBean.getOrderedToRoom().getRoom_number()!=0) {
			if(customerOd.getOrderedToRoom()!=null) {
			customerOd.getOrderedToRoom().setRoom_number(odBean.getOrderedToRoom().getRoom_number());
			}else {
				customerOd.setOrderedToRoom(new OrderedToRoom());
				customerOd.getOrderedToRoom().setRoom_number(odBean.getOrderedToRoom().getRoom_number());
			}
		}
		//-------------------------		
		if(odBean.getOrderedStatus().getOrdered_status()!=null) {
			if(customerOd.getOrderedStatus()!=null) {
			customerOd.getOrderedStatus().setOrdered_status(odBean.getOrderedStatus().getOrdered_status());
			}else {
				customerOd.setOrderedStatus(new OrderedStatus());
				customerOd.getOrderedStatus().setOrdered_status(odBean.getOrderedStatus().getOrdered_status());
			}
		}
		//-------------------------
		if(odBean.getOrderedPayment().getPayment_status()!=null) {
			if(customerOd.getOrderedPayment()!=null) {
			customerOd.getOrderedPayment().setPayment_status(odBean.getOrderedPayment().getPayment_status());
			}else {
				customerOd.setOrderedPayment(new OrderedPayment());
				customerOd.getOrderedPayment().setPayment_status(odBean.getOrderedPayment().getPayment_status());
			}
		}
		//-------------------------
		if(odBean.getOrdered_accounts()!=0) {
			customerOd.setOrdered_accounts(odBean.getOrdered_accounts());
		}
		if(odBean.getOrdered_last_update()!=null) {
			customerOd.setOrdered_last_update(odBean.getOrdered_last_update());
		}
		if(odBean.getNote()!=null){
			customerOd.setNote(odBean.getNote());
		}
		session.update(customerOd);
	}
	 
	//依照訂單編號來刪除整筆資料
	@Override
	public void delete(int ordered_number) {
	Session session = factory.getCurrentSession();
	Ordered od = new Ordered();
	od.setOrdered_number(ordered_number);
	session.delete(od);
	}

	@Override
	public OrderedStatus query(int i) {
		Session session = factory.getCurrentSession();
		OrderedStatus ods = session.get(OrderedStatus.class, i);
		return ods;
	}



}
