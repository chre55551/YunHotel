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
	
	
	@Autowired
	private CustomerDao cDao;

	public void setcDao(CustomerDao cDao) {
		this.cDao = cDao;
	}

	@Override
	public Customer insert(Customer cBean) {
		return cDao.insert(cBean);
	}

	@Override
	public List<Customer> queryAll(int customer_id) {
		return cDao.queryAll(customer_id);
	}

	@Override
	public Customer update(Customer cBean) {
		return cDao.update(cBean);
	}

	@Override
	public void delete(int customer_id) {
		cDao.delete(customer_id);

	}

	@Override
	public Customer checkIdPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
