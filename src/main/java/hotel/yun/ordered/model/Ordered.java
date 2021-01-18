package hotel.yun.ordered.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import hotel.yun.customer.model.Customer;

@Entity
@Table(name = "ordered")
public class Ordered implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_number;// 訂單編號
	
	@Transient
	private int customer_id;// 顧客編號
	@Transient
	private int ordered_tomeals_id;//餐點訂單編號
	@Transient
	private int ordered_toroom_id;//房間訂單編號
	@Transient
	private int status_id;// 狀態ID
	@Transient
	private int payment_id;// 付款ID
	
	private int ordered_accounts;// 訂單總價
	private Date ordered_date;// 訂單日期
	private int iv_no;//發票號碼
	private String note;//註記
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "customer_id")
	private Customer customer;// 顧客編號
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "status_id")
	private OrderedStatus orderedStatus;// 狀態ID
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "payment_id")
	private OrderedPayment orderedPayment;// 付款ID
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ordered_tomeals_id", referencedColumnName="ordered_tomeals_id")
	private OrderedToMeals orderedToMeals;//餐點訂單編號
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ordered_toroom_id", referencedColumnName="ordered_toroom_id")
	private OrderedToRoom orderedToRoom;//房間訂單編號
	
	public Ordered() {

	}
	
	public Ordered(int ordered_number, int ordered_accounts, Date ordered_date, int iv_no, String note,
			OrderedStatus orderedStatus, OrderedPayment orderedPayment, OrderedToMeals orderedToMeals,
			OrderedToRoom orderedToRoom) {
		this.ordered_number = ordered_number;
		this.ordered_accounts = ordered_accounts;
		this.ordered_date = ordered_date;
		this.iv_no = iv_no;
		this.note = note;
		this.orderedStatus = orderedStatus;
		this.orderedPayment = orderedPayment;
		this.orderedToMeals = orderedToMeals;
		this.orderedToRoom = orderedToRoom;
	}

	public int getOrdered_number() {
		return ordered_number;
	}

	public void setOrdered_number(int ordered_number) {
		this.ordered_number = ordered_number;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderedStatus getOrderedStatus() {
		return orderedStatus;
	}

	public void setOrderedStatus(OrderedStatus orderedStatus) {
		this.orderedStatus = orderedStatus;
	}

	public OrderedPayment getOrderedPayment() {
		return orderedPayment;
	}

	public void setOrderedPayment(OrderedPayment orderedPayment) {
		this.orderedPayment = orderedPayment;
	}

	public OrderedToMeals getOrderedToMeals() {
		return orderedToMeals;
	}

	public void setOrderedToMeals(OrderedToMeals orderedToMeals) {
		this.orderedToMeals = orderedToMeals;
	}

	public OrderedToRoom getOrderedToRoom() {
		return orderedToRoom;
	}

	public void setOrderedToRoom(OrderedToRoom orderedToRoom) {
		this.orderedToRoom = orderedToRoom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getOrdered_tomeals_id() {
		return ordered_tomeals_id;
	}

	public void setOrdered_tomeals_id(int ordered_tomeals_id) {
		this.ordered_tomeals_id = ordered_tomeals_id;
	}

	public int getOrdered_toroom_id() {
		return ordered_toroom_id;
	}

	public void setOrdered_toroom_id(int ordered_toroom_id) {
		this.ordered_toroom_id = ordered_toroom_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


}
