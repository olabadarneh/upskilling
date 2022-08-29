package project.mb;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import project.bean.University;
import project.dao.UniversityDAO;
import project.report.Report;

@ViewScoped
@ManagedBean(name = "mbUniversity")
public class MBUniversity {

///////////////////////////////////////////////////////////
	private UniversityDAO universityDAO;
	private List<University> universityTable;
	private List<University> filtered;
	private University selectedUniversity;
	private List<University> university = new ArrayList<University>();
//////////////////////////////////////////////////////////

	@PostConstruct
	public void init() {
		universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		selectedUniversity = new University();
	}

	public void web(University uni) throws IOException {
		selectedUniversity = uni;
		System.out.println(selectedUniversity.getWebsite());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("http://" + selectedUniversity.getWebsite());

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

	public String runUniReport() throws Exception {

		Map<String, Object> parmeter = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/upSilling Universities.png"));
		parmeter.put("p_image", image);

		Report report = new Report();
		report.runPdf("university.jasper", parmeter);
		return null;

	}
///////////////////////// Getter & Setters /////////////////////////////////////////

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

	public List<University> getUniversity() {
		return university;
	}

	public void setUniversity(List<University> university) {
		this.university = university;
	}

	public List<University> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<University> filtered) {
		this.filtered = filtered;
	}

}
