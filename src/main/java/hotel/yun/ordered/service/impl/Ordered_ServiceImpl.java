package hotel.yun.ordered.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.service.Ordered_Service;
@Service
public class Ordered_ServiceImpl implements Ordered_Service {
	
	@Autowired
	private Ordered_Dao oDao;
	
	@Override
	public Ordered insert(Ordered oBean) {
		
		return null;
	}

	@Override
	public Ordered query(int ordered_number) {
		
		return null;
	}

	@Override
	public List<Ordered> queryOrderAll(String ordered_number) {
		
		return null;
	}

	@Override
	public List<Ordered> getcustomer(String customer_id) {
		
		return null;
	}

	@Override
	public List<Ordered> queryDateToOrdered(String ordered_date) {
	
		return null;
	}

	@Override
	public void update(Ordered oBean) {
		
		
	}

	@Override
	public void delete(int ordered_number) {
		
		
	}

	
}
