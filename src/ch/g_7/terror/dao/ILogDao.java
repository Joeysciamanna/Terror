package ch.g_7.terror.dao;

import java.util.List;

import ch.g_7.terror.model.Log;

public interface ILogDao {

	List<Log> getAllByUserId(long userId);

}
