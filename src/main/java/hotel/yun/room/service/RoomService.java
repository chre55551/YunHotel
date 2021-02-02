package hotel.yun.room.service;

import java.util.List;
import java.util.Set;

import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;


public interface RoomService {
		public Object save(Room rBean);
	    public Room queryRoom_id(int room_id);
	    public List<Room> queryAll();
	    public void update(Room rBean); 
	    public void delete(int room_id);
	    
		public RoomType saveRoomType(RoomType rBean);
		public RoomType queryRoomType_id(int id);
		public List<RoomType> queryAllRoomType();
		public void updateRoomType(RoomType rBean);
		public void updateRoomType(int room_typeid);
		public void deleteRoomType(int room_typeid);
		public Room queryByRoomNum(String s);
		public RoomType queryByRoomType(String roomType);
		public Set<Room> queryAllRoomByRoomType(String roomType);
		public Room queryRoomByName(String room_name);
}
