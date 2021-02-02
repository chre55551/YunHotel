package hotel.yun.employee.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import hotel.yun.customer.model.Customer;




@Entity
@Table(name="employee_basic")
public class Employee_basic implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int employee_id;//員工編號
	String employee_name;//姓名
	String employee_department;//部門
	String employee_position;//職位
	
	@Transient
	private int employee_status_id;// 顧客編號	
	@Transient
	private int employee_info_id;
	@Transient
	private int employee_work_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "employee_status_id")
	private Employee_status employee_status;// 員工職位狀態編號
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="employee_info_id", referencedColumnName="employee_info_id")
    private Employee_info employee_info;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="employee_work_id", referencedColumnName="employee_work_id")
    private Employee_work employee_work;
	
	@ManyToMany(mappedBy = "employee")
	private Set<Schedule> scedule = new HashSet<Schedule>(0);
	
	public Employee_basic(int employee_id,String employee_name,
			String employee_department,String employee_position
			,int employee_info_id,int employee_work_id,int employee_status_id){
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_department = employee_department;
		this.employee_position = employee_position;
		this.employee_info_id = employee_info_id;
		this.employee_work_id = employee_work_id;
		this.employee_status_id = employee_status_id;
	}
	
	public Employee_basic() {
		
	}
	
	
	
	public Employee_basic(Blob ri) {
		// TODO Auto-generated constructor stub
	}

	public Employee_info getEmployee_info() {
		return employee_info;
	}

	public void setEmployee_info(Employee_info employee_info) {
		this.employee_info = employee_info;
	}

	public Employee_work getEmployee_work() {
		return employee_work;
	}

	public void setEmployee_work(Employee_work employee_work) {
		this.employee_work = employee_work;
	}

	public int getEmployee_id() {
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

	public int getEmployee_status_id() {
		return employee_status_id;
	}

	public void setEmployee_status_id(int employee_status_id) {
		this.employee_status_id = employee_status_id;
	}

	public Employee_status getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(Employee_status employee_status) {
		this.employee_status = employee_status;
	}
	
	
}
