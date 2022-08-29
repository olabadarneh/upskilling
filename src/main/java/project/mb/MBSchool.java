package project.mb;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import project.bean.School;
import project.dao.SchoolDAO;
import project.report.Report;

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

	public String runSchoolReport() throws Exception {

		Map<String, Object> parmeter = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/upskilling schools.jpg"));
		parmeter.put("p_image", image);

		Report report = new Report();
		report.runPdf("school.jasper", parmeter);
		return null;

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
