package hotel.yun.ordered.dao;

import java.util.List;

import hotel.yun.ordered.model.Ordered;

public interface Ordered_Dao {

	public Ordered insert(Ordered oBean);//新增訂單資訊
	public Ordered queryAll(int ordered_number);//依照訂單編號來查詢所有訂單資料
	public List<Ordered> queryOrderNum(String ordered_number);//依照訂單編號可以查到該筆訂單資訊
	public List<Ordered> queryCustomerToOrdered(String customer_id);//可以從顧客ID去取顧客的所有訂單資料
	public List<Ordered> queryDateToOrdered(String ordered_date);//可查詢該日期的所有訂單
	public void update(Ordered oBean);//依照訂單編號即可修改整張訂單
	public void delete(int ordered_number);//依照訂單編號來刪除整筆資料
}
