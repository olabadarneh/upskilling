package project.mb;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import project.bean.Program;
import project.bean.School;
import project.bean.Student;
import project.bean.University;
import project.dao.ProgramDAO;
import project.dao.SchoolDAO;
import project.dao.StudentDAO;
import project.dao.UniversityDAO;
import project.report.Report;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddStd")
public class MBAddStudent {
	private Student student;
	private List<Student> stdTable;
	private StudentDAO studentDAO;
	private List<School> schoolTable;
	private List<University> universityTable;
	private List<Program> programTable;
	private University university;
	private School school;
	private Program program;
	private SchoolDAO schoolDAO;
	private UniversityDAO universityDAO;
	private ProgramDAO programDAO;

	@PostConstruct
	public void init() {
		student = new Student();
		studentDAO = new StudentDAO();
		stdTable = studentDAO.selectAll();

		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		student.setStudentSchool(new School());

		universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		student.setStudentUniversity(new University());

		programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		student.setStudentProgram(new Program());

	}

	public String add() {
		studentDAO = new StudentDAO();
		studentDAO.insert(student);
		Message.addMessageByKey("INFO", " ", "msg_save");
		student = new Student();
		student.setStudentSchool(new School());
		student.setStudentUniversity(new University());
		student.setStudentProgram(new Program());
		return null;
	}

	public String runStudentsReport() throws Exception {

		Map<String, Object> parmeter = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/Upskilling_Students.png"));
		parmeter.put("p_image", image);

		Report report = new Report();
		report.runPdf("students.jasper", parmeter);
		return null;

	}

	////////////// Getters & Setters //////////
	public Student getStudent() {
		if (student == null) {
			student = new Student();
			student.setStudentUniversity(new University());
			student.setStudentSchool(new School());
			student.setStudentProgram(new Program());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
