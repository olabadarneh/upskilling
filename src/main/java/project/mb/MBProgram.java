package project.mb;

import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Program;
import project.dao.ProgramDAO;

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
