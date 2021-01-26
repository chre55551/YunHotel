package hotel.yun.date.service;

import java.sql.Date;

import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;

	public interface Date_Service {

	public Mdate queryByDatePeriod(Date d, String tp);
	
	public Rdate queryByRoomDate(Date rrd);

	public Rdate insert(Rdate rd);

}
