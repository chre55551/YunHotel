package hotel.yun.customer.service;

import java.util.List;


import hotel.yun.customer.model.Customer;

public interface CustomerService {
	Customer getCustomerById(int id);

	List<Customer> getCustomers();

	Object save(Customer bean);
	
	void updateCustomer(Customer bean); 

	void deleteCustomerByPrimaryKey(int key);
	
}