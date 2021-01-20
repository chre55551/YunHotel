package hotel.yun.date.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.yun.date.dao.DateDao;
import hotel.yun.date.service.Date_Service;

@Transactional
@Service
public class DateServiceImpl implements Date_Service {

	@Autowired
	private DateDao dDao;
}
