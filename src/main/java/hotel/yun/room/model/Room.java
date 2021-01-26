package hotel.yun.room.model;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hotel.yun.date.model.Rdate;
import hotel.yun.ordered.model.OrderedToRoom;

@Entity
@Table(name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	//666
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;         //房間編號
	private String room_name;    //房間名稱
	@Transient
	private int room_typeid;     //房間類別編號
	
	@OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderedToRoom> orderedToRoom = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "room_typeid")
	private RoomType roomType;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "rooms", fetch = FetchType.EAGER)
    private Set<Rdate> rdates = new HashSet<Rdate>();
	
	
	public Room() {
		
	}
			
	public Room(int room_id, String room_name , RoomType roomType) {
		this.room_id = room_id;
		this.room_name = room_name;
		this.roomType = roomType;
	}
	


	public int getRoom_id() {
		return room_id;
	}


	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}


//	public int getRoom_typeid() {
//		return room_typeid;
//	}
//
//
//	public void setRoom_typeid(int room_typeid) {
//		this.room_typeid = room_typeid;
//	}


	public RoomType getRoomType() {
		return roomType;
	}


	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Rdate> getDate() {
		return rdates;
	}

	public void setDate(Set<Rdate> date) {
		this.rdates = date;
	}




}
