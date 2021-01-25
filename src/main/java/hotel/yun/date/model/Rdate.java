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
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "rdate", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderedToRoom> orderedToRoom = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "room_rdate", joinColumns = {
			@JoinColumn(name = "fk_rdate_id", referencedColumnName = "rdate_id") }, inverseJoinColumns = {
					@JoinColumn(name = "fk_room_id", referencedColumnName = "room_id") })
	private Set<Room> rooms = new HashSet<Room>();

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

	public List<OrderedToRoom> getOrderedToRoom() {
		return orderedToRoom;
	}

	public void setOrderedToRoom(List<OrderedToRoom> orderedToRoom) {
		this.orderedToRoom = orderedToRoom;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
