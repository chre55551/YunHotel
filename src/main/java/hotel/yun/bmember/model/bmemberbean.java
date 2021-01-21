package hotel.yun.bmember.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backstage")
public class bmemberbean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bs_id;// 會員ID

	private String bs_account;// 帳號
	private String bs_password;// 密碼
	private String bs_email;// 信箱
	private String authority;// 權限
	private String user_id;// 使用者名稱

	public bmemberbean() {

	}

	
	public bmemberbean(int bs_id, String bs_account, String bs_password, String bs_email, String authority,
			String user_id) {
		super();
		this.bs_id = bs_id;
		this.bs_account = bs_account;
		this.bs_password = bs_password;
		this.bs_email = bs_email;
		this.authority = authority;
		this.user_id = user_id;
	}


	public int getBs_id() {
		return bs_id;
	}

	public void setBs_id(int bs_id) {
		this.bs_id = bs_id;
	}

	public String getBs_account() {
		return bs_account;
	}

	public void setBs_account(String bs_account) {
		this.bs_account = bs_account;
	}

	public String getBs_password() {
		return bs_password;
	}

	public void setBs_password(String bs_password) {
		this.bs_password = bs_password;
	}

	public String getBs_email() {
		return bs_email;
	}

	public void setBs_email(String bs_email) {
		this.bs_email = bs_email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
