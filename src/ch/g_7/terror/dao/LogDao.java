package ch.g_7.terror.dao;

import java.util.List;

import ch.g_7.terror.dao.util.AbstractDao;
import ch.g_7.terror.dao.util.querryoperation.ListReadOperation;
import ch.g_7.terror.model.Log;

public class LogDao extends AbstractDao<Log> implements ILogDao{

	
	
	@Override
	public List<Log> getAllByUserId(long userId) {
		return executeCustomQuarry("SELECT l FROM Log l where l.application.user.id = :userId", (q) -> q.setParameter("userId", userId) , new ListReadOperation<Log>());

	}

	
	
	@Override
	public Class<Log> getClazz() {
		return Log.class;
	}
}
