package hotel.yun.room.dao;


import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;

import java.util.List;

public interface RoomDao {
	
    Object save(Room rBean);
    Room queryRoom_id(int id);
    List<Room> queryAll();
    void update(Room rBean); 
	void delete(int room_id);
//	public Room insert(Room rBean);
//  void update(RoomType rbean);
//	public Room query(int room_id);
//	public List<Room> queryAll();
//	public Room update(Room rBean );
//	public boolean delete(int room_id);
	
}
