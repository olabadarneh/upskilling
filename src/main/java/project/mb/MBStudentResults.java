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
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStdResult")
public class MBStudentResults {
	private StudentResult stdRes;
	private StudentResult studentdRes;
	private List<StudentResult> stdResTable;
	private StudentResultDAO stdResDAO;
	private Student student;
	private TrainingCourse trainCourse;
	private List<Student> std;
	private List<TrainingCourse> trainCourseTable;
	private StudentDAO stdDAO;
	private TrainingCourseDAO trainCourseDAO;

	@PostConstruct
	public void init() {
		stdRes = new StudentResult();
		studentdRes = new StudentResult();

		stdDAO = new StudentDAO();
		std = stdDAO.selectAll();

		trainCourseDAO = new TrainingCourseDAO();
		trainCourseTable = trainCourseDAO.selectAll();

		studentdRes.setStudentID(new Student());
		studentdRes.setTrainingCourseID(new TrainingCourse());

		stdRes.setStudentID(new Student());
		stdRes.setTrainingCourseID(new TrainingCourse());

		stdResDAO = new StudentResultDAO();
		stdResTable = stdResDAO.selectAll();

	}

	public String add() {
		stdResDAO.insert(stdRes);
		Message.addMessageByKey("INFO", " ", "msg_save");
		stdRes = new StudentResult();
		stdRes.setStudentID(new Student());
		stdRes.setTrainingCourseID(new TrainingCourse());
		return null;
	}

	public String update() {
		stdResDAO = new StudentResultDAO();
		stdResDAO.update(getStudentdRes());
		stdResTable = stdResDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String remove() {
		stdResDAO.delete(stdRes.getStudentID().getStudentID());
		stdResTable = stdResDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}

	////////////// Getters & Setters ////////////
	public List<StudentResult> getStdResTable() {
		return stdResTable;
	}

	public void setStdResTable(List<StudentResult> stdResTable) {
		this.stdResTable = stdResTable;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentResult getStdRes() {
		if (stdRes == null) {
			stdRes = new StudentResult();
			stdRes.setStudentID(new Student());
			stdRes.setTrainingCourseID(new TrainingCourse());
		}
		return stdRes;
	}

	public void setStdRes(StudentResult stdRes) {
		this.stdRes = stdRes;
	}

	public TrainingCourse getTrainCourse() {
		return trainCourse;
	}

	public void setTrainCourse(TrainingCourse trainCourse) {
		this.trainCourse = trainCourse;
	}

	public List<Student> getStd() {
		return std;
	}

	public void setStd(List<Student> std) {
		this.std = std;
	}

	public List<TrainingCourse> getTrainCourseTable() {
		return trainCourseTable;
	}

	public void setTrainCourseTable(List<TrainingCourse> trainCourseTable) {
		this.trainCourseTable = trainCourseTable;
	}

	public StudentResult getStudentdRes() {
		return studentdRes;
	}

	public void setStudentdRes(StudentResult studentdRes) {
		this.studentdRes = studentdRes;
	}
}
