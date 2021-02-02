package hotel.yun.finance.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.finance.dao.Finance_Dao;
import hotel.yun.finance.model.Finance;
import hotel.yun.finance.service.Finance_Service;

@Transactional
@Service
public class Finance_ServiceImpl implements Finance_Service {
	private static final long serialVersionUID = 1L;
	@Autowired
	Finance_Dao FDao;
	
	@Override
	public Finance insert(Finance nBean) {
		return FDao.insert(nBean);
	}

	@Override
	public Finance queryID(int finance_id) {
		return FDao.queryID(finance_id);
	}
	
	@Override
	public List<Finance> queryAll() {
		return FDao.queryAll();
	}

	@Override
	public Finance update(Finance nbean) {
		return FDao.update(nbean);
	}

	@Override
	public boolean delete(int finance_id) {
		return FDao.delete(finance_id);
	}

}
