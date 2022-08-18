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
@ManagedBean(name = "mbAddProgram")
public class MBAddProgram {
	private Program program;
	private List<String> programTable;
	private List<School> schoolTable;
	private ProgramDAO programDAO;

	@PostConstruct
	public void init() {
		 programDAO = new ProgramDAO();
		programTable = programDAO.selectProgAname();

		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
	}

	public String Add() {

		ProgramDAO programDAO = new ProgramDAO();
		programDAO.insert(program);
		Message.addMessageByKey("INFO", " ", "msg_save");

		program = new Program();
		program.setSchool(new School());
		return null;
	}
	
	////// Getters & Setter //////////

	public Program getProgram() {
		if (program == null) {
			program = new Program();
			program.setSchool(new School());
		}
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<String> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<String> programTable) {
		this.programTable = programTable;
	}
}
