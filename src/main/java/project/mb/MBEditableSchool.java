package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import project.bean.School;
import project.dao.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbEditableSch")
public class MBEditableSchool {

	private SchoolDAO schoolDAO;
	private List<School> schoolTable;
	private School selectedSchool;

	@PostConstruct
	public void init() {
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		selectedSchool = new School();
	}

	public String saveEditable() {
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String update() {
		schoolDAO.update(getSelectedSchool());
		schoolTable = schoolDAO.selectAll();
		return null;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	///// Getters & Setters ///////
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
