package hotel.yun.room.dao;


import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;

import java.util.List;

public interface RoomDao {
	
	public Object save(Room rBean);
    public Room queryRoom_id(int room_id);
    public List<Room> queryAllRoom();
    public void update(Room rBean); 
    public void delete(int room_id);
    
    public void saveRoomType(RoomType rBean);
    public RoomType queryRoomType_id(int room_typeid);
    public List<RoomType> queryAllRoomType();
    public void updateRoomType(RoomType rBean);
    public void deleteRoomType(int room_typeid);
//	public Room insert(Room rBean);
//  void update(RoomType rbean);
//	public Room query(int room_id);
//	public List<Room> queryAll();
//	public Room update(Room rBean );
//	public boolean delete(int room_id);
	

	
}
