package hotel.yun.meals.dao;

import java.util.List;

import hotel.yun.meals.model.Meals;
import hotel.yun.meals.model.MealsType;



public interface MealsDao {
	public void save(Meals mBean);
	public Meals queryMeals_id(int id);
	public List<Meals> queryAll();
	public void update(Meals mBean); 
	public void delete(int meals_id);
	public MealsType queryMealsType_id(int id);
}

//public boolean delete(int meals_id);
//public Meals update(Meals mBean );
//public List<Meals> queryAll();
//public Meals query(int meals_id);