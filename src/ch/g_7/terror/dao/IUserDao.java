package ch.g_7.terror.dao;

import ch.g_7.terror.model.User;

public interface IUserDao {
	
	public void create(User user);
	
	public User getByEmail(String email);
	
	public User getByUserName(String userName);
}