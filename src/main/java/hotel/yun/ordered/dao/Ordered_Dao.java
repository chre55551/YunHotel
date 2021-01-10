package hotel.yun.ordered.dao;

import java.util.List;

import hotel.yun.ordered.model.Ordered;

public interface Ordered_Dao {

	public Ordered insert(Ordered oBean);
	public Ordered query(int ordered_number);
	public List<Ordered> queryAll();
	public Ordered update(Ordered obean);
	public boolean delete(int ordered_number);
}
