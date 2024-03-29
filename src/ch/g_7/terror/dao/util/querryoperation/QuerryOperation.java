package ch.g_7.terror.dao.util.querryoperation;

import javax.persistence.TypedQuery;

import ch.g_7.terror.dao.util.QueryExecutor;

public interface QuerryOperation<R,T> {

	public R extractFromQuarry(TypedQuery<T> query);
	
	public void prepare(QueryExecutor<T> executor);
	
	public void close(QueryExecutor<T> executor);
}
