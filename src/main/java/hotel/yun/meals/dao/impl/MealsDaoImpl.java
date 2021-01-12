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
	public Meals getMeals_id(int id) {
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
	public List<Meals> getAll() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM Meals";
		List<Meals> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	@Override
	public void update(Meals mbean) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE Meals m SET m.meals_price  = :price "
				+ ", m.meals_stock = :stock"
				+ ", m.meals_typeid = :typeid"
				+ "WHERE m.meals_name = :name ";
		
		session.createQuery(hql)
		        .setParameter("name",mbean.getMeals_name())
		        .setParameter("stock",mbean.getMeals_stock())
		        .setParameter("price",mbean.getMeals_price())
		        .setParameter("typeid",mbean.getMealsType().getMeals_typeid())
		        .executeUpdate();
	}
	@Override
	public void delete(int key) {
		Session session = factory.getCurrentSession();
		Meals food = new Meals();
		food.setMeals_id(key);
		session.delete(food);
	}
}
