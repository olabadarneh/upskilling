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

import project.bean.Program;
import project.dao.ProgramDAO;
import project.report.Report;

@ViewScoped
@ManagedBean(name = "mbProgram")
public class MBProgram {

	/////////////////////////////////////////////////////////////////////
	private ProgramDAO programDAO;
	private List<Program> programTable;
	private Program selectedProgram;
	private List<Program> filtered;

///////////////////////////////////////////////////////////////////////

	@PostConstruct
	private void init() {
		programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		selectedProgram = new Program();
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

	public String runProgramReport() throws Exception {

		Map<String, Object> parmeter = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/upskilling_program.png"));
		parmeter.put("p_image", image);

		Report report = new Report();
		report.runPdf("program.jasper", parmeter);
		return null;

	}

	//////////// Getters & Setters ////////////////
	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public Program getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(Program selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public List<Program> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Program> filtered) {
		this.filtered = filtered;
	}

}
