package hotel.yun.room.service;

import java.util.List;

import hotel.yun.room.model.Room;


public interface RoomService {
	    Object save(Room rBean);
	    Room queryRoom_id(int room_id);
	    List<Room> queryAll();
	    void update(Room rBean); 
		void delete(int room_id);
}
