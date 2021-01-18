package hotel.yun.date.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import hotel.yun.room.model.Room;

@Entity
@Table(name = "rdate")
public class RDate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer date_id;
	private Date rdate;
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_date",
    joinColumns = {
            @JoinColumn(name = "fk_date_id", referencedColumnName = "date_id") },
    inverseJoinColumns = {
            @JoinColumn(name = "fk_room_id", referencedColumnName = "room_id") })
    private Set<Room> rooms = new HashSet<Room>();
	
    
	public RDate() {
		
	}
	
	public RDate(Date room_date) {
		this.rdate = room_date;
	}
	public int getDate_id() {
		return date_id;
	}
	public void setDate_id(int date_id) {
		this.date_id = date_id;
	}
	public Date getRoom_date() {
		return rdate;
	}
	public void setRoom_date(Date room_date) {
		this.rdate = room_date;
	}
	
	
}
