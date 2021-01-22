package hotel.yun.bmember.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.bmember.dao.BmemberDao;
import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.bmember.service.BmemberService;

@Transactional
@Service
public class BmemberServiceImpl implements Serializable, BmemberService {

	private static final long serialVersionUID = 1L;

	@Autowired
	BmemberDao bDao;

	@Override
	public void insert(BmemberBean nBean) {
		bDao.insert(nBean);
	}

	@Override
	public BmemberBean queryMemberID(int bs_id) {
		return bDao.queryMemberID(bs_id);
	}

	@Override
	public List<BmemberBean> queryAllMember() {
		return bDao.queryAllMember();
	}

	@Override
	public BmemberBean update(BmemberBean nbean) {
		return bDao.update(nbean);
	}

	@Override
	public boolean delete(int bs_id) {
		return bDao.delete(bs_id);
	}

}
