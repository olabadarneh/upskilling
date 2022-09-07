package project.mb;

import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import util.Message;

@ManagedBean(name = "mbSec")
@SessionScoped
public class MBSecurity {

	private String username;
	private String password;
	private boolean login;

	private String lang = "en";
	private Locale locale = Locale.ENGLISH;
	private String dir = "ltr";

	private static Map<String, Object> countries;

	public String checkUser() {
		if ((username.equalsIgnoreCase("ola") && password.equals("java2022")) || (username.equalsIgnoreCase("java") && password.equals("Java@2022"))) {
			login = true;
			return "/home.xhtml";
		} else {
			login = false;
			Message.addMessage("ERROR", " ", "Please check username or password");
			return null;
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		lang = "en";
		return "/home.xhtml?faces-redirect=true";
	}

	public String changeLanguage() {
		if (lang.equals("ar")) {
			lang = "en";
		} else {
			lang = "ar";
		}

		locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
		dir = lang.equals("ar") ? "rtl" : "ltr";

		return null;
	}

//	public void localeChanged(ValueChangeEvent e) {
//		lang = e.getNewValue().toString();
//		for (Map.Entry<String, Object> entry : countries.entrySet()) {
//			if (entry.getValue().toString().equals(lang)) {
//				locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
//				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
//				dir = lang.equals("ar") ? "rtl" : "ltr";
//			}
//		}
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean logon) {
		this.login = logon;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getDir() {
		return dir;
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
