package hotel.yun.news.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "news")
	public class News implements Serializable{
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int news_id ;//消息編號 
	 
	 private Date news_date;// 消息上傳時間
	 private Date news_updated_date;// 消息更新時間
	 private String news_content;// 消息內容
	
	 public News() {

		}

	 public News(int news_id,Date news_date,Date news_updated_date,String news_content) {
			super();
			this.news_id = news_id;
			this.news_date = news_date;
			this.news_updated_date = news_updated_date;
			this.news_content = news_content;
		}
	 
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public Date getNews_updated_date() {
		return news_updated_date;
	}
	public void setNews_updated_date(Date news_updated_date) {
		this.news_updated_date = news_updated_date;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	 
}
