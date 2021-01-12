package hotel.yun.employee.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="employee_basic")
public class Employee_basic implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer employee_id;//員工編號
	String employee_name;//姓名
	String employee_department;//部門
	String employee_position;//職位
	
	@ManyToMany(mappedBy = "employee")
	private Set<Schedule> scedule = new HashSet<Schedule>(0);
	
	public Employee_basic(Integer employee_id,String employee_name,
			String employee_department,String employee_position){
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_department = employee_department;
		this.employee_position = employee_position;
	}
	
	public Employee_basic() {
		
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_department() {
		return employee_department;
	}

	public void setEmployee_department(String employee_department) {
		this.employee_department = employee_department;
	}

	public String getEmployee_position() {
		return employee_position;
	}

	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}
	
	
}
