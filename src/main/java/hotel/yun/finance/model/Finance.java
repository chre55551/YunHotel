package hotel.yun.finance.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hotel.yun.ordered.model.Ordered;

@Entity
	@Table(name = "finance")
	public class Finance implements Serializable{
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int finance_id ;
	 
	 private float restaurant_revenue;
	 private float room_revenue; 
	 private float turnover; 
	 private float salary_cost;
	 private float meals_cost;
	 private float room_cost;
	 private float total_cost;
	 private float net_income;
	 private String month;
	 
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="ordered_number", referencedColumnName="ordered_number")
	 private Ordered ordered;
	
	 public Finance() {
		}

	 public Finance(float restaurant_revenue,float room_revenue,float turnover,float salary_cost,float meals_cost,float room_cost,float total_cost, float net_income,Ordered ordered,String month) {
			super();
			this.restaurant_revenue=restaurant_revenue;
			this.room_revenue=room_revenue;
			this.turnover=turnover;
			this.salary_cost=salary_cost;
			this.meals_cost=meals_cost;
			this.room_cost=room_cost;
			this.total_cost=total_cost;
			this.net_income=net_income;
			this.ordered=ordered;
			this.month=month;
		}

	public int getFinance_id() {
		return finance_id;
	}

	public void setFinance_id(int finance_id) {
		this.finance_id = finance_id;
	}

	public float getRestaurant_revenue() {
		return restaurant_revenue;
	}

	public void setRestaurant_revenue(float restaurant_revenue) {
		this.restaurant_revenue = restaurant_revenue;
	}

	public float getRoom_revenue() {
		return room_revenue;
	}

	public void setRoom_revenue(float room_revenue) {
		this.room_revenue = room_revenue;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public float getSalary_cost() {
		return salary_cost;
	}

	public void setSalary_cost(float salary_cost) {
		this.salary_cost = salary_cost;
	}

	public float getMeals_cost() {
		return meals_cost;
	}

	public void setMeals_cost(float meals_cost) {
		this.meals_cost = meals_cost;
	}

	public float getRoom_cost() {
		return room_cost;
	}

	public void setRoom_cost(float room_cost) {
		this.room_cost = room_cost;
	}

	public float getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}

	public float getNet_income() {
		return net_income;
	}

	public void setNet_income(float net_income) {
		this.net_income = net_income;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Ordered getOrdered() {
		return ordered;
	}

	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}
	 
}