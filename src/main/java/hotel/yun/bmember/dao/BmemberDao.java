package hotel.yun.bmember.dao;

import java.util.List;


import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Customer;



public interface BmemberDao {
	public void  insert(BmemberBean nBean);	
	public BmemberBean queryMemberID(int bs_id);
	public List<BmemberBean> queryAllMember();
	public BmemberBean update(BmemberBean nbean);
	public boolean delete(int bs_id);
	BmemberBean getCustomerById(int bs_id);
	public List<Customer> queryAllMember1();
	public BmemberBean checkIdPassword(String account, String password);	
}
