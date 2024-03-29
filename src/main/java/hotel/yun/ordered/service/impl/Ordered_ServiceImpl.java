package hotel.yun.ordered.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.date.model.Rdate;
import hotel.yun.meals.model.Meals;
import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.service.Ordered_Service;
import hotel.yun.room.model.Room;

@Transactional
@Service
public class Ordered_ServiceImpl implements Ordered_Service {
	
	@Autowired
	private Ordered_Dao oDao;

	public void setoDao(Ordered_Dao oDao) {
		this.oDao = oDao;
	}

	@Override
	public Ordered insert(Ordered oBean) {	
		OrderedStatus ods  = oDao.queryS(1);
		oBean.setOrderedStatus(ods);
		
//		OrderedPayment odp = oDao.queryP(1);
//		oBean.setOrderedPayment(odp);
		
//		oBean.setOrderedStatus(new OrderedStatus());
//		oBean.getOrderedStatus().setStatus_id(1);
		
		Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		oBean.setOrdered_date(c);
		
		
		try {
			double p = oBean.getOrderedToRoom().getRoom().getRoomType().getRoom_price();
			System.out.println(p);
			int days = oBean.getOrderedToRoom().getRdates().size();
			System.out.println(days);
			oBean.getOrderedToRoom().setRoom_accounts((int)p*days);
			oBean.setOrdered_accounts((int)p*days);
		}catch(Exception er) {
				int zero = 0;
				int mp = 0;
				List<Meals> ml = oBean.getOrderedToMeals().getMeals();
				for(Meals meal:ml) {
					int singleMeal = (int)meal.getMeals_price();
					mp = zero + singleMeal;
				}
				System.out.println(mp);
				oBean.getOrderedToMeals().setMeals_accounts(mp);
				oBean.setOrdered_accounts(mp);
//				er.printStackTrace();
		}
		
		try {
			double p = oBean.getOrderedToRoom().getRoom().getRoomType().getRoom_price();
			int days = oBean.getOrderedToRoom().getRdates().size();
			oBean.getOrderedToRoom().setRoom_accounts((int)p*days);
			int zero = 0;
			int mp = 0;
			List<Meals> ml = oBean.getOrderedToMeals().getMeals();
			for(Meals meal:ml) {
				int singleMeal = (int)meal.getMeals_price();
				mp = zero + singleMeal;
			}
			oBean.getOrderedToMeals().setMeals_accounts(mp);
			oBean.setOrdered_accounts(oBean.getOrderedToMeals().getMeals_accounts()+oBean.getOrderedToRoom().getRoom_accounts());
		}catch(Exception e) {
//			e.printStackTrace();
		}
		Ordered od;
		try {
			od = oDao.insert(oBean);
			return od;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ordered queryOrderNum(int ordered_number) {
		
		return oDao.queryOrderNum(ordered_number);
	}

	@Override
	public List<Ordered> queryAll(int ordered_number) {
		
		return oDao.queryAll(ordered_number);
	}

	@Override
	public List<Ordered> queryCustomerToOrdered(int customer_id) {
		
		return oDao.queryCustomerToOrdered(customer_id);
	}

	@Override
	public List<Ordered> queryDateToOrdered(Date ordered_date) {
	
		return oDao.queryDateToOrdered((java.sql.Date) ordered_date);
	}
	@Override
	public void updateCustomerOd(Ordered odBean) {
//		Date currentTime = new Date();
//		DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String dateStr = sdf.format(currentTime); 
//		Timestamp ts = Timestamp.valueOf(dateStr);
		Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		odBean.setOrdered_last_update(c);
		oDao.updateCustomerOd(odBean);
		
	}
	
	@Override
	public void delete(int ordered_number) {
		oDao.delete(ordered_number);
	}

	@Override
	public List<Ordered> queryDateToOrdered(java.sql.Date ordered_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordered> queryDateToOrdered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderedToRoom insertOTR(OrderedToRoom otr) {	
		return oDao.insertOTR(otr);
	}

	@Override
	public void updateOTR(OrderedToRoom orderedToRoom) {
		oDao.updateOTR(orderedToRoom);
	}

	@Override
	public OrderedStatus queryStatusByS(String ordered_status) {
		return oDao.queryStatusByS(ordered_status);
	}

	@Override
	public OrderedPayment queryPaymentBys(String bill_status) {
		return oDao.queryPaymentBys(bill_status);
	}

	@Override
	public Ordered queryOdByRoomAndRdate(Room room, Rdate rdate) {
		return oDao.queryOdByRoomAndRdate(room, rdate);
	}

	@Override
	public void checkout(Ordered od) {
		
		
	}

	@Override
	public void room_checkout(Ordered od , String bill_status) {
		Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		OrderedPayment op = oDao.queryOP(2);
		OrderedStatus os = oDao.queryOS(od,bill_status);
		od.setOrderedPayment(op);
		od.setOrderedStatus(os);
//		od.getOrderedStatus();
		od.setOrdered_last_update(c);
		od.setOrdered_finish_date(c);
		
	}
}
