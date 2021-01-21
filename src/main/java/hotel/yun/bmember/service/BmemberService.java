package hotel.yun.bmember.service;

import java.util.List;

import hotel.yun.bmember.model.bmemberbean;

public interface BmemberService {

	public bmemberbean insert(bmemberbean nBean);	
	public bmemberbean queryMemberID(int bs_id);
	public List<bmemberbean> queryAllMember();
	public bmemberbean update(bmemberbean nbean);
	public boolean delete(int bs_id);
}
