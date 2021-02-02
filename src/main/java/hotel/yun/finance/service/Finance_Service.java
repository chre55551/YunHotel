package hotel.yun.finance.service;

import java.sql.Date;
import java.util.List;

import hotel.yun.finance.model.Finance;

public interface Finance_Service {

	public Finance insert(Finance nBean);	
	public Finance queryID(int finance_id);
	public List<Finance> queryAll();
	public Finance update(Finance nbean);
	public boolean delete(int finance_id);

}
