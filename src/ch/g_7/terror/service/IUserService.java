package ch.g_7.terror.service;

public interface IUserService {

	public boolean register(String name, String email, String password, String valPassword);

	public boolean login(String email, String password);
	
}
