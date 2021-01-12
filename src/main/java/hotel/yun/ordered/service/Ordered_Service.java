package hotel.yun.ordered.service;

import java.util.List;

import hotel.yun.ordered.model.Ordered;

public interface Ordered_Service {
	
	public Ordered insert(Ordered oBean);
	public Ordered query(int ordered_number);
	public List<Ordered> queryOrderAll(String ordered_number);
	public List<Ordered> getcustomer(String customer_id);
	public List<Ordered> queryDateToOrdered(String ordered_date);
	public void update(Ordered oBean);
	public void delete(int ordered_number);
}
