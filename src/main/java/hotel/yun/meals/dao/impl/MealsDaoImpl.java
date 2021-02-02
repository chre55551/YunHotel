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
import hotel.yun.meals.model.MealsType;

@Repository
public class MealsDaoImpl implements MealsDao {
	
	
	@Autowired
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public MealsDaoImpl() {

	}

	@Override
	public void save(Meals mBean) {
		Session session = factory.getCurrentSession();
		session.save(mBean);

	}

	@Override
	public Meals queryMeals_id(int id) {
		Meals mBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Meals m WHERE m.meals_id = :id";
		try {
			mBean = (Meals) session.createQuery(hql).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			// 表示查無紀錄
			e.printStackTrace();
		}
		return mBean;
	}
	
	@Override
	public MealsType queryMealsType_id(int id) {
		MealsType mtBean = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM meals_type m WHERE m.meals_typeid = :id";
		try {
			mtBean = (MealsType) session.createQuery(hql).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			// 表示查無紀錄
			e.printStackTrace();
		}
		return mtBean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meals> queryAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Meals";
		List<Meals> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void update(Meals mBean) {
		Session session = factory.getCurrentSession();
		Meals meals = session.get(Meals.class, mBean.getMeals_id());
		session.update(meals);
	}

	@Override
	public void delete(int meals_id) {
		Session session = factory.getCurrentSession();
		Meals food = new Meals();
		food.setMeals_id(meals_id);
		session.delete(food);
	}
}
