package hotel.yun.bmember.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.bmember.dao.BmemberDao;
import hotel.yun.bmember.model.bmemberbean;
import hotel.yun.bmember.service.BmemberService;

@Transactional
@Service
public class BmemberServiceImpl implements Serializable, BmemberService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	BmemberDao BDao;
	
	@Override
	public bmemberbean insert(bmemberbean nBean) {
		return BDao.insert(nBean);
	}

	@Override
	public bmemberbean queryMemberID(int member_id) {
		return BDao.queryMemberID(member_id);
	}

	@Override
	public List<bmemberbean> queryAllMember() {
		return BDao.queryAllMember();
	}

	@Override
	public bmemberbean update(bmemberbean nbean) {
		return BDao.update(nbean);
	}

	@Override
	public boolean delete(int member_id) {
		return BDao.delete(member_id);
	}

}
