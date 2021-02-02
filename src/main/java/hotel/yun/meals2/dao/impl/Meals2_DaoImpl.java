package hotel.yun.meals2.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.meals2.dao.Meals2_Dao;
import hotel.yun.meals2.model.Meals2;



@Repository
public class Meals2_DaoImpl implements Serializable, Meals2_Dao{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Meals2 insert(Meals2 mBean) {
		Session session = factory.getCurrentSession();
		session.save(mBean);
		return mBean;
	}
	
	
	@Override
	public Meals2 queryID(int meals2_id) {
		Session session = factory.getCurrentSession();
		Meals2 bb=session.get(Meals2.class,meals2_id);
		if(bb==null)
			System.out.println("找不到編號"+meals2_id+"的消息");
		return bb;
	}
	
	
	
	@Override
	public List<Meals2> queryAll() {
		String hql="FROM meals2";
		Session session=null;
		List<Meals2> list=new ArrayList<>();
		session=factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}
	
	
	@Override
	public Meals2 update(Meals2 mBean) {
		Session session = factory.getCurrentSession();
		session.update(mBean);
		return mBean;
	}
	
	
	
	@Override
	public boolean delete(int meals2_id) {
		Session session = factory.getCurrentSession();
		Meals2 onemeal = new Meals2();
		onemeal.setMeals2_id(meals2_id);
		session.delete(onemeal);
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
