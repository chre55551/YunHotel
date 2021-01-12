package hotel.yun.news.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.news.dao.News_Dao;
import hotel.yun.news.model.News;

@Repository
public class News_DaoImpl implements Serializable, News_Dao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public News insert(News nBean) {
		Session session = factory.getCurrentSession();
		session.save(nBean);
		return nBean;
	}

	@Override
	public News queryNewID(int news_id) {
		Session session = factory.getCurrentSession();
		News bb=session.get(News.class,news_id);
		if(bb==null)
			System.out.println("消息編號"+news_id+"找不到");
		return bb;
	}
	
	@Override
	public List<News> queryAllNews() {
		String hql="FROM news";
		Session session=null;
		List<News> list=new ArrayList<>();
		session=factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public News update(News nbean) {
		Session session = factory.getCurrentSession();
		session.update(nbean);
		return nbean;
	}

	@Override
	public boolean delete(int news_id) {
		Session session = factory.getCurrentSession();
		News onenew = new News();
		onenew.setNews_id(news_id);
		session.delete(onenew);
		return false;
	}

}
