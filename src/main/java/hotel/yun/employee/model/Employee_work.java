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
	Integer employee_work_id;//employee_id
	Integer employee_workyears;//employee_workyears
	Integer employee_salary;//employee_salary
	Integer working_hours;//working_hours
	Integer holiday_hours;//holiday_hours

	public Employee_work() {
		
	}

	public Integer getEmployee_id() {
		return employee_work_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_work_id = employee_id;
	}

	public Integer getEmployee_workyears() {
		return employee_workyears;
	}

	public void setEmployee_workyears(Integer employee_workyears) {
		this.employee_workyears = employee_workyears;
	}

	public Integer getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(Integer employee_salary) {
		this.employee_salary = employee_salary;
	}

	public Integer getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(Integer working_hours) {
		this.working_hours = working_hours;
	}

	public Integer getHoliday_hours() {
		return holiday_hours;
	}

	public void setHoliday_hours(Integer holiday_hours) {
		this.holiday_hours = holiday_hours;
	}
	
}
