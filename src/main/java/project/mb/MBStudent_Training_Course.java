package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Student;
import project.bean.StudentResult;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentResultDAO;
import project.dao.StudentTrainingCourseDAO;
import project.dao.TrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStdTrainCour")
public class MBStudent_Training_Course {

	private StudentTrainingCourseDAO strDAO;
	private List<StudentTrainingCourse> strTable;
	private StudentTrainingCourse selectedSTR;
	private StudentTrainingCourse str;
	private Student student;
	private List<Student> std;
	private List<TrainingCourse> trainCour;
	private TrainingCourse trainCourse;
	private StudentDAO stdDAO;
	private TrainingCourseDAO trainCourseDAO;
	private List<StudentResult> stdResulTable;
	private StudentResultDAO stdResDAO;

	@PostConstruct
	public void init() {
		selectedSTR = new StudentTrainingCourse();
		stdDAO = new StudentDAO();
		std = stdDAO.selectAll();
		trainCourseDAO = new TrainingCourseDAO();
		trainCour = trainCourseDAO.selectAll();
		strDAO = new StudentTrainingCourseDAO();
		strTable = strDAO.selectAll();
		selectedSTR.setStudent(new Student());
		selectedSTR.setTrainingCourseID(new TrainingCourse());

		stdResDAO = new StudentResultDAO();
		stdResulTable = stdResDAO.selectAll();

		str = new StudentTrainingCourse();
		str.setStudent(new Student());
		str.setTrainingCourseID(new TrainingCourse());

	}

	public String add() {
		strDAO = new StudentTrainingCourseDAO();
		strDAO.insert(selectedSTR);
		Message.addMessageByKey("INFO", " ", "msg_save");
		selectedSTR = new StudentTrainingCourse();
		selectedSTR.setStudent(new Student());
		selectedSTR.setTrainingCourseID(new TrainingCourse());
		return null;
	}

	public String update() {
		strDAO.update(getStr());
		strTable = strDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String remove() {
		strDAO.delete(selectedSTR.getStudent().getStudentID());
		strTable = strDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}

	//////////// Getters & Setters //////////////
	public List<StudentTrainingCourse> getStrTable() {
		return strTable;
	}

	public void setStrTable(List<StudentTrainingCourse> strTable) {
		this.strTable = strTable;
	}

	public StudentTrainingCourse getSelectedSTR() {

		if (selectedSTR == null) {
			selectedSTR = new StudentTrainingCourse();
			selectedSTR.setStudent(new Student());
			selectedSTR.setTrainingCourseID(new TrainingCourse());
		}
		return selectedSTR;
	}

	public void setSelectedSTR(StudentTrainingCourse selectedSTR) {
		this.selectedSTR = selectedSTR;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStd() {
		return std;
	}

	public void setStd(List<Student> std) {
		this.std = std;
	}

	public List<TrainingCourse> getTrainCour() {
		return trainCour;
	}

	public void setTrainCour(List<TrainingCourse> trainCour) {
		this.trainCour = trainCour;
	}

	public TrainingCourse getTrainCourse() {
		return trainCourse;
	}

	public void setTrainCourse(TrainingCourse trainCourse) {
		this.trainCourse = trainCourse;
	}

	public StudentTrainingCourse getStr() {
		return str;
	}

	public void setStr(StudentTrainingCourse str) {
		this.str = str;
	}

	public List<StudentResult> getStdResulTable() {
		return stdResulTable;
	}

	public void setStdResulTable(List<StudentResult> stdResulTable) {
		this.stdResulTable = stdResulTable;
	}
}
