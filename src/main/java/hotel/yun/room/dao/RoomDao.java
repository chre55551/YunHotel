package hotel.yun.room.dao;

import hotel.yun.room.model.Room;
import java.util.List;

public interface RoomDao {
	public Room insert(Room rBean);
	public Room query(int room_id);
	public List<Room> queryAll();
	public Room update(Room rBean );
	public boolean delete(int room_id);
	
}
