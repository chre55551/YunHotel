package hotel.yun.customer.model;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hotel.yun.ordered.model.Ordered;

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
	@Transient
	@JsonIgnore
	private int member_id;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id", referencedColumnName="member_id")
	@JsonIgnore
	private Member member;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Ordered> ordered = new ArrayList<Ordered>();

	public Customer() {
		
	}
	
	public Customer(int customer_id, String chinese_name, String idcard_number, Date birthday, String address,
			String mobile_phone, Member member, List<Ordered> ordered) {
		super();
		this.customer_id = customer_id;
		this.chinese_name = chinese_name;
		this.idcard_number = idcard_number;
		this.birthday = birthday;
		this.address = address;
		this.mobile_phone = mobile_phone;
		this.member = member;
		this.ordered = ordered;
	}
	//我訂單加的建構式，勿刪
	public Customer(String chinese_name, String mobile_phone) {
		this.chinese_name = chinese_name;
		this.mobile_phone = mobile_phone;
	}

	//我訂單加的建構式，勿刪
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Ordered> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Ordered> ordered) {
		this.ordered = ordered;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	
}
