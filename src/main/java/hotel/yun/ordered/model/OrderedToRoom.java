package hotel.yun.ordered.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_toroom")
public class OrderedToRoom implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordered_toroom_id;
	
	private int room_id;
	private int room_accounts;
	private int number_of_room;
	private Date room_ordered_time;
	private int room_number;
	
	public OrderedToRoom() {
		
	}
	
	public OrderedToRoom(int ordered_toroom_id, int room_id, int room_accounts, int number_of_room,
			Date room_ordered_time, int room_number) {
		this.ordered_toroom_id = ordered_toroom_id;
		this.room_id = room_id;
		this.room_accounts = room_accounts;
		this.number_of_room = number_of_room;
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

	public int getNumber_of_room() {
		return number_of_room;
	}

	public void setNumber_of_room(int number_of_room) {
		this.number_of_room = number_of_room;
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
	
}
