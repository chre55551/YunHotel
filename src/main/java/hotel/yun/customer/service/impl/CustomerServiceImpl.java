package hotel.yun.customer.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.bmember.model.BmemberBean;
import hotel.yun.customer.dao.CustomerDao;
import hotel.yun.customer.model.Customer;
import hotel.yun.customer.model.Member;
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
	public Customer insertC(Customer cBean) {
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());	
		cBean.getMember().setregister_Time(ts);
		return cDao.insertC(cBean);
		
	}

	@Override
	public Member insertM(Member mBean) {
		return cDao.insertM(mBean);
		
	}

	@Override
	public List<Customer> queryAll() {
		return cDao.queryAll();
	}
	@Override
	public Customer update(Customer cu) {
		return cDao.update(cu);
	}

	@Override
	public void delete(int customer_id) {
		cDao.delete(customer_id);

	}

	@Override
	public Customer query(Customer c) {
		return cDao.query(c);

	}

	@Override
	public Member checkIdPassword(String account, String password) {

		return cDao.checkIdPassword(account, password);
	}

	@Override
	public Customer queryByAc(String s) {
		Customer c = cDao.queryByAc(s);
		return c;
	}

	@Override
	public Customer memquerycut(Customer c) {
		
		return cDao.memquerycut(c);
	}

	@Override
	public Customer queryByAc1(String s) {
		return cDao.queryByAc1(s);
}
}