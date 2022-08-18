package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import project.bean.University;
import project.dao.UniversityDAO;
import util.Message;

@ManagedBean(name = "mbUniDlg")
public class MBUniversityDialog {

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

	public String update() {
		universityDAO.update(getSelectedUniversity());
		universityTable = universityDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	//////// Getters & Setters ////////

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
