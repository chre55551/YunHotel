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
		
		return null;
	}

	@Override
	public List<Ordered> queryAll() {
		
		return null;
	}

	@Override
	public Ordered update(Ordered obean) {
		
		return null;
	}

	@Override
	public boolean delete(int ordered_number) {
		
		return false;
	}

}
