package hotel.yun.date.dao.impl;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.date.dao.DateDao;
import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;

@Repository
public class DateDaoImpl implements Serializable, DateDao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	@Override
	public Rdate insert(Rdate r) {
		Session session = factory.getCurrentSession();
		session.save(r);
		return r;
	}
	
	@Override
	public Rdate queryByRDNum(int date_id) {
		Rdate rd = null;
		Session session = factory.getCurrentSession();
		rd = session.get(Rdate.class, date_id);
		return rd;
	}
//	@Override
	public Rdate update(Rdate r) {
		Rdate rd = null;
		Session session = factory.getCurrentSession();
		rd = session.get(Rdate.class, r.getDate_id());
		if(r.getRdate()!=null) {
		rd.setRdate(r.getRdate());
		}
		if(r.getRooms()!= null) {
			rd.setRooms(r.getRooms());
		}
		session.update(rd);
		return rd;
	
	}

	@Override
	public Mdate queryByDatePeriod(Date d,String tp) {
		Session session = factory.getCurrentSession();
		String hql = "FROM mdate md WHERE md.mdate = :dd and md.time_period = :tp";
		Mdate md = (Mdate)session.createQuery(hql).setParameter("dd", d).setParameter("tp", tp).getSingleResult();
		return md;	
	}
	
	@Override
	public Rdate queryByRoomDate(Date rod) {
		Session session = factory.getCurrentSession();
		String hql = "FROM rdate rd WHERE rd.room_date = :rrd";
		Rdate md = (Rdate)session.createQuery(hql).setParameter("rrd", rod).getSingleResult();
		return md;	
	}
	
}
