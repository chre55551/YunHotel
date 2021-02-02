package hotel.yun.meals2.dao;

import java.util.List;

import hotel.yun.meals2.model.Meals2;



public interface Meals2_Dao {

	public Meals2 insert(Meals2 mBean);	
	public Meals2 queryID(int meals2_id);
	public List<Meals2> queryAll();
	public Meals2 update(Meals2 mBean);
	public boolean delete(int meals2_id);

}