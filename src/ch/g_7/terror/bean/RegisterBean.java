package ch.g_7.terror.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.g_7.terror.service.IUserService;

@Named
@ViewScoped
public class RegisterBean implements Serializable {
	private static final long serialVersionUID = -8845855312932960905L;

	private String username = "";
	private String email = "";
	private String password = "";
	private String valPassword = "";

	@Inject
	private transient IUserService userService;


	public String register() {
		if (userService.register(username, email, password, valPassword)) {
			String aim = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("aim");
			return "signin" + (aim == null || aim.isEmpty() ? "?" : ("aim=" + aim + "&")) + "faces-redirect=true";
		}
		password = "";
		valPassword = "";
		return "register";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

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
	
	public String getValPassword() {
		return valPassword;
	}
	
	public void setValPassword(String valPassword) {
		this.valPassword = valPassword;
	}

}
