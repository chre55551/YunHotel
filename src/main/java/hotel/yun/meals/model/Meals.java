package hotel.yun.meals.model;



import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meals implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meals_id;       //餐點編號
	private String meals_name;  //餐點名稱
	private double meals_price; //餐點價格
	private String meals_stock; //庫存
	private Blob meals_image;   //餐點圖片
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "meals_typeid")
	private MealsType mealsType;   
	
	
	public Meals() {
		
	}
	
	
	
	public Meals(int meals_id,String meals_name,double meals_price,String meals_stock,Blob meals_image,MealsType mealsType) {
		this.meals_id = meals_id;
		this.meals_name = meals_name;
		this.meals_price = meals_price;
		this.meals_stock = meals_stock;
		this.meals_image = meals_image;
		this.mealsType = mealsType;
	}
	
	


	public int getMeals_id() {
		return meals_id;
	}



	public void setMeals_id(int meals_id) {
		this.meals_id = meals_id;
	}



	public String getMeals_name() {
		return meals_name;
	}



	public void setMeals_name(String meals_name) {
		this.meals_name = meals_name;
	}



	public double getMeals_price() {
		return meals_price;
	}



	public void setMeals_price(double meals_price) {
		this.meals_price = meals_price;
	}



	public String getMeals_stock() {
		return meals_stock;
	}



	public void setMeals_stock(String meals_stock) {
		this.meals_stock = meals_stock;
	}



	public Blob getMeals_image() {
		return meals_image;
	}



	public void setMeals_image(Blob meals_image) {
		this.meals_image = meals_image;
	}



	public MealsType getMealsType() {
		return mealsType;
	}



	public void setMealsType(MealsType mealsType) {
		this.mealsType = mealsType;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}





//	public int getMeals_typeid() {
//		return meals_typeid;
//	}
//
//
//
//
//	public void setMeals_typeid(int meals_typeid) {
//		this.meals_typeid = meals_typeid;
//	}




	

