package hotel.yun.meals.dao;

import java.util.List;

import hotel.yun.meals.model.Meals;



public interface MealsDao {
		public Meals insert(Meals mBean);
		public Meals query(int meals_id);
		public List<Meals> queryAll();
		public Meals update(Meals mBean );
		public boolean delete(int meals_id);
}
