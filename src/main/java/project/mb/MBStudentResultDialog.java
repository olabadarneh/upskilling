package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Student;
import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentResultDAO;
import project.dao.TrainingCourseDAO;

@ViewScoped
@ManagedBean(name = "mbStdResDlg")
public class MBStudentResultDialog {
	private StudentResultDAO stdResDAO;
	private List<StudentResult> stdResTable;
	private StudentResult selectedSTR;
	private List<Student> studentTable;
	private Student student;
	private TrainingCourse trainCourTable;
	private TrainingCourse trainCour;

	@PostConstruct
	public void init() {
		stdResDAO = new StudentResultDAO();
		stdResTable = stdResDAO.selectAll();
		selectedSTR = new StudentResult();

		StudentDAO stdDAO = new StudentDAO();
		stdDAO.selectAll();
		student = new Student();

		TrainingCourseDAO trainCourDAO = new TrainingCourseDAO();
		trainCourDAO.selectAll();
		trainCour = new TrainingCourse();
	}

	public String update() {
		stdResDAO = new StudentResultDAO();
		stdResDAO.insert(getSelectedSTR());
		stdResTable = stdResDAO.selectAll();
		return null;
	}

	/////////////// Getters & Setters /////////
	public StudentResult getSelectedSTR() {
		return selectedSTR;
	}

	public List<StudentResult> getStdResTable() {
		return stdResTable;
	}

	public void setStdResTable(List<StudentResult> stdResTable) {
		this.stdResTable = stdResTable;
	}

	public void setSelectedSTR(StudentResult selectedSTR) {
		this.selectedSTR = selectedSTR;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainingCourse getTrainCourTable() {
		return trainCourTable;
	}

	public void setTrainCourTable(TrainingCourse trainCourTable) {
		this.trainCourTable = trainCourTable;
	}

	public TrainingCourse getTrainCour() {
		return trainCour;
	}

	public void setTrainCour(TrainingCourse trainCour) {
		this.trainCour = trainCour;
	}
}
