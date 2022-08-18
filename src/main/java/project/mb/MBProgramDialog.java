package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Program;
import project.bean.School;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbProgDlg")
public class MBProgramDialog {

	private ProgramDAO programDAO;
	private List<Program> programTable;
	private Program selectedProgram;
	private List<School> schoolTable;
	private School school;
	private Program program;

	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		selectedProgram = new Program();

		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
	}

	public String update() {
		ProgramDAO programDAO = new ProgramDAO();
		programDAO.update(getSelectedProgram());
		programTable = programDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	////// Getters & Setters ////////
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

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
}
