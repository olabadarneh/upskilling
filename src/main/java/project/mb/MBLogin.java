package project.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import project.bean.User;
import project.dao.UserDAO;

@ManagedBean(name = "mblogin")
public class MBLogin {

	private UserDAO userdao = new UserDAO();
	private User user = new User();
	private String email;
	private String password;
	private boolean check;

	public String login() {
		user = userdao.selectbyemail(email, password);

		if (user != null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User authenticate Successfuly"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Email & Password", "Please check the email & password"));
			return null;

		}
		return "/secured/welcome.xhtml";
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
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

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

}
