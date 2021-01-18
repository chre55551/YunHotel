package hotel.yun.date.model;

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
@Table(name = "date")
public class Date {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer date_id;
	private Date room_date;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "room_date", joinColumns = {
            @JoinColumn(name = "fk_date_id", referencedColumnName = "date_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "fk_room_id", referencedColumnName = "room_id") })
    private Set<Room> room = new HashSet<Room>();
	
	public Date() {
		
	}
	
	public Date(Date room_date) {
		this.room_date = room_date;
	}
	public int getDate_id() {
		return date_id;
	}
	public void setDate_id(int date_id) {
		this.date_id = date_id;
	}
	public Date getRoom_date() {
		return room_date;
	}
	public void setRoom_date(Date room_date) {
		this.room_date = room_date;
	}
	
	
}
