package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.StudentDAO;
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

	@PostConstruct
	public void init() {

		stdDAO = new StudentDAO();
		stdTable = stdDAO.selectAll();
		student = new Student();

		university = new University();
		school = new School();
		program = new Program();
	}

	public String update() {
		stdDAO = new StudentDAO();
		stdDAO.update(getStudent());
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

}
