package hotel.yun.room.util;

import java.util.Comparator;

import hotel.yun.room.model.Room;

public class RoomSort implements Comparator<Room> {

//hehe

	@Override
	public int compare(Room o1, Room o2) {
		{ 
			return o1.getRoom_name().compareTo(o2.getRoom_name()); 
		} 
	}

}
