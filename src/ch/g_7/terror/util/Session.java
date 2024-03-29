package ch.g_7.terror.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@SessionScoped
public class Session implements Serializable {
	
	private static final long serialVersionUID = -232299624744349288L;

	private long userId = -1;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void invalidateSession() {
		HttpSession session = getSession();
		session.invalidate();
	}

	private HttpSession getSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (HttpSession) facesContext.getExternalContext().getSession(true);
	}
}