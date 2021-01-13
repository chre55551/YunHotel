package hotel.yun.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.customer.dao.CustomerDao;
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.service.CustomerService;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerDao custDao;

	@Autowired
	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public Customer getCustomerById(int id) {
		return custDao.getCustomerById(id);

	}

	@Override
	public List<Customer> getCustomers() {
		return custDao.getCustomers();
	}

	@Override
	public Object save(Customer bean) {
		return custDao.save(bean);
	}

	@Override
	public void updateCustomer(Customer bean) {
		custDao.updateCustomer(bean);
	}

	@Override
	public void deleteCustomerByPrimaryKey(int key) {
		custDao.deleteCustomerByPrimaryKey(key);

	}

}
