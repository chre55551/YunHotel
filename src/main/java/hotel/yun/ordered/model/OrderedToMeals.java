package hotel.yun.ordered.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hotel.yun.date.model.Mdate;
import hotel.yun.meals.model.Meals;

@Entity
@Table(name = "ordered_tomeals")
public class OrderedToMeals implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_tomeals_id;// 餐點訂單編號
	private int meals_accounts;// 餐點總價
	private int mealsnum_of_people;// 用餐人數
	private Date meals_ordered_time;// 餐點訂單時間
	private int table_number;// 桌號
	@Transient
	private int mdate_id;// 對到用餐時間

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mdate_id")
	private Mdate mdate;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "orderedToMeals_meals", joinColumns = {
			@JoinColumn(name = "fk_ordered_tomeals_id", referencedColumnName = "ordered_tomeals_id") }, inverseJoinColumns = {
					@JoinColumn(name = "fk_meals_id", referencedColumnName = "meals_id") })
	private List<Meals> meals = new ArrayList<>();

	public OrderedToMeals() {

	}

	public OrderedToMeals(int mealsnum_of_people, Date meals_ordered_time) {
		super();
		this.mealsnum_of_people = mealsnum_of_people;
		this.meals_ordered_time = meals_ordered_time;
	}

	public OrderedToMeals(int ordered_tomeals_id, int meals_accounts, int mealsnum_of_people, Date meals_ordered_time,
			int table_number) {
		this.ordered_tomeals_id = ordered_tomeals_id;
		this.meals_accounts = meals_accounts;
		this.mealsnum_of_people = mealsnum_of_people;
		this.meals_ordered_time = meals_ordered_time;
		this.table_number = table_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getOrdered_tomeals_id() {
		return ordered_tomeals_id;
	}

	public void setOrdered_tomeals_id(int ordered_tomeals_id) {
		this.ordered_tomeals_id = ordered_tomeals_id;
	}

	public int getMeals_accounts() {
		return meals_accounts;
	}

	public void setMeals_accounts(int meals_accounts) {
		this.meals_accounts = meals_accounts;
	}

	public int getmealsnum_of_people() {
		return mealsnum_of_people;
	}

	public void setmealsnum_of_people(int mealsnum_of_people) {
		this.mealsnum_of_people = mealsnum_of_people;
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

	public int getMdate_id() {
		return mdate_id;
	}

	public void setMdate_id(int mdate_id) {
		this.mdate_id = mdate_id;
	}

	public Mdate getMdate() {
		return mdate;
	}

	public void setMdate(Mdate mdate) {
		this.mdate = mdate;
	}

	public List<Meals> getMeals() {
		return meals;
	}

	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}

}
