package hotel.yun.meals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.meals.dao.MealsDao;
import hotel.yun.meals.model.Meals;
import hotel.yun.meals.service.MealsService;



@Transactional
@Service
public class MealsServiceImpl  implements MealsService {
    
	MealsDao MDao;
	
	@Autowired
	public void setRDao(MealsDao MDao) {
		this.MDao = MDao;
	}
	
	
	@Override
	public Object save(Meals mBean) {
		return MDao.save(mBean);
	}
	
	
	@Override
	public Meals queryMeals_id(int meals_id) {
	
		return MDao.queryMeals_id(meals_id);
	}
	
    
	@Override
	public List<Meals> queryAll() {
		return MDao.queryAll();
	}
	
	
	
	@Override
	public void update(Meals mBean) {
		MDao.update(mBean);
	}
	
	
	@Override
	public void delete(int meals_id) {
		MDao.delete(meals_id);
	}
	
}
