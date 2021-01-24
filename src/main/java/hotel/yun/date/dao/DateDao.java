package hotel.yun.date.dao;

import hotel.yun.date.model.RDate;

public interface DateDao {

	public RDate insert(RDate r);

	RDate queryByRDNum(int date_id);

}
