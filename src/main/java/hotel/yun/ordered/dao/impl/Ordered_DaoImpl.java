package hotel.yun.ordered.dao.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.date.model.Rdate;
import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.room.model.Room;

@Repository
public class Ordered_DaoImpl implements Serializable, Ordered_Dao {
	private static final long serialVersionUID = 1L;

	@Autowired
	SessionFactory factory;

	// 新增訂單資訊
	@Override
	public Ordered insert(Ordered oBean) throws Exception {
		Session session = factory.getCurrentSession();
		session.save(oBean);
		return oBean;
	}
//-----------------------------------------------------------------------------
	// 依照訂單編號來查詢該筆訂單
	@Override
	public Ordered queryOrderNum(int ordered_number) {
		Ordered od = null;
		Session session = factory.getCurrentSession();
		od = session.get(Ordered.class, ordered_number);
		return od;
	}
//-----------------------------------------------------------------------------
	// 查訂單狀態
	@Override
	public OrderedStatus queryS(int i) {
		Session session = factory.getCurrentSession();
		OrderedStatus ods = session.get(OrderedStatus.class, i);
		return ods;
	}
//-----------------------------------------------------------------------------
	// 查付款狀態
	@Override
	public OrderedPayment queryP(int i) {
		Session session = factory.getCurrentSession();
		OrderedPayment odp = session.get(OrderedPayment.class, i);
		return odp;
	}

//-----------------------------------------------------------------------------
	// 依照訂單編號來查詢所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryAll(int ordered_number) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Ordered od WHERE od.ordered_number = :onb";
		list = session.createQuery(hql).setParameter("onb", ordered_number).getResultList();
		return list;
	}
//-----------------------------------------------------------------------------
	// 可以從顧客ID去取顧客的所有訂單資料
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryCustomerToOrdered(int customer_id) {
		Session session = factory.getCurrentSession();
		String hql = "from Ordered where customer_id = :cid";
		Query<Ordered> query = session.createQuery(hql);

		List<Ordered> list = query.setParameter("cid", customer_id).getResultList();
		return list;
	}
//-----------------------------------------------------------------------------
	// 可查詢該日期的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryDateToOrdered(Date ordered_date) {
		List<Ordered> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Ordered od WHERE od.ordered_date = :odd";
		list = session.createQuery(hql).setParameter("cid", ordered_date).getResultList();
		return list;
	}
//-----------------------------------------------------------------------------
	// 依顧客尋找的詳細訂單，來做更新
	@Override
	public void updateCustomerOd(Ordered odBean) {
		Session session = factory.getCurrentSession();
		Ordered customerOd = session.get(Ordered.class, odBean.getOrdered_number());
		session.update(customerOd);
//		if(odBean.getCustomer().getChinese_name()!=null) {
//			customerOd.getCustomer().setChinese_name(odBean.getCustomer().getChinese_name());
//		}
//		if(odBean.getCustomer().getMobile_phone()!=null) {
//			customerOd.getCustomer().setMobile_phone(odBean.getCustomer().getMobile_phone());
//		}
//		//-------------------------
//		if(odBean.getOrderedToMeals().getTable_number()!=0) { //當更有更新值時
////			if(customerOd.getOrderedToMeals()!=null) { //資料庫取出的 Ordered 有 OrderedToMeals 物件時
//				customerOd.getOrderedToMeals().setTable_number(odBean.getOrderedToMeals().getTable_number()); // get後 set 更新值
////			}else { // 當沒有 OrderedToMeals 物件時 new 一個塞進去 再塞桌號
////				customerOd.setOrderedToMeals(new OrderedToMeals());
////				customerOd.getOrderedToMeals().setTable_number(odBean.getOrderedToMeals().getTable_number());
////			}
//		}
//		//-------------------------
//		if(odBean.getOrderedToRoom().getRoom_number()!=0) {
////			if(customerOd.getOrderedToRoom()!=null) {
//			customerOd.getOrderedToRoom().setRoom_number(odBean.getOrderedToRoom().getRoom_number());
////			}else {
////				customerOd.setOrderedToRoom(new OrderedToRoom());
////				customerOd.getOrderedToRoom().setRoom_number(odBean.getOrderedToRoom().getRoom_number());
////			}
//		}
//		//-------------------------		
//		if(odBean.getOrderedStatus().getOrdered_status()!=null) {
////			if(customerOd.getOrderedStatus()!=null) {
//			customerOd.getOrderedStatus().setOrdered_status(odBean.getOrderedStatus().getOrdered_status());
////			}else {
////				customerOd.setOrderedStatus(new OrderedStatus());
////				customerOd.getOrderedStatus().setOrdered_status(odBean.getOrderedStatus().getOrdered_status());
////			}
//		}
//		//-------------------------
//		if(odBean.getOrderedPayment().getBill_status()!=null) {
////			if(customerOd.getOrderedPayment()!=null) {
//			customerOd.getOrderedPayment().setBill_status(odBean.getOrderedPayment().getBill_status());
////		}else {
////				customerOd.setOrderedPayment(new OrderedPayment());
////				customerOd.getOrderedPayment().setBill_status(odBean.getOrderedPayment().getBill_status());
////			}
//		}
//		//-------------------------
//		if(odBean.getOrdered_accounts()!=0) {
//			customerOd.setOrdered_accounts(odBean.getOrdered_accounts());
//		}
//		if(odBean.getOrdered_last_update()!=null) {
//			customerOd.setOrdered_last_update(odBean.getOrdered_last_update());
//		}
//		if(odBean.getNote()!=null){
//			customerOd.setNote(odBean.getNote());
//		}
	}
//-----------------------------------------------------------------------------
	// 依照訂單編號來刪除整筆資料
	@Override
	public void delete(int ordered_number) {
		Session session = factory.getCurrentSession();
		Ordered od = new Ordered();
		od.setOrdered_number(ordered_number);
		session.delete(od);
	}
	
	@Override
	public OrderedToRoom insertOTR(OrderedToRoom otr) {
		Session session = factory.getCurrentSession();
		System.out.println("pekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopekopeko");
//		System.out.println(otr.getRdates().get(0).getRdate());
		session.save(otr);
		return otr;
	}
	@Override
	public void updateOTR(OrderedToRoom orderedToRoom) {
		Session session = factory.getCurrentSession();
		OrderedToRoom otr = new OrderedToRoom();
		otr = (OrderedToRoom)session.get(OrderedToRoom.class, otr.getOrdered_toroom_id());
		if(orderedToRoom.getRdates()!=null) {
			otr.setRdates(orderedToRoom.getRdates());
		}
		if(orderedToRoom.getRoom()!=null) {
			otr.setRoom(orderedToRoom.getRoom());
		}
		if(orderedToRoom.getRoom_accounts()!=0) {
			otr.setRoom_accounts(orderedToRoom.getRoom_accounts());
		}
		if(orderedToRoom.getRoomnum_of_people()!=0) {
			otr.setRoomnum_of_people(orderedToRoom.getRoomnum_of_people());
		}
		session.update(otr);
	}
	
	@Override
	public OrderedStatus queryStatusByS(String ordered_status) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderedStatus os WHERE os.ordered_status = :oos";
		OrderedStatus os = (OrderedStatus)session.createQuery(hql).setParameter("oos", ordered_status).getSingleResult();
		return os;
	}
	@Override
	public OrderedPayment queryPaymentBys(String bill_status) {
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderedPayment op WHERE op.bill_status = :obs";
		OrderedPayment op = (OrderedPayment)session.createQuery(hql).setParameter("obs", bill_status).getSingleResult();
		return op;
	}
	@Override
	public Ordered queryOdByRoomAndRdate(Room room, Rdate rdate) {
		Session session = factory.getCurrentSession();
		Ordered od = new Ordered();
		String hql = "from OrderedToRoom otr where otr.room in (from Room rm  where rm.room_name = :rmn)";
		Room room_result = (Room)session.createQuery(hql).setParameter("rmn", room.getRoom_name()).getSingleResult();
//		Set<Rdate> rdates = od.getOrderedToRoom().getRdates();
//		for(Rdate rdateqq:rdates) {
//			
//		}
//		od.getOrderedToRoom().getRoom();
//		String hql = "from OrderedToRoom otr where otr.room in (from Room rm  where rm.room_name = :rmn ) and otr.rdates ";
		return null;
	}

}
