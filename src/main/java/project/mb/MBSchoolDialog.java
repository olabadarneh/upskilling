package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.School;
import project.dao.SchoolDAO;
import util.Message;

@ManagedBean(name = "mbSchDlg")
public class MBSchoolDialog {
	private SchoolDAO schoolDAO;
	private List<School> schoolTabl;
	private School selectedSchool;

/////////////////////////////////////////////
	@PostConstruct
	private void init() {
		schoolDAO = new SchoolDAO();
		schoolTabl = schoolDAO.selectAll();
		selectedSchool = new School();
	}

	public String update() {
		schoolDAO.update(getSelectedSchool());
		schoolTabl = schoolDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	/////// Getters & Setters ///////

	public List<School> getSchoolTabl() {
		return schoolTabl;
	}

	public void setSchoolTabl(List<School> schoolTabl) {
		this.schoolTabl = schoolTabl;
	}

	public School getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(School selectedSchool) {
		this.selectedSchool = selectedSchool;
	}
}
