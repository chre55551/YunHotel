package hotel.yun.date.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hotel.yun.ordered.model.OrderedToMeals;

@Entity
@Table(name = "mdate")
public class Mdate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mdate_id;
	private Date mdate;
	private String time_period;
	private Integer table_two_order = 0;
	private Integer table_four_order = 0;
	private Integer table_six_order = 0;
	private Integer table_two_total = 10;
	private Integer table_four_total = 20;
	private Integer table_six_total = 5;
	
	@OneToMany(mappedBy = "mdate", cascade = CascadeType.ALL)
	private List<OrderedToMeals> orderedToMeals = new ArrayList<>();
	
	public Mdate() {
		
	}
	
	public Mdate(Integer mdate_id, Date mdate, String time_period, Integer table_two_order, Integer table_four_order,
			Integer table_six_order, Integer table_two_total, Integer table_four_total, Integer table_six_total) {
		super();
		this.mdate_id = mdate_id;
		this.mdate = mdate;
		this.time_period = time_period;
		this.table_two_order = table_two_order;
		this.table_four_order = table_four_order;
		this.table_six_order = table_six_order;
		this.table_two_total = table_two_total;
		this.table_four_total = table_four_total;
		this.table_six_total = table_six_total;
	}
	
	public Integer getMdate_id() {
		return mdate_id;
	}
	public void setMdate_id(Integer mdate_id) {
		this.mdate_id = mdate_id;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getTime_period() {
		return time_period;
	}
	public void setTime_period(String time_period) {
		this.time_period = time_period;
	}
	public Integer getTable_two_order() {
		return table_two_order;
	}
	public void setTable_two_order(Integer table_two_order) {
		this.table_two_order = table_two_order;
	}
	public Integer getTable_four_order() {
		return table_four_order;
	}
	public void setTable_four_order(Integer table_four_order) {
		this.table_four_order = table_four_order;
	}
	public Integer getTable_six_order() {
		return table_six_order;
	}
	public void setTable_six_order(Integer table_six_order) {
		this.table_six_order = table_six_order;
	}
	public Integer getTable_two_total() {
		return table_two_total;
	}
	public void setTable_two_total(Integer table_two_total) {
		this.table_two_total = table_two_total;
	}
	public Integer getTable_four_total() {
		return table_four_total;
	}
	public void setTable_four_total(Integer table_four_total) {
		this.table_four_total = table_four_total;
	}
	public Integer getTable_six_total() {
		return table_six_total;
	}
	public void setTable_six_total(Integer table_six_total) {
		this.table_six_total = table_six_total;
	}
	
}
