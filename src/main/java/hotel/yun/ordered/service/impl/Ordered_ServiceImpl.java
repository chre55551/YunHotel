package hotel.yun.ordered.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.date.model.Rdate;
import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;
import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.service.Ordered_Service;

@Transactional
@Service
public class Ordered_ServiceImpl implements Ordered_Service {
	
	@Autowired
	private Ordered_Dao oDao;

	public void setoDao(Ordered_Dao oDao) {
		this.oDao = oDao;
	}

	@Override
	public Ordered insert(Ordered oBean)  throws Exception{	
		OrderedStatus ods  = oDao.queryS(1);
		oBean.setOrderedStatus(ods);
		
		OrderedPayment odp = oDao.queryP(1);
		oBean.setOrderedPayment(odp);
		
		
		Timestamp c = new java.sql.Timestamp(System.currentTimeMillis());
		oBean.setOrdered_date(c);
		return oDao.insert(oBean);
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

}
