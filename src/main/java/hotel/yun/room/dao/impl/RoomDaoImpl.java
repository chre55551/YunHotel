package hotel.yun.room.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.room.dao.RoomDao;
import hotel.yun.room.model.Room;
import hotel.yun.room.model.RoomType;

@Repository
public class RoomDaoImpl implements RoomDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

    

    public RoomDaoImpl() { 
	
    }
    
    @Override
	public Object save(Room rBean) {
		Session session = factory.getCurrentSession();
		return session.save(rBean);
		
	}
    
    @Override
	public Room queryRoom_id(int room_id) {
	Session session = factory.getCurrentSession();
	Room room = session.get(Room.class, room_id);
//	Room bean = null;
//	String hql  = "FROM Room r WHERE r.room_id = :id";
//	try {
//		bean = (Room)session.createQuery(hql)
//								.setParameter("id", id)
//								.getSingleResult();
//	} catch(NoResultException e) {
//		;  // 表示查無紀錄
//	}
	return room;
}
    
	@Override
    public Room queryByRoomNum(String num) {
    	Session session = factory.getCurrentSession();
    	String hql  = "FROM Room r WHERE r.room_name = :name";
    	Room r = (Room)session.createQuery(hql).setParameter("name", num).getSingleResult();
    	return r;
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> queryAllRoom() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM Room";
		List<Room> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
    
	
	@Override
	public void update(Room rBean) {
		Session session = factory.getCurrentSession();
		Room room = session.get(Room.class, rBean.getRoom_id());
		if(rBean.getRoom_name()!=null) {
			room.setRoom_name(rBean.getRoom_name());
		}
		if(rBean.getRoomType()!=null) {
			room.setRoomType(rBean.getRoomType());
		}
		if(rBean.getDate()!=null) {
			room.setDate(rBean.getDate());
		}
		session.update(room);
		
	}
	
	

    
    
	@Override
	public void delete(int room_id) {
		Session session = factory.getCurrentSession();
		Room suite = new Room();
		suite.setRoom_id(room_id);
		session.delete(suite);
	}



	@Override
	public void saveRoomType(RoomType rBean) {
		Session session = factory.getCurrentSession();
		session.save(rBean);
		
	}


	
    @Override
	public RoomType queryRoomType_id(int room_typeid) {
//	Room bean = null;
	Session session = factory.getCurrentSession();
	RoomType roomtype = session.get(RoomType.class, room_typeid);
	return roomtype;
    }
//	String hql  = "FROM Room r WHERE r.room_id = :id";
//	try {
//		bean = (Room)session.createQuery(hql)
//								.setParameter("id", id)
//								.getSingleResult();
//	} catch(NoResultException e) {
//		;  // 表示查無紀錄
//	}
	
  
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomType> queryAllRoomType() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM RoomType";
		List<RoomType> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	
	@Override
	public void updateRoomType(RoomType rBean) {
		Session session = factory.getCurrentSession();
		RoomType roomtype = session.get(RoomType.class, rBean.getRoom_typeid());
		if(rBean.getRoom_type()!=null) {
			roomtype.setRoom_type(rBean.getRoom_type());
		}
		if(rBean.getRoom_price()!=0) {
			roomtype.setRoom_price(rBean.getRoom_price());
		}
		if(rBean.getRoom_stock()!=0) {
			roomtype.setRoom_stock(rBean.getRoom_stock());
		}
		if(rBean.getRoom_image()!=null) {
			roomtype.setRoom_image(rBean.getRoom_image());
		}
		session.update(roomtype);
		
	}
	
	
	@Override
	public void deleteRoomType(int room_typeid) {
		Session session = factory.getCurrentSession();
		RoomType suite = new RoomType();
		suite.setRoom_typeid(room_typeid);
		session.delete(suite);
	}
    
}