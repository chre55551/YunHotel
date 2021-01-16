package hotel.yun.ordered.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_tomeals")
public class OrderedToMeals implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_tomeals_id;//餐點訂單編號
	
	private int meals_id;//餐點編號
	private int meals_accounts;//餐點總價
	private int number_of_meals;//用餐人數
	private Date meals_ordered_time;//餐點訂單時間
	private int table_number;//桌號
	
	public OrderedToMeals() {
		
	}
	
	public OrderedToMeals(int ordered_tomeals_id, int meals_id, int meals_accounts, int number_of_meals,
			Date meals_ordered_time, int table_number) {
		this.ordered_tomeals_id = ordered_tomeals_id;
		this.meals_id = meals_id;
		this.meals_accounts = meals_accounts;
		this.number_of_meals = number_of_meals;
		this.meals_ordered_time = meals_ordered_time;
		this.table_number = table_number;
	}

	public int getOrdered_tomeals_id() {
		return ordered_tomeals_id;
	}

	public void setOrdered_tomeals_id(int ordered_tomeals_id) {
		this.ordered_tomeals_id = ordered_tomeals_id;
	}

	public int getMeals_id() {
		return meals_id;
	}

	public void setMeals_id(int meals_id) {
		this.meals_id = meals_id;
	}

	public int getMeals_accounts() {
		return meals_accounts;
	}

	public void setMeals_accounts(int meals_accounts) {
		this.meals_accounts = meals_accounts;
	}

	public int getNumber_of_meals() {
		return number_of_meals;
	}

	public void setNumber_of_meals(int number_of_meals) {
		this.number_of_meals = number_of_meals;
	}

	public Date getMeals_ordered_time() {
		return meals_ordered_time;
	}

	public void setMeals_ordered_time(Date meals_ordered_time) {
		this.meals_ordered_time = meals_ordered_time;
	}

	public int getTable_number() {
		return table_number;
	}

	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}
	
}
