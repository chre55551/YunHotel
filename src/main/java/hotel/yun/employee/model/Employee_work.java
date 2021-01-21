package hotel.yun.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_work")
public class Employee_work implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int employee_work_id;//employee_id
	int employee_workyears;//employee_workyears
	int employee_salary;//employee_salary
	int working_hours;//working_hours
	int holiday_hours;//holiday_hours

	public Employee_work() {
		
	}
	
	public Employee_work(int employee_work_id,int employee_workyears,
			int employee_salary,int working_hours,int holiday_hours) {
		super();
		this.employee_work_id=employee_work_id;
		this.employee_workyears=employee_workyears;
		this.working_hours=working_hours;
		this.holiday_hours=holiday_hours;	
	}

	public int getEmployee_work_id() {
		return employee_work_id;
	}

	public void setEmployee_work_id(int employee_work_id) {
		this.employee_work_id = employee_work_id;
	}

	public int getEmployee_workyears() {
		return employee_workyears;
	}

	public void setEmployee_workyears(int employee_workyears) {
		this.employee_workyears = employee_workyears;
	}

	public int getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}

	public int getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(int working_hours) {
		this.working_hours = working_hours;
	}

	public int getHoliday_hours() {
		return holiday_hours;
	}

	public void setHoliday_hours(int holiday_hours) {
		this.holiday_hours = holiday_hours;
	}
	
	

	
}
