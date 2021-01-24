package hotel.yun.date.dao;

import hotel.yun.date.model.Rdate;

public interface DateDao {

	public Rdate insert(Rdate r);

	Rdate queryByRDNum(int date_id);

}
