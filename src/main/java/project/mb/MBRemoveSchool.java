package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import project.bean.School;
import project.dao.SchoolDAO;
import util.Message;

@ManagedBean(name = "mbRemoveSch")
public class MBRemoveSchool {

	private SchoolDAO schoolDAO;
	private List<School> schoolTable;
	private School selectedSchool;

	@PostConstruct
	private void init() {
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		selectedSchool = new School();
	}

	public String delete() {
		schoolDAO = new SchoolDAO();
		schoolDAO.delete(selectedSchool.getSchoolID());
		schoolTable = schoolDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");

		return null;
	}

	////////// Getters & Setters /////////

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public School getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(School selectedSchool) {
		this.selectedSchool = selectedSchool;
	}
}
