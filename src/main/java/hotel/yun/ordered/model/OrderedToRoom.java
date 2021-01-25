package hotel.yun.ordered.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import hotel.yun.date.model.Rdate;
import hotel.yun.room.model.Room;

@Entity
@Table(name = "ordered_toroom")
public class OrderedToRoom implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_toroom_id;
	
	private int room_accounts;
	private int roomnum_of_people;
	private Date room_ordered_time;
	private int room_number;
	@Transient
	private int room_id;
	@Transient
	private int rdate_id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id")
	private Room room;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "rdate_id")
	private Rdate rdate;
	
	public OrderedToRoom() {
		
	}
	
	public OrderedToRoom(int ordered_toroom_id, int room_id, int room_accounts, int roomnum_of_people,
			Date room_ordered_time, int room_number) {
		this.ordered_toroom_id = ordered_toroom_id;
		this.room_id = room_id;
		this.room_accounts = room_accounts;
		this.roomnum_of_people = roomnum_of_people;
		this.room_ordered_time = room_ordered_time;
		this.room_number = room_number;
	}

	public OrderedToRoom(Date room_ordered_time, int room_number) {
		this.room_ordered_time = room_ordered_time;
		this.room_number = room_number;
	}

	public int getOrdered_toroom_id() {
		return ordered_toroom_id;
	}

	public void setOrdered_toroom_id(int ordered_toroom_id) {
		this.ordered_toroom_id = ordered_toroom_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getRoom_accounts() {
		return room_accounts;
	}

	public void setRoom_accounts(int room_accounts) {
		this.room_accounts = room_accounts;
	}

	public int getroomnum_of_people() {
		return roomnum_of_people;
	}

	public void setroomnum_of_people(int roomnum_of_people) {
		this.roomnum_of_people = roomnum_of_people;
	}

	public Date getRoom_ordered_time() {
		return room_ordered_time;
	}

	public void setRoom_ordered_time(Date room_ordered_time) {
		this.room_ordered_time = room_ordered_time;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Rdate getRdate() {
		return rdate;
	}

	public void setRdate(Rdate rdate) {
		this.rdate = rdate;
	}
	
	
}
