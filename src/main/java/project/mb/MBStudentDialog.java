package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import project.dao.StudentDAO;
import project.dao.UniversityDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStdDlg")
public class MBStudentDialog {
	private StudentDAO stdDAO;
	private List<Student> stdTabl;
	private Student selectedStd;
	private University university;
	private List<University> universityTable;
	private List<School> schoolTable;
	private School school;
	private Program program;
	private List<Program> programlTable;

	@PostConstruct
	public void init() {
		stdDAO = new StudentDAO();

		stdDAO = new StudentDAO();
		stdTabl = stdDAO.selectAll();
		selectedStd = new Student();

		UniversityDAO universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();

		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();

		ProgramDAO programDAO = new ProgramDAO();
		programlTable = programDAO.selectAll();
	}

	public String update() {
		StudentDAO stdDAO = new StudentDAO();

		stdDAO.update(getSelectedStd());
		stdTabl = stdDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	///////////////////// Getters & Setters ////////////////

	public List<Student> getStdTabl() {
		return stdTabl;
	}

	public void setStdTabl(List<Student> stdTabl) {
		this.stdTabl = stdTabl;
	}

	public Student getSelectedStd() {
		if (selectedStd == null) {
			selectedStd = new Student();
			selectedStd.setStudentUni(new University());
			selectedStd.setStudentSchool(new School());
			selectedStd.setStudentProg(new Program());
		}
		return selectedStd;
	}

	public void setSelectedStd(Student selectedStd) {
		this.selectedStd = selectedStd;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
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

	public List<Program> getProgramlTable() {
		return programlTable;
	}

	public void setProgramlTable(List<Program> programlTable) {
		this.programlTable = programlTable;
	}

}
