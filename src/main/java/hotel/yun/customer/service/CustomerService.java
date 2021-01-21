package hotel.yun.customer.service;

import java.util.List;


import hotel.yun.customer.model.Customer;

public interface CustomerService {
	public Customer insert(Customer cBean);//新增顧客資訊
	public List<Customer> queryAll(int customer_id);//依照顧客編號來查詢所有顧客資訊
	public Customer update(Customer cBean);//依照訂單編號即可修改整張訂單
	public void delete(int customer_id);//依照顧客編號來刪除整筆資料
	Customer checkIdPassword(String userId, String password) ;
}