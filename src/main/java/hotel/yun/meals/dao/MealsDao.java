package hotel.yun.meals.dao;

import java.util.List;

import hotel.yun.meals.model.Meals;



public interface MealsDao {
	    Object save(Meals mBean);
	    Meals queryMeals_id(int id);
	    List<Meals> queryAll();
	    void update(Meals mBean); 
		void delete(int meals_id);
}

//public boolean delete(int meals_id);
//public Meals update(Meals mBean );
//public List<Meals> queryAll();
//public Meals query(int meals_id);