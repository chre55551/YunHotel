package hotel.yun.ordered.dao;

import java.util.List;

import hotel.yun.ordered.model.OrderedStatus;

public interface OrderedStatus_Dao {
	
	public OrderedStatus insert(OrderedStatus osBean);
	public OrderedStatus query(int status_id);
	public List<OrderedStatus> queryAll();
	public OrderedStatus update(OrderedStatus osbean);
	public boolean delete(int status_id);
}
