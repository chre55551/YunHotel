package hotel.yun.bmember.dao.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.yun.bmember.dao.BmemberDao;
import hotel.yun.bmember.model.BmemberBean;

@Repository
public class BmemberDaoImpl implements Serializable, BmemberDao {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	
	@Override
	public void insert(BmemberBean nBean) {
		Session session = factory.getCurrentSession();
		session.save(nBean);

	}

	@Override
	public BmemberBean queryMemberID(int bs_id) {
		Session session = factory.getCurrentSession();
		BmemberBean bb=session.get(BmemberBean.class,bs_id);
		if(bb==null)
			System.out.println("會員編號"+bs_id+"找不到");
		return bb;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<BmemberBean> queryAllMember() {
		String hql="FROM bmemberbean";
		Session session=null;
		List<BmemberBean> list=new ArrayList<>();
		session=factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public BmemberBean update(BmemberBean nbean) {
		Session session = factory.getCurrentSession();
		session.update(nbean);
		return nbean;
	}

	@Override
	public boolean delete(int bs_id) {
		Session session = factory.getCurrentSession();
		BmemberBean onemember = new BmemberBean();
		onemember.setBs_id(bs_id);
		session.delete(onemember);
		return false;
	}

}
