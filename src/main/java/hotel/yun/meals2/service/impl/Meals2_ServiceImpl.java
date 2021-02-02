package hotel.yun.meals2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.meals2.dao.Meals2_Dao;
import hotel.yun.meals2.model.Meals2;
import hotel.yun.meals2.service.Meals2_Service;

@Transactional
@Service
public class Meals2_ServiceImpl implements Meals2_Service{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	Meals2_Dao MDao;
	
	
	@Override
	public Meals2 insert(Meals2 mBean) {
		return MDao.insert(mBean);
	}
	
	
	@Override
	public Meals2 queryID(int meals2_id) {
		return MDao.queryID(meals2_id);
	}
	
	
	
	@Override
	public List<Meals2> queryAll() {
		return MDao.queryAll();
	}
	
	
	@Override
	public Meals2 update(Meals2 mBean) {
		return MDao.update(mBean);
	}
	
	@Override
	public boolean delete(int meals2_id) {
		return MDao.delete(meals2_id);
	}
	
	
	
}
