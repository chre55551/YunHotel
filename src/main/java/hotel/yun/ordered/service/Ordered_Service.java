package hotel.yun.ordered.service;

import java.sql.Date;
import java.util.List;

import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.ordered.model.Ordered;
import hotel.yun.ordered.model.OrderedPayment;
import hotel.yun.ordered.model.OrderedStatus;

public interface Ordered_Service {
	
	public Ordered insert(Ordered oBean) throws Exception;//新增訂單資訊
	public Ordered queryOrderNum(int ordered_number);//依照訂單編號來查詢該筆訂單
	public List<Ordered> queryAll(int ordered_number);//依照訂單編號來查詢所有訂單
	public List<Ordered> queryCustomerToOrdered(int customer_id);//可以從顧客ID去取顧客的所有訂單資料
	public List<Ordered> queryDateToOrdered(Date ordered_date);//可查詢該日期的所有訂單
	public void updateCustomerOd(Ordered odBean);//依顧客尋找的詳細訂單，來做更新
	public void delete(int ordered_number);//依照訂單編號來刪除整筆資料
	public List<Ordered> queryDateToOrdered(java.util.Date date);
	public List<Ordered> queryDateToOrdered();
	public OrderedToRoom insertOTR(OrderedToRoom otr);
	public void updateOTR(OrderedToRoom orderedToRoom);
	public OrderedStatus queryStatusByS(String ordered_status);
	public OrderedPayment queryPaymentBys(String bill_status);
}
