package hotel.yun.date.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.date.dao.DateDao;
import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;
import hotel.yun.date.service.Date_Service;

@Transactional
@Service
public class DateServiceImpl implements Date_Service {

	@Autowired
	private DateDao dDao;
	@Override
	public Mdate queryByDatePeriod(Date d,String tp) {
		Mdate md = dDao.queryByDatePeriod(d, tp);
		return md;
		
	}
	@Override
	public Rdate queryByRoomDate(Date rrd) {
		Rdate rd = dDao.queryByRoomDate(rrd);
		return rd;
	}
	
	@Override
	public Rdate insert(Rdate rd) {
		return dDao.insert(rd);	
	}
	 
	@Override
	public Mdate queryByMealDate(Mdate mmd) {
		Mdate md = dDao.queryByMealDate(mmd);
		return md;
	}
	@Override
	public Mdate queryByMealDate(Date mmd) {
		// TODO Auto-generated method stub
		return null;
	}
}
