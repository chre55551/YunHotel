package hotel.yun.room.service.impl;

import java.util.List;

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
		return RDao.queryAll();
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
	public void save(RoomType rBean) {
		RDao.save(rBean);
		
	}
	
}
