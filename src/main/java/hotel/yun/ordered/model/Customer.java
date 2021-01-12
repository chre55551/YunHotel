package hotel.yun.ordered.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String chinese_name;
	private String idcard_number;
	private Date birthday;
	private String address;
	private String mobile_phone;
	private int member_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Customer customer;
	
	
	public Customer(String chinese_name, String idcard_number, Date birthday, String address, String mobile_phone) {
		this.chinese_name = chinese_name;
		this.idcard_number = idcard_number;
		this.birthday = birthday;
		this.address = address;
		this.mobile_phone = mobile_phone;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getChinese_name() {
		return chinese_name;
	}
	public void setChinese_name(String chinese_name) {
		this.chinese_name = chinese_name;
	}
	public String getIdcard_number() {
		return idcard_number;
	}
	public void setIdcard_number(String idcard_number) {
		this.idcard_number = idcard_number;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
