package hotel.yun.bmember.dao.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.bmember.dao.BmemberDao;
import hotel.yun.bmember.model.bmemberbean;

@Repository
public class BmemberDaoImpl implements Serializable, BmemberDao {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	
	@Override
	public bmemberbean insert(bmemberbean nBean) {
		Session session = factory.getCurrentSession();
		session.save(nBean);
		return nBean;
	}

	@Override
	public bmemberbean queryMemberID(int member_id) {
		Session session = factory.getCurrentSession();
		bmemberbean bb=session.get(bmemberbean.class,member_id);
		if(bb==null)
			System.out.println("會員編號"+member_id+"找不到");
		return bb;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<bmemberbean> queryAllMember() {
		String hql="FROM bmemberbean";
		Session session=null;
		List<bmemberbean> list=new ArrayList<>();
		session=factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public bmemberbean update(bmemberbean nbean) {
		Session session = factory.getCurrentSession();
		session.update(nbean);
		return nbean;
	}

	@Override
	public boolean delete(int member_id) {
		Session session = factory.getCurrentSession();
		bmemberbean onemember = new bmemberbean();
		onemember.setMember_id(member_id);
		session.delete(onemember);
		return false;
	}

}
