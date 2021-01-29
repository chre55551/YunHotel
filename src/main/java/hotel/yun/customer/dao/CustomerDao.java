package hotel.yun.customer.dao;


import java.util.List;


import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;



public interface CustomerDao {

	public Member insertM(Member mBean);
	public Customer insertC(Customer cBean);//新增顧客資訊
	public List<Customer> queryAll();//依照顧客編號來查詢所有顧客資訊
//	public Customer update(Customer cBean);//依照訂單編號即可修改整張訂單
	public void delete(int customer_id);//依照顧客編號來刪除整筆資料
	public Customer query(Customer c);	//依照顧客姓名和電話來查詢資料
	public Member checkIdPassword(String account, String password);
	public Customer queryByAc(String s);
	Customer update(String u);
}

