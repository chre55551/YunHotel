package hotel.yun.meals.dao;

import java.util.List;

import hotel.yun.meals.model.Meals;



public interface MealsDao {
	    Object save(Meals mBean);
	    Meals getMeals_id(int id);
	    List<Meals> getAll();
	    void update(Meals mbean); 
		void delete(int key);
}

//public boolean delete(int meals_id);
//public Meals update(Meals mBean );
//public List<Meals> queryAll();
//public Meals query(int meals_id);