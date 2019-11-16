package ch.g_7.terror.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.g_7.terror.service.IUserService;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = -7585723027391394711L;

	private String email = "";
	private String password = "";
	
	@Inject
	private transient IUserService userService;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String login() {
		String aim = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("aim");
		if (userService.login(email, password)) {
			password = "";
			return aim == null || aim.isEmpty() ? "home" : (aim + "&faces-redirect=true");
		}
		password = "";
		return "signin";
	}
}
