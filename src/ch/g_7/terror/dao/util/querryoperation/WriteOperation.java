package ch.g_7.terror.dao.util.querryoperation;

import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import ch.g_7.terror.dao.util.DaoException;
import ch.g_7.terror.dao.util.QueryExecutor;

public class WriteOperation<T> implements QuerryOperation<Void, T>{

	@Override
	public Void extractFromQuarry(TypedQuery<T> query) {
		query.executeUpdate();
		return null;
	}

	@Override
	public void prepare(QueryExecutor<T> executor) {
		try {
			executor.getTransaction().begin();
			executor.getEntityManager().joinTransaction();
		} catch (NotSupportedException | SystemException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void close(QueryExecutor<T> executor) {
		try {
			executor.getEntityManager().flush();
			executor.getTransaction().commit();
			executor.getEntityManager().close();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException e) {
			throw new DaoException(e);
		}
	}

}
