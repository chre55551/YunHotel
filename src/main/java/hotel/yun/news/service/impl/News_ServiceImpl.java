package hotel.yun.news.service.impl;

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
public class News_ServiceImpl implements Serializable, News_Dao {
	private static final long serialVersionUID = 1L;
	
	News_Dao NDao;
	
	@Override
	public News insert(News nBean) {
		return NDao.insert(nBean);
	}

	@Override
	public News queryNewID(int news_id) {
		return NDao.queryNewID(news_id);
	}
	
	@Override
	public List<News> queryAllNews() {
		return NDao.queryAllNews();
	}

	@Override
	public News update(News nbean) {
		return NDao.update(nbean);
	}

	@Override
	public boolean delete(int news_id) {
		return NDao.delete(news_id);
	}

}
