package hotel.yun.meals.service;

import java.util.List;

import hotel.yun.meals.model.Meals;

public interface MealsService {
    Object save(Meals mBean);
    Meals queryMeals_id(int id);
    List<Meals> queryAll();
    void update(Meals mBean); 
	void delete(int meals_id);
}
