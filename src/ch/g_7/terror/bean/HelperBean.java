package ch.g_7.terror.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.g_7.terror.util.Session;
import ch.g_7.terror.util.message.MessageArray;

@Named
@RequestScoped
public class HelperBean {

	@Inject
	private MessageArray messageArray;

	@Inject
	private Session session;

	public String getMessages() {
		String messages = messageArray.toString();
		messageArray.clear();
		return messages;
	}

	public boolean isLogedIn() {
		return session.getUserId() != -1;
	}
	
	public String logout() {
		session.invalidateSession();
		return "index";
	}
	
	public String getTextColor(String hexCode) {
		hexCode = hexCode.substring(1, hexCode.length());
		int value = Integer.parseInt(hexCode.substring(0,2), 16);
		value += Integer.parseInt(hexCode.substring(2,4), 16);
		value += Integer.parseInt(hexCode.substring(4,6), 16);
		//17D
		if(value > Integer.parseInt("ff", 16)) {
			return "var(--color1)";
		}else {
			return "var(--color2)";
		}
	}

}

