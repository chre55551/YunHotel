package hotel.yun.employee.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "book_M2M_01_ANNO")
public class Schedule {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer schedule_id;//班表編號
	private String schedule_manager;//排班經理
	private String schedule_supervisor;//主管
	private Date schedule_date;//日期
	private String schedule_time;//班別
	private Integer schedule_totalTime;//總工作時數
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_schedule",  
		joinColumns = {   // 在Join Table中，儲存本類別之主鍵值的外鍵欄位名稱
			@JoinColumn(name = "FK_schedule_id", referencedColumnName = "schedule_id") 
		}, 
		inverseJoinColumns = { // 在Join Table中，儲存對應對照類別之主鍵值的外鍵欄位名稱
			@JoinColumn(name = "FK_employee_id",	referencedColumnName = "employee_id") 
		}
	)
	private Set<Employee_basic> employee = new HashSet<Employee_basic>(0);

	public Schedule() {
	}

	public Schedule(String schedule_manager,String schedule_supervisor,
			Date schedule_date,String schedule_time,Integer schedule_totalTime) {
		this.schedule_manager = schedule_manager;
		this.schedule_supervisor = schedule_supervisor;
		this.schedule_date = schedule_date;
		this.schedule_time = schedule_time;
		this.schedule_totalTime = schedule_totalTime;
		
	}

	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getSchedule_manager() {
		return schedule_manager;
	}

	public void setSchedule_manager(String schedule_manager) {
		this.schedule_manager = schedule_manager;
	}

	public String getSchedule_supervisor() {
		return schedule_supervisor;
	}

	public void setSchedule_supervisor(String schedule_supervisor) {
		this.schedule_supervisor = schedule_supervisor;
	}

	public Date getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}

	public String getSchedule_time() {
		return schedule_time;
	}

	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}

	public Integer getSchedule_totalTime() {
		return schedule_totalTime;
	}

	public void setSchedule_totalTime(Integer schedule_totalTime) {
		this.schedule_totalTime = schedule_totalTime;
	}

	public Set<Employee_basic> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee_basic> employee) {
		this.employee = employee;
	}

	

}
