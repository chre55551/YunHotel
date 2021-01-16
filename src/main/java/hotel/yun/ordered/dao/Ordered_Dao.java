package hotel.yun.ordered.dao;

import java.sql.Date;
import java.util.List;

import hotel.yun.ordered.model.Ordered;

public interface Ordered_Dao {

	public Ordered insert(Ordered oBean);//新增訂單資訊
	public Ordered queryOrderNum(int ordered_number);//依照訂單編號來查詢該筆訂單
	public List<Ordered> queryAll(int ordered_number);//依照訂單編號來查詢所有訂單
	public List<Ordered> queryCustomerToOrdered(int customer_id);//可以從顧客ID去取顧客的所有訂單資料
	public List<Ordered> queryDateToOrdered(Date ordered_date);//可查詢該日期的所有訂單
	public Ordered update(Ordered oBean);//依照訂單編號即可修改整張訂單
	public void delete(int ordered_number);//依照訂單編號來刪除整筆資料
}
