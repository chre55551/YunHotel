package hotel.yun.meals2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="meals2")
@Table(name = "meals2")
public class Meals2 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int meals2_id ;
	 private String meals2_type;
	 private String meals2_name;
	 private double meals2_price;
	 private int    meals2_stock;
	 
	 
	 
	 public Meals2() {

	}
	 
	 public Meals2(int meals2_id,String meals2_type,String meals2_name,double meals2_price,int meals2_stock) {

	} 
	 
	 
	 
	 
	 
	public int getMeals2_id() {
		return meals2_id;
	}
	public void setMeals2_id(int meals2_id) {
		this.meals2_id = meals2_id;
	}
	public String getMeals2_type() {
		return meals2_type;
	}
	public void setMeals2_type(String meals2_type) {
		this.meals2_type = meals2_type;
	}
	public String getMeals2_name() {
		return meals2_name;
	}
	public void setMeals2_name(String meals2_name) {
		this.meals2_name = meals2_name;
	}
	public double getMeals2_price() {
		return meals2_price;
	}
	public void setMeals2_price(double meals2_price) {
		this.meals2_price = meals2_price;
	}
	public int getMeals2_stock() {
		return meals2_stock;
	}
	public void setMeals2_stock(int meals2_stock) {
		this.meals2_stock = meals2_stock;
	}
	
	
	
	
	
	
	
	
	
	
	
}
