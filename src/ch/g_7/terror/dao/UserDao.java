package ch.g_7.terror.dao;

import ch.g_7.terror.dao.util.AbstractDao;
import ch.g_7.terror.dao.util.querryoperation.SingleReadOperation;
import ch.g_7.terror.model.User;

public class UserDao extends AbstractDao<User> implements IUserDao{

	
	@Override
	public User getByEmail(String email) {
		return executeCustomQuarry("SELECT u FROM User u where u.email = :email", (q) -> q.setParameter("email", email) , new SingleReadOperation<User>());
	}
	
	
	@Override
	public Class<User> getClazz() {
		return User.class;
	}


	@Override
	public User getByUserName(String userName) {
		return executeCustomQuarry("SELECT u FROM User u where u.username = :username", (q) -> q.setParameter("username", userName) , new SingleReadOperation<User>());
	}




}
