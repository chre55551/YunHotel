package hotel.yun.employee.model;

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
@Table(name = "employee_status")
public class Employee_status implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_status_id;
	private String employee_status;
	
	@OneToMany(mappedBy = "employee_status",cascade = CascadeType.ALL)
	private Set<Employee_basic> employee_basic = new HashSet<Employee_basic>();

	public Employee_status() {
		
	}
	
	public Employee_status(int employee_status_id, String employee_status, Set<Employee_basic> employee_basic) {
		super();
		this.employee_status_id = employee_status_id;
		this.employee_status = employee_status;
		this.employee_basic = employee_basic;
	}

	public int getEmployee_status_id() {
		return employee_status_id;
	}

	public void setEmployee_status_id(int employee_status_id) {
		this.employee_status_id = employee_status_id;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public Set<Employee_basic> getEmployee_basic() {
		return employee_basic;
	}

	public void setEmployee_basic(Set<Employee_basic> employee_basic) {
		this.employee_basic = employee_basic;
	}
	
	
}
