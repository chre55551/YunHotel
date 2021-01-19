package hotel.yun.customer.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="member_id", referencedColumnName="member_id")
	private Member member;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Ordered> ordered = new HashSet<Ordered>();
	
	public Customer(int customer_id, String chinese_name, String idcard_number, Date birthday, String address,
			String mobile_phone, Member member, Set<Ordered> ordered) {
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
	
	
	
	public Customer(String chinese_name, String mobile_phone) {
		this.chinese_name = chinese_name;
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

	public Set<Ordered> getOrdered() {
		return ordered;
	}

	public void setOrdered(Set<Ordered> ordered) {
		this.ordered = ordered;
	}
	
}
