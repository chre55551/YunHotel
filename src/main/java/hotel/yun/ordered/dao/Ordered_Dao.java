package hotel.yun.ordered.dao;

import java.util.List;

import hotel.yun.ordered.model.Ordered;

public interface Ordered_Dao {

	public Ordered insert(Ordered oBean);
	public Ordered query(int ordered_number);
	public List<Ordered> queryOrderAll(String ordered_number);//依照訂單編號來查詢整筆訂單資料
	public List<Ordered> getcustomer(String customer_id);//可以從訂單去取整筆顧客的資料
	public Ordered update(Ordered oBean);
	public void delete(int ordered_number);//依照訂單編號來刪除整筆資料
}
