package hotel.yun.room.dao;


import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;

import java.util.List;

public interface RoomDao {
	
	public Object save(Room rBean);
    public Room queryRoom_id(int id);
    public List<Room> queryAll();
    public void update(Room rBean); 
    public void delete(int room_id);
    public void save(RoomType rBean);
//	public Room insert(Room rBean);
//  void update(RoomType rbean);
//	public Room query(int room_id);
//	public List<Room> queryAll();
//	public Room update(Room rBean );
//	public boolean delete(int room_id);
	
}
