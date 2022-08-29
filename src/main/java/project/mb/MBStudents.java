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
@ManagedBean(name = "mbStd")
public class MBStudents {

	private StudentDAO stdDAO;
	private List<Student> stdTable;
	private Student student;
	private University university;
	private School school;
	private Program program;
	private Student std;
	private UniversityDAO uniDAO;
	private SchoolDAO schoolDAO;
	private ProgramDAO proDAO;
	private List<University> uniTable;
	private List<School> schoolTable;
	private List<Program> progTable;

	@PostConstruct
	public void init() {
		std = new Student();
		stdDAO = new StudentDAO();
		stdTable = stdDAO.selectAll();
		std.setStudentUniversity(new University());
		std.setStudentSchool(new School());
		std.setStudentProgram(new Program());

		uniDAO = new UniversityDAO();
		uniTable = uniDAO.selectAll();

		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();

		proDAO = new ProgramDAO();
		progTable = proDAO.selectAll();

	}

	public String update() {
		stdDAO.update(getStd());
		stdTable = stdDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String remove() {
		StudentDAO stdDao = new StudentDAO();
		stdDao.delete(student.getStudentID());
		stdTable = stdDao.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}
///////////////////////// Getter & Setters /////////////////////////////////////////

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public List<University> getUniTable() {
		return uniTable;
	}

	public void setUniTable(List<University> uniTable) {
		this.uniTable = uniTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<Program> getProgTable() {
		return progTable;
	}

	public void setProgTable(List<Program> progTable) {
		this.progTable = progTable;
	}

}
