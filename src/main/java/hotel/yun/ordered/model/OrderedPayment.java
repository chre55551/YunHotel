package hotel.yun.ordered.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_payment")
public class OrderedPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;// 付款ID

	private String bill_status;// 付款方式

	@OneToMany(mappedBy = "orderedPayment", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Ordered> ordered = new HashSet<Ordered>();

	public OrderedPayment() {

	}

	public OrderedPayment(int payment_id, String bill_status, Set<Ordered> ordered) {
		this.payment_id = payment_id;
		this.bill_status = bill_status;
		this.ordered = ordered;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

}
