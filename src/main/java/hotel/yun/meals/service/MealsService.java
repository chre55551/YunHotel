package hotel.yun.meals.service;

import java.util.List;

import hotel.yun.meals.model.Meals;
import hotel.yun.meals.model.MealsType;

public interface MealsService {
    Object save(Meals mBean);
    Meals queryMeals_id(int id);
    MealsType queryMealsType_id(int id);
    List<Meals> queryAll();
    void update(Meals mBean); 
	void delete(int meals_id);
}
