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
@ManagedBean(name = "mbAddStd")
public class MBAddStudent {
	private Student student;
	private List<String> studentTable;
	private List<Student> stdTable;
	private StudentDAO studentDAO;
	private List<School> schoolTable;
	private List<University> universityTable;
	private List<Program> programTable;
	private University university;
	private School school;
	private Program program;

	@PostConstruct
	public void init() {
		studentDAO = new StudentDAO();
		studentTable = studentDAO.selectByAname();
		stdTable = studentDAO.selectAll();
		student = new Student();

		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		school = new School();

		UniversityDAO universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		university = new University();

		ProgramDAO programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		program = new Program();

	}

	public String add() {
		studentDAO.insert(student);
		Message.addMessageByKey("INFO", " ", "msg_save");
		student = new Student();
		student.setStudentSchool(new School());
		student.setStudentUni(new University());
		student.setStudentProg(new Program());
		return null;
	}

	////////////// Getters & Setters //////////
	public Student getStudent() {
		if (student == null) {
			student = new Student();
			student.setStudentUni(new University());
			student.setStudentSchool(new School());
			student.setStudentProg(new Program());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<String> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<String> studentTable) {
		this.studentTable = studentTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public List<Student> getStdTable() {
		return stdTable;
	}

	public void setStdTable(List<Student> stdTable) {
		this.stdTable = stdTable;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
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
