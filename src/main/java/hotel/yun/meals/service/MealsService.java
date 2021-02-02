package hotel.yun.meals.service;

import java.util.List;

import hotel.yun.meals.model.Meals;
import hotel.yun.meals.model.MealsType;

public interface MealsService {
	public Meals save(Meals mBean);
	public Meals queryMeals_id(int id);
	public MealsType queryMealsType_id(int id);
    public List<Meals> queryAll();
    public void update(Meals mBean); 
    public void delete(int meals_id);
}
