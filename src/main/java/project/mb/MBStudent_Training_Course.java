package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentTrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStdTrainCour")
public class MBStudent_Training_Course {

	private StudentTrainingCourseDAO strDAO;
	private List<StudentTrainingCourse> strTable;
	private StudentTrainingCourse selectedSTR;
	private Student student;
	private List<Student> std;
	private List<TrainingCourse> trainCour;
	private TrainingCourse trainCourse;

	@PostConstruct
	public void init() {
		strDAO = new StudentTrainingCourseDAO();
		strTable = strDAO.selectAll();
		selectedSTR = new StudentTrainingCourse();

		student = new Student();
		trainCourse = new TrainingCourse();
	}

	public String add() {
		strDAO.insert(selectedSTR);
		Message.addMessageByKey("INFO", " ", "msg_save");
		selectedSTR = new StudentTrainingCourse();
		selectedSTR.setStudent(new Student());
		selectedSTR.setTrainingCourseID(new TrainingCourse());
		return null;
	}

	public String update() {
		StudentTrainingCourseDAO strDAO = new StudentTrainingCourseDAO();
		strDAO.update(getSelectedSTR());
		strTable = strDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	public String remove() {
		strDAO = new StudentTrainingCourseDAO();
		strDAO.delete(student.getStudentID());
		strTable = strDAO.selectAll();
		selectedSTR = new StudentTrainingCourse();
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
}
