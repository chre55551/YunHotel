package hotel.yun.ordered.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.ordered.dao.Ordered_Dao;
import hotel.yun.ordered.model.Ordered;

@Repository
public class Ordered_DaoImpl implements Serializable, Ordered_Dao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Ordered insert(Ordered oBean) {
		Session session = factory.getCurrentSession();
		session.save(oBean);
		return oBean;
	}

	@Override
	public Ordered query(int ordered_number) {
		Ordered od = null;
		Session session = factory.getCurrentSession();
		od = session.get(Ordered.class, ordered_number);
		return od;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordered> queryAll() {
		List<Ordered> list = null;
		String hql = "FROM Ordered";
		Session session = factory.getCurrentSession();
		
		list = session.createQuery(hql).getResultList();
		
		return list;
	}

	@Override
	public Ordered update(Ordered oBean) {
		
		return null;
	}

	@Override
	public void delete(int ordered_number) {
	//	Session session = factory.getCurrentSession();
	
	}

}
