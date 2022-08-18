package project.mb;

import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.School;
import project.dao.SchoolDAO;

@ViewScoped
@ManagedBean(name = "mbSchool")
public class MBSchool {

////////////////////////////////////////////////////////////////
	private SchoolDAO schoolDAO;
	private School selectedSchool;
	private List<School> schoolTable;
	private List<School> filtered;

////////////////////////////////////////////////////////////////

	@PostConstruct
	private void init() {
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		selectedSchool = new School();
	}

	public boolean filter(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}
		return filter(filtered, "", locale);
	}

/////////////  Getters & Setters ///////////////

	public School getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(School selectedSchool) {
		this.selectedSchool = selectedSchool;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<School> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<School> filtered) {
		this.filtered = filtered;
	}

}
