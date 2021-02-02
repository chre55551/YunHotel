package hotel.yun.finance.dao.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.finance.dao.Finance_Dao;
import hotel.yun.finance.model.Finance;


@Repository
public class Finance_DaoImpl implements Serializable, Finance_Dao {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Finance insert(Finance nBean) {
		Session session = factory.getCurrentSession();
		session.save(nBean);
		return nBean;
	}

	@Override
	public Finance queryID(int finance_id) {
		Session session = factory.getCurrentSession();
		Finance bb=session.get(Finance.class,finance_id);
		if(bb==null)
			System.out.println("找不到編號"+finance_id);
		return bb;
	}
	
	@Override
	public List<Finance> queryAll() {
		String hql="FROM finance";
		Session session=null;
		List<Finance> list=new ArrayList<>();
		session=factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public Finance update(Finance nbean) {
		Session session = factory.getCurrentSession();
		session.update(nbean);
		return nbean;
	}

	@Override
	public boolean delete(int finance_id) {
		Session session = factory.getCurrentSession();
		Finance onenew = new Finance();
		onenew.setFinance_id(finance_id);;
		session.delete(onenew);
		return false;
	}

}
