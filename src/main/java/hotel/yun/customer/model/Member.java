package hotel.yun.customer.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "member")
public class Member {
	@Id @Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_id;
	private String account;
	private String password;
	private String gender;
	private String home_phone;
	private String job;
	private String email;
	private Timestamp register_date;
	private Date updated_date;
	
	@JsonIgnore
	@OneToOne(mappedBy = "member")
	private Customer Customer;
	
	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public Member(){
		
	}

	public Member(int member_id, String account, String password, String gender, String home_phone, String job,
			String email, Timestamp register_date, Date updated_date) {
		super();
		this.member_id = member_id;
		this.account = account;
		this.password = password;
		this.gender = gender;
		this.home_phone = home_phone;
		this.job = job;
		this.email = email;
		this.register_date = register_date;
		this.updated_date = updated_date;
	}
	
	
	public Member(int member_id, String account, String password, String gender, String home_phone, String job,
			String email) {
		super();
		this.member_id = member_id;
		this.account = account;
		this.password = password;
		this.gender = gender;
		this.home_phone = home_phone;
		this.job = job;
		this.email = email;
	}

	
	
	public Member(String account, String password, String gender, String home_phone, String job, String email) {
		super();
		this.account = account;
		this.password = password;
		this.gender = gender;
		this.home_phone = home_phone;
		this.job = job;
		this.email = email;
	}

	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getregister_Time() {
		return register_date;
	}
	public void setregister_Time(Timestamp register_date) {
		this.register_date = register_date;
	}
	
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
}

	
	
		