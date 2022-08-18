package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.University;
import project.dao.UniversityDAO;
import util.Message;

@ManagedBean(name = "mbRemoveUni")
public class MBRemoveUni {

	private UniversityDAO universityDAO;
	private List<University> universityTable;
	private University selectedUniversity;

//////////////////////////////////////////////////////////

	@PostConstruct
	public void init() {
		universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		selectedUniversity = new University();
	}

	public String delete() {
		universityDAO.delete(selectedUniversity.getUniversityID());
		universityTable = universityDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");

		return null;
	}

	////// Getters & Setters /////

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public University getSelectedUniversity() {
		return selectedUniversity;
	}

	public void setSelectedUniversity(University selectedUniversity) {
		this.selectedUniversity = selectedUniversity;
	}
}
