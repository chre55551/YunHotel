package hotel.yun.room.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.room.dao.RoomDao;
import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;
import hotel.yun.room.service.RoomService;



@Transactional
@Service
public class RoomServiceImpl implements RoomService {
   
	RoomDao RDao;
	
	@Autowired
	public void setRDao(RoomDao RDao) {
		this.RDao = RDao;
	}

	@Override
	public Object save(Room rBean) {
		return RDao.save(rBean);
	}

	@Override
	public Room queryRoom_id(int room_id) {
	    return RDao.queryRoom_id(room_id);
	}

	@Override
	public List<Room> queryAll() {
		return RDao.queryAllRoom();
	}

	@Override
	public void update(Room rBean) {
		RDao.update(rBean);
	}

	@Override
	public void delete(int room_id) {
		RDao.delete(room_id);
	}

	@Override
	public void saveRoomType(RoomType rBean) {
		RDao.saveRoomType(rBean);
		
	}

	@Override
	public RoomType queryRoomType_id(int room_typeid) {
		return RDao.queryRoomType_id(room_typeid);
	}

	@Override
	public List<RoomType> queryAllRoomType() {
		return RDao.queryAllRoomType();
	}

	@Override
	public void updateRoomType(RoomType rBean) {
		RDao.updateRoomType(rBean);
	}

	@Override
	public void deleteRoomType(int room_typeid) {
		RDao.delete(room_typeid);
	}

	@Override
	public Room queryByRoomNum(String s) {
		return RDao.queryByRoomNum(s);
	}

	@Override
	public RoomType queryByRoomType(String roomType) {
		return RDao.queryByRoomType(roomType);
	}
	
	@Override
	public Set<Room> queryAllRoomByRoomType(String roomType){
		return RDao.queryAllRoomByRoomType(roomType);
	}

}
