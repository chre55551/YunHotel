package hotel.yun.date.dao;

import java.sql.Date;

import hotel.yun.date.model.Mdate;
import hotel.yun.date.model.Rdate;

public interface DateDao {

	public Rdate insert(Rdate r);

	public Rdate queryByRDNum(int date_id);

	public Mdate queryByDatePeriod(Date d, String tp);

	public Rdate queryByRoomDate(Date rrd);

}
