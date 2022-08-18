package project.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbTrainCour")
public class MBAddTrainingCour {
	private TrainingCourse trainingCourse;
	private TrainingCourseDAO trainCourseDAO;

	@PostConstruct
	public void init() {
		trainCourseDAO = new TrainingCourseDAO();
		trainingCourse = new TrainingCourse();
	}

	public String add() {
		trainCourseDAO = new TrainingCourseDAO();
		trainCourseDAO.insert(trainingCourse);
		Message.addMessageByKey("INFO", " ", "msg_save");

		trainingCourse = new TrainingCourse();
		return null;
	}

////////// Getters & Setters //////////

	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}
}
