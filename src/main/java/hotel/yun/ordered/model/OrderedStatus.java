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
@Table(name = "ordered_status")
public class OrderedStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int status_id;// 狀態ID

	private String ordered_status;// 訂單狀態

	@OneToMany(mappedBy = "orderedStatus", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Ordered> ordered = new HashSet<>();

	public OrderedStatus() {

	}

	public OrderedStatus(int status_id, String ordered_status, Set<Ordered> ordered) {
		super();
		this.status_id = status_id;
		this.ordered_status = ordered_status;
		this.ordered = ordered;
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

}
