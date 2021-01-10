package hotel.yun.ordered.model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hotel.yun.ordered.model.OrderedStatus;

@Entity
@Table(name = "ordered")
public class Ordered {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int ordered_number;//訂單編號
	private int member_id;//會員編號
	private int room_accounts;//房間總價
	private int meals_accounts;//餐點總價
	private int ordered_accounts;//訂單總價
	private Date ordered_date;//訂單日期
	private int iv_no;//
	private String note;
	
	public Ordered() {
		
	}
	
	@OneToMany(mappedBy="ordered")
	private Set<OrderedStatus> orderedStatus = new LinkedHashSet<>();
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="member_id")
//	private Member_Bean member_Bean;
	
	public Ordered(int ordered_number, int member_id, int room_accounts, int meals_accounts, int ordered_accounts,
			Date ordered_date, int iv_no, String note) {
		this.ordered_number = ordered_number;
		this.member_id = member_id;
		this.room_accounts = room_accounts;
		this.meals_accounts = meals_accounts;
		this.ordered_accounts = ordered_accounts;
		this.ordered_date = ordered_date;
		this.iv_no = iv_no;
		this.note = note;
	}
	
	public int getOrdered_number() {
		return ordered_number;
	}
	public void setOrdered_number(int ordered_number) {
		this.ordered_number = ordered_number;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getRoom_accounts() {
		return room_accounts;
	}
	public void setRoom_accounts(int room_accounts) {
		this.room_accounts = room_accounts;
	}
	public int getMeals_accounts() {
		return meals_accounts;
	}
	public void setMeals_accounts(int meals_accounts) {
		this.meals_accounts = meals_accounts;
	}
	public int getOrdered_accounts() {
		return ordered_accounts;
	}
	public void setOrdered_accounts(int ordered_accounts) {
		this.ordered_accounts = ordered_accounts;
	}
	public Date getOrdered_date() {
		return ordered_date;
	}
	public void setOrdered_date(Date ordered_date) {
		this.ordered_date = ordered_date;
	}
	public int getIv_no() {
		return iv_no;
	}
	public void setIv_no(int iv_no) {
		this.iv_no = iv_no;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
