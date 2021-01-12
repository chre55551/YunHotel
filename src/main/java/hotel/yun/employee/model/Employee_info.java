package hotel.yun.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_info")
public class Employee_info implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer employee_id;//employee_id
	String employee_gender;//employee_gender
	Integer employee_age;//employee_age
	String employee_address;//employee_address
	String employee_mobile;//employee_mobile
	String employee_phone;//employee_phone
	String employee_email;//employee_email
	String emergency_contact;//emergency_contact
	byte[] employee_image;//employee_image
	
	public Employee_info(Integer employee_id,String employee_gender,
			Integer employee_age,String employee_address,String employee_mobile,
			String employee_phone,String employee_email,String emergency_contact,
			byte[] employee_image) {
		this.employee_id = employee_id;
		this.employee_gender = employee_gender;
		this.employee_age = employee_age;
		this.employee_address = employee_address;
		this.employee_mobile = employee_mobile;
		this.employee_phone = employee_phone;
		this.employee_email = employee_email;
		this.emergency_contact = emergency_contact;
		this.employee_image = employee_image;
	}
	public Employee_info() {
		
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_gender() {
		return employee_gender;
	}
	public void setEmployee_gender(String employee_gender) {
		this.employee_gender = employee_gender;
	}
	public Integer getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(Integer employee_age) {
		this.employee_age = employee_age;
	}
	public String getEmployee_address() {
		return employee_address;
	}
	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}
	public String getEmployee_mobile() {
		return employee_mobile;
	}
	public void setEmployee_mobile(String employee_mobile) {
		this.employee_mobile = employee_mobile;
	}
	public String getEmployee_phone() {
		return employee_phone;
	}
	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	public byte[] getEmployee_image() {
		return employee_image;
	}
	public void setEmployee_image(byte[] employee_image) {
		this.employee_image = employee_image;
	}
	
}
