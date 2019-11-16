package ch.g_7.terror.service;

import java.util.List;

import javax.inject.Inject;

import ch.g_7.terror.dao.ILogDao;
import ch.g_7.terror.model.Log;
import ch.g_7.terror.util.Session;

public class LogService implements ILogService {

	@Inject
	private ILogDao logDao;
	
	@Inject
	private Session session;
	
	@Override
	public List<Log> getAllLogsOfUser() {
		return logDao.getAllByUserId(1);
	}

}
