package hotel.yun.employee.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shifts")
public class Shifts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shifts_id;
	private Date shifts_date;
	private String shifts_start; 
	private String shifts_end;
	
	public Shifts() {
	}
	public Shifts(Date shifts_date, String shifts_start, String shifts_end) {
		super();
		this.shifts_date = shifts_date;
		this.shifts_start = shifts_start;
		this.shifts_end = shifts_end;
	}
	public int getShifts_id() {
		return shifts_id;
	}
	public void setShifts_id(int shifts_id) {
		this.shifts_id = shifts_id;
	}
	public Date getShifts_date() {
		return shifts_date;
	}
	public void setShifts_date(Date shifts_date) {
		this.shifts_date = shifts_date;
	}
	public String getShifts_start() {
		return shifts_start;
	}
	public void setShifts_start(String shifts_start) {
		this.shifts_start = shifts_start;
	}
	public String getShifts_end() {
		return shifts_end;
	}
	public void setShifts_end(String shifts_end) {
		this.shifts_end = shifts_end;
	} 
	
	
}
