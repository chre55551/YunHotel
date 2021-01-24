package hotel.yun.date.service;

import java.sql.Date;

import hotel.yun.date.model.Mdate;

	public interface Date_Service {

	public Mdate queryByDatePeriod(Date d, String tp);

}
