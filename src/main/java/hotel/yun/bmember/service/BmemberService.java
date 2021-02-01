package hotel.yun.bmember.service;

import java.util.List;


import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;


public interface BmemberService {

	BmemberBean getCustomerById(int bs_id);
	public void insert(BmemberBean nBean);	
	public BmemberBean queryMemberID(int bs_id);
	public List<BmemberBean> queryAllMember();
	public BmemberBean update(BmemberBean nbean);
	public boolean delete(int customer_id);
	public BmemberBean checkIdPassword(String account, String password);
	public List<Customer> queryAllMember1();
	public Customer queryByAc(String s);
	public boolean delete1(int member_id);
}
