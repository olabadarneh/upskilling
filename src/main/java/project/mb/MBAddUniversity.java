package project.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.University;
import project.dao.UniversityDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddUniversity")
public class MBAddUniversity {

	private University university;
	private UniversityDAO universityDAO;

	@PostConstruct
	public void init() {
		universityDAO = new UniversityDAO();
		university = new University();
	}

	public String add() {
		universityDAO = new UniversityDAO();
		universityDAO.insert(university);
		Message.addMessageByKey("INFO", " ", "msg_save");

		university = new University();
		return null;
	}

	//// Getter & Setter //////

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
}
