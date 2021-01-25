package hotel.yun.bmember.service;

import java.util.List;


import hotel.yun.bmember.model.BmemberBean;

public interface BmemberService {

	BmemberBean getCustomerById(int bs_id);
	public void insert(BmemberBean nBean);	
	public BmemberBean queryMemberID(int bs_id);
	public List<BmemberBean> queryAllMember();
	public BmemberBean update(BmemberBean nbean);
	public boolean delete(int bs_id);
	public BmemberBean checkIdPassword(String account, String password);	
}
