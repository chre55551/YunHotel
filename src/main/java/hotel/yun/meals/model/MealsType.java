package hotel.yun.meals.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals_type")
public class MealsType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meals_typeid; // 餐點類別編號
	private String meals_type; // 餐點類型
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meals_type", cascade = CascadeType.ALL)
	private Set<Meals> meals = new HashSet<>();

	public MealsType() {

	}

	public MealsType(int meals_typeid, String meals_type, Set<Meals> meals) {
		this.meals_typeid = meals_typeid;
		this.meals_type = meals_type;
		this.meals = meals;
	}

	public MealsType(String meals_type) {
		this.meals_type = meals_type;
	}

	public int getMeals_typeid() {
		return meals_typeid;
	}

	public void setMeals_typeid(int meals_typeid) {
		this.meals_typeid = meals_typeid;
	}

	public String getMeals_type() {
		return meals_type;
	}

	public void setMeals_type(String meals_type) {
		this.meals_type = meals_type;
	}

	public Set<Meals> getMeals() {
		return meals;
	}

	public void setMeals(Set<Meals> meals) {
		this.meals = meals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
