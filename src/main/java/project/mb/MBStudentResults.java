package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Student;
import project.bean.StudentResult;
import project.bean.TrainingCourse;
import project.dao.StudentResultDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStdResult")
public class MBStudentResults {
	private StudentResult stdRes;
	private List<StudentResult> stdResTable;
	private StudentResultDAO stdResDAO;
	private Student student;
	private TrainingCourse trainCourse;

	@PostConstruct
	public void init() {
		stdResDAO = new StudentResultDAO();
		stdResTable = stdResDAO.selectAll();
		stdRes = new StudentResult();

		student = new Student();
		trainCourse = new TrainingCourse();
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
		stdResDAO.update(getStdRes());
		stdResTable = stdResDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String remove() {
		stdResDAO.delete(student.getStudentID());
		stdResTable = stdResDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}

	////////////// Getters & Setters ////////////
	public StudentResult getStdResSelected() {
		if (stdRes == null) {
			stdRes = new StudentResult();
			stdRes.setStudentID(new Student());
			stdRes.setTrainingCourseID(new TrainingCourse());

		}
		return stdRes;
	}

	public void setStdResSelected(StudentResult stdResSelected) {
		this.stdRes = stdResSelected;
	}

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
}
