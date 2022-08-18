package project.mb;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import project.bean.User;
import project.dao.UserDAO;

@ViewScoped
@ManagedBean(name = "mbRegistration")
public class MBRegistration {

	private User user = new User();
	private UserDAO userdao = new UserDAO();
	private boolean accept;

	public String print() {

		System.out.println(user.toString());
		userdao.insert(user);

		if (isAccept() == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Terms & Condition", "Please accept tirms & conditions"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added Successfuly"));
		}
		return null;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

}
