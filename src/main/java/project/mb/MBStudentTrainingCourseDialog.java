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
@ManagedBean(name = "mbStrDlg")
public class MBStudentTrainingCourseDialog {

	private StudentTrainingCourseDAO strDAO;
	private StudentTrainingCourse str;
	private List<StudentTrainingCourse> strTable;
	private List<Student> stdTabl;
	private Student std;
	private List<TrainingCourse> trainCourTable;
	private TrainingCourse TrainCour;

	@PostConstruct
	public void init() {
		strDAO = new StudentTrainingCourseDAO();
		strTable = strDAO.selectAll();
		str = new StudentTrainingCourse();

		StudentDAO stdDAO = new StudentDAO();
		stdTabl = stdDAO.selectAll();

		TrainingCourseDAO trainCourseDAO = new TrainingCourseDAO();
		trainCourTable = trainCourseDAO.selectAll();
	}

	public String update() {
		StudentTrainingCourseDAO strDAO = new StudentTrainingCourseDAO();
		strDAO.update(getStr());
		strTable = strDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_edit");
		return null;
	}

	/////////////// Getters & Setters ////////////
	public StudentTrainingCourse getStr() {
		return str;
	}

	public void setStr(StudentTrainingCourse str) {
		this.str = str;
	}

	public List<StudentTrainingCourse> getStrTable() {
		return strTable;
	}

	public void setStrTable(List<StudentTrainingCourse> strTable) {
		this.strTable = strTable;
	}

	public List<Student> getStdTabl() {
		return stdTabl;
	}

	public void setStdTabl(List<Student> stdTabl) {
		this.stdTabl = stdTabl;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public List<TrainingCourse> getTrainCourTable() {
		return trainCourTable;
	}

	public void setTrainCourTable(List<TrainingCourse> trainCourTable) {
		this.trainCourTable = trainCourTable;
	}

	public TrainingCourse getTrainCour() {
		return TrainCour;
	}

	public void setTrainCour(TrainingCourse trainCour) {
		TrainCour = trainCour;
	}
}
