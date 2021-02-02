package hotel.yun.customer.service;

import java.util.List;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;

public interface CustomerService {
	public Customer insertC(Customer cBean);//新增顧客資訊
	public Member insertM(Member mBean);//新增顧客資訊
	public List<Customer> queryAll();//依照顧客編號來查詢所有顧客資訊
//	public Customer update(Customer cBean);//依照訂單編號即可修改整張訂單
	public void delete(int member_id);//依照顧客編號來刪除整筆資料
	Customer query(Customer c);//依照顧客姓名和電話來查詢資料
	public Member checkIdPassword(String account, String password);
	public Customer queryByAc(String s);

	public Customer memquerycut(Customer c);
	public Customer queryByAc1(String s);
	Customer update(Customer cu);
}