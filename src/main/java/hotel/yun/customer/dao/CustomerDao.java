package hotel.yun.customer.dao;

import java.util.List;

import hotel.yun.customer.model.Customer;


public interface CustomerDao {


		public Customer insert(Customer aBean);
		public Customer query(int customer_id);
		public List<Customer> queryAll();
		public Customer update(Customer aBean);
		public boolean delete(int customer_id);
	}


