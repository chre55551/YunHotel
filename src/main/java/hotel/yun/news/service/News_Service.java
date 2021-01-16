package hotel.yun.news.service;

import java.util.List;

import hotel.yun.news.model.News;

public interface News_Service {

	public News insert(News nBean);	
	public News queryNewID(int news_id);
	public List<News> queryAllNews();
	public News update(News nbean);
	public boolean delete(int news_id);

}
