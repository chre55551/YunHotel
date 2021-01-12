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
	private int ordered_tomeals_id;//餐點訂單編號
	private int ordered_toroom_id;//房間訂單編號
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



}
