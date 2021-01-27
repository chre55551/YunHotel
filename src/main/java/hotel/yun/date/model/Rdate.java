package hotel.yun.date.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import hotel.yun.ordered.model.OrderedToRoom;
import hotel.yun.room.model.Room;

@Entity
@Table(name = "rdate")
public class Rdate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rdate_id;
	private Date rdate;

    @ManyToMany(mappedBy = "rdates_to_rooms", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Room> rooms = new HashSet<Room>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "rdates")
	private Set<OrderedToRoom> orderedToRooms = new HashSet<OrderedToRoom>();
	                            
	public Rdate() {

	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getDate_id() {
		return rdate_id;
	}

	public void setDate_id(int date_id) {
		this.rdate_id = date_id;
	}

	public Integer getRdate_id() {
		return rdate_id;
	}

	public void setRdate_id(Integer rdate_id) {
		this.rdate_id = rdate_id;
	}


	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}

