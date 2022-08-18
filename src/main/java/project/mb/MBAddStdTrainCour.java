package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.bean.TrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentTrainingCourseDAO;
import project.dao.TrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbAddSTR")
public class MBAddStdTrainCour {
	private StudentTrainingCourseDAO strDAO;
	private List<StudentTrainingCourse> strTable;
	private StudentTrainingCourse Str;
	private Student student;
	private List<Student> std;
	private List<TrainingCourse> trainCour;
	private TrainingCourse trainCourse;

	@PostConstruct
	public void init() {
		strDAO = new StudentTrainingCourseDAO();
		strTable = strDAO.selectAll();
		Str = new StudentTrainingCourse();

		StudentDAO stdDAO = new StudentDAO();
		std = stdDAO.selectAll();
		student = new Student();

		TrainingCourseDAO trDAO = new TrainingCourseDAO();
		trainCour = trDAO.selectAll();
		trainCourse = new TrainingCourse();
	}

	public String add() {
		strDAO.insert(Str);
		Message.addMessageByKey("INFO", " ", "msg_save");
		StudentTrainingCourse Str = new StudentTrainingCourse();
		Str.setStudent(new Student());
		Str.setTrainingCourseID(new TrainingCourse());
		return null;
	}

	//////////////////// Getters & Setters ////////////////
	public List<StudentTrainingCourse> getStrTable() {
		return strTable;
	}

	public void setStrTable(List<StudentTrainingCourse> strTable) {
		this.strTable = strTable;
	}

	public StudentTrainingCourse getStr() {
		if (Str == null) {
			Str = new StudentTrainingCourse();
			Str.setStudent(new Student());
			Str.setTrainingCourseID(new TrainingCourse());
		}
		return Str;
	}

	public void setStr(StudentTrainingCourse str) {
		Str = str;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainingCourse getTrainCourse() {
		return trainCourse;
	}

	public void setTrainCourse(TrainingCourse trainCourse) {
		this.trainCourse = trainCourse;
	}

}
