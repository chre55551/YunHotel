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
	public Room queryRoom_id(int id) {
//	Room bean = null;
	Session session = factory.getCurrentSession();
	Room room = session.get(Room.class, id);
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
    @SuppressWarnings("unchecked")
	@Override
	public List<Room> queryAll() {
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
		session.update(rBean);
		
	}
	
	

    
    
	@Override
	public void delete(int room_id) {
		Session session = factory.getCurrentSession();
		Room suite = new Room();
		suite.setRoom_id(room_id);
		session.delete(suite);
	}



	@Override
	public void save(RoomType rBean) {
		Session session = factory.getCurrentSession();
		session.save(rBean);
		
	}


	



    
    
}