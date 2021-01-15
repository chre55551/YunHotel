package hotel.yun.ordered.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
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
	public Ordered insert(Ordered oBean) {
		
		return oDao.insert(oBean);
	}

	@Override
	public Ordered queryAll(int ordered_number) {
		
		return oDao.queryAll(ordered_number);
	}

	@Override
	public List<Ordered> queryOrderNum(String ordered_number) {
		
		return oDao.queryOrderNum(ordered_number);
	}

	@Override
	public List<Ordered> queryCustomerToOrdered(String customer_id) {
		
		return oDao.queryCustomerToOrdered(customer_id);
	}

	@Override
	public List<Ordered> queryDateToOrdered(String ordered_date) {
	
		return oDao.queryDateToOrdered(ordered_date);
	}

	@Override
	public void update(Ordered oBean) {
		oDao.update(oBean);
	}

	@Override
	public void delete(int ordered_number) {
		oDao.delete(ordered_number);
	}
}
