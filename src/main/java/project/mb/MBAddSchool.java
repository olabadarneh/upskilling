package project.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.School;
import project.dao.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddSchool")
public class MBAddSchool {

	private School school;
	private SchoolDAO schoolDAO;

	@PostConstruct
	public void init() {
		schoolDAO = new SchoolDAO();
		school = new School();

	}

	public String add() {
		schoolDAO = new SchoolDAO();
		schoolDAO.insert(school);
		Message.addMessageByKey("INFO", " ", "msg_save");
		school = new School();
		return null;

	}
	///// Getters & Setters //////

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
