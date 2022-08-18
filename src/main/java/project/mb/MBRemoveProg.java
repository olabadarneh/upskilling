package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Program;
import project.dao.ProgramDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbRemoveProg")
public class MBRemoveProg {
	private ProgramDAO programDAO;
	private List<Program> programTable;
	private Program selectedProgram;

	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		selectedProgram = new Program();
	}

	public String remove() {
		ProgramDAO programDAO = new ProgramDAO();
		programDAO.delete(selectedProgram.getProgramID());
		programTable = programDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;

	}

	/////// Getters & Setters //////////
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
}
