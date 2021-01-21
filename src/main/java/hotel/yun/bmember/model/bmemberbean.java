package hotel.yun.bmember.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmember")
public class bmemberbean implements Serializable{
private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int member_id ;//會員ID
 
 private String account;// 帳號
 private String password;// 密碼
 private String email;//信箱

 public bmemberbean() {

	}
 

public bmemberbean(int member_id, String account, String password, String email) {
	super();
	this.member_id = member_id;
	this.account = account;
	this.password = password;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 
}
