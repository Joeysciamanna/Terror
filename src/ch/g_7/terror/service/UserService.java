package ch.g_7.terror.service;

import javax.inject.Inject;

import ch.g_7.terror.dao.IUserDao;
import ch.g_7.terror.model.User;
import ch.g_7.terror.util.Session;
import ch.g_7.terror.util.Util;
import ch.g_7.terror.util.message.Message;
import ch.g_7.terror.util.message.MessageArray;
import ch.g_7.terror.util.message.MessageStyle;

public class UserService implements IUserService {

	@Inject
	private MessageArray msgArray;

	@Inject
	private IUserDao userDao;

	@Inject
	private Session session;

	@Override
	public boolean login(String email, String password) {
		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			User userSaved = userDao.getByEmail(email);
			if (userSaved != null && Util.verifyPassword(password, userSaved.getPassword())) {
				session.setUserId(userSaved.getId());
				return true;
			}
		}
		msgArray.addMessage(new Message(MessageStyle.error, "Incorect email or password!"));
		return false;
	}

	@Override
	public boolean register(String userName, String email, String password, String valPassword) {
		if (userName != null && !userName.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			if(!password.equals(valPassword)) {
				msgArray.addMessage(new Message(MessageStyle.error, "passwords must be equal!"));
			}else if (userDao.getByEmail(email) == null) {
				if(userDao.getByUserName(email) == null ) {
					User user = new User();
					user.setEmail(email);
					user.setUserName(userName);
					user.setPassword(Util.encodePassword(password));
					userDao.create(user);
					return true;
				}else {
					msgArray.addMessage(new Message(MessageStyle.error, "Username alredy in use!"));
				}
			
			} else {
				msgArray.addMessage(new Message(MessageStyle.error, "Email alredy in use!"));
			}
		} else {
			msgArray.addMessage(new Message(MessageStyle.error, "Invalid input!"));
		}
		return false;
	}


}
