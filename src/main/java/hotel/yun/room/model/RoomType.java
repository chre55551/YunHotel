package hotel.yun.room.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hotel.yun.ordered.model.Ordered;

@Entity
@Table(name = "room_type")
public class RoomType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_typeid;  //房間類別編號
	private String room_type; //房型
	private double room_price;//房價
	private String room_stock;//庫存
	private Blob room_image;  //房間圖片
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType", cascade = CascadeType.ALL)
	private Set<Room> room = new HashSet<>();
	
	public RoomType() {
		
		
	}
	
	
	
	public RoomType(int room_typeid, String room_type,double room_price,String room_stock,Blob room_image, Set<Room> room) {
		this.room_typeid = room_typeid;
		this.room_type = room_type;
		this.room_price = room_price;
		this.room_stock = room_stock;
		this.room_image = room_image;
		this.room = room;
		
	}
	
	
	
	

	public int getRoom_typeid() {
		return room_typeid;
	}

	public void setRoom_typeid(int room_typeid) {
		this.room_typeid = room_typeid;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(double room_price) {
		this.room_price = room_price;
	}

	public String getRoom_stock() {
		return room_stock;
	}

	public void setRoom_stock(String room_stock) {
		this.room_stock = room_stock;
	}

	public Blob getRoom_image() {
		return room_image;
	}

	public void setRoom_image(Blob room_image) {
		this.room_image = room_image;
	}

	public Set<Room> getRoom() {
		return room;
	}

	public void setRoom(Set<Room> room) {
		this.room = room;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
