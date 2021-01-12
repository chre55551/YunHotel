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
import javax.persistence.Table;

@Entity
@Table(name = "ordered")
public class Ordered implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_number;// 訂單編號
	
	private int customer_id;// 會員編號，必須建其他資料表才吃的到
	private int status_id;// 狀態ID，必須建其他資料表才吃的到
	private int payment_id;// 付款ID，必須建其他資料表才吃的到
	private int ordered_accounts;// 訂單總價
	private Date ordered_date;// 訂單日期
	private int iv_no;//發票號碼
	private String note;//註記
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name= "customer_id")
	//private Customer customer;// 會員編號
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "status_id")
	private OrderedStatus orderedStatus;// 狀態ID
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "payment_id")
	private OrderedPayment orderedPayment;// 付款ID
	
	public Ordered() {

	}

	public int getOrdered_number() {
		return ordered_number;
	}

	public void setOrdered_number(int ordered_number) {
		this.ordered_number = ordered_number;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
