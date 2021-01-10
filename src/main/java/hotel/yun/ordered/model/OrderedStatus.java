package hotel.yun.ordered.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ordered_status")
public class OrderedStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int status_id;//狀態ID
	
	private String ordered_status;//訂單狀態
	
	@OneToMany
	@JoinColumn(name="status_id")
	private Set<Ordered> ordered = new HashSet<>();
	
	public OrderedStatus() {
		
	}
	
	public OrderedStatus(int status_id, String ordered_status) {
		this.status_id = status_id;
		this.ordered_status = ordered_status;
	}

	public OrderedStatus(int status_id, String ordered_status, Set<Ordered> ordered) {
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
