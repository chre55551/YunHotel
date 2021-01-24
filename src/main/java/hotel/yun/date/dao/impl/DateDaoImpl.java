package hotel.yun.date.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.date.dao.DateDao;
import hotel.yun.date.model.RDate;
import hotel.yun.ordered.model.Ordered;

@Repository
public class DateDaoImpl implements Serializable, DateDao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	@Override
	public RDate insert(RDate r) {
		Session session = factory.getCurrentSession();
		session.save(r);
		return r;
	}
	
	@Override
	public RDate queryByRDNum(int date_id) {
		RDate rd = null;
		Session session = factory.getCurrentSession();
		rd = session.get(RDate.class, date_id);
		return rd;
	}
//	@Override
	public RDate update(RDate r) {
		RDate rd = null;
		Session session = factory.getCurrentSession();
		rd = session.get(RDate.class, r.getDate_id());
		if(r.getRoom_date()!=null) {
		rd.setRoom_date(r.getRoom_date());
		}
		if(r.getRooms()!= null) {
			rd.setRooms(r.getRooms());
		}
		session.update(rd);
		return rd;
	
	}
	
}
