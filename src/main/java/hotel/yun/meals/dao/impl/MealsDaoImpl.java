package hotel.yun.meals.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.meals.dao.MealsDao;
import hotel.yun.meals.model.Meals;
import hotel.yun.room.model.Room;
@Repository
public  class MealsDaoImpl implements MealsDao {
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
    
	
	public MealsDaoImpl() { 
		
	}
	
	
	
	@Override
	public Object save(Meals mBean) {
		Session session = factory.getCurrentSession();
		return session.save(mBean);
		
	}
	
	@Override
	public Meals queryMeals_id(int id) {
	Meals bean = null;
	Session session = factory.getCurrentSession();
	String hql  = "FROM Meals m WHERE m.meals_id = :id";
	try {
		bean = (Meals)session.createQuery(hql)
								.setParameter("id", id)
								.getSingleResult();
	} catch(NoResultException e) {
		;  // 表示查無紀錄
	}
	
	return bean;
	
}
	@SuppressWarnings("unchecked")
	@Override
	public List<Meals> queryAll() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM Meals";
		List<Meals> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public void update(Meals mBean) {
			Session session = factory.getCurrentSession();
			session.update(mBean);
			
		}
	
	@Override
	public void delete(int meals_id) {
		Session session = factory.getCurrentSession();
		Meals food = new Meals();
		food.setMeals_id(meals_id);
		session.delete(food);
	}
}
