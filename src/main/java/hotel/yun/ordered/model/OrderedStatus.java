package hotel.yun.ordered.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_status")
public class OrderedStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int status_id;//狀態ID
	private String ordered_status;//訂單狀態
	private String bill_status;//付款方式
	private String payment_status;//付款狀態
	private int ordered_number;//訂單編號
	
	public OrderedStatus() {
		
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ordered_id")
	private Ordered ordered;
	
	public OrderedStatus(int status_id, String ordered_status, String bill_status, String payment_status,
			int ordered_number) {
		this.status_id = status_id;
		this.ordered_status = ordered_status;
		this.bill_status = bill_status;
		this.payment_status = payment_status;
		this.ordered_number = ordered_number;
	}
	
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getOrdered_status() {
		return ordered_status;
	}
	public void setOrdered_status(String ordered_status) {
		this.ordered_status = ordered_status;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public int getOrdered_number() {
		return ordered_number;
	}
	public void setOrdered_number(int ordered_number) {
		this.ordered_number = ordered_number;
	}
	
}
