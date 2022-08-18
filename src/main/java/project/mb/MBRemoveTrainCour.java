package project.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;
import util.Message;

@ManagedBean(name = "mbReamoveTrain")
public class MBRemoveTrainCour {
	private TrainingCourseDAO traincourseDAO;
	private List<TrainingCourse> traincourseTable;
	private TrainingCourse selectedTrainCour;

	@PostConstruct
	public void init() {
		traincourseDAO = new TrainingCourseDAO();
		traincourseTable = traincourseDAO.selectAll();
		selectedTrainCour = new TrainingCourse();
	}

	public String remove() {
		traincourseDAO.delete(selectedTrainCour.getCourseID());
		traincourseTable = traincourseDAO.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}
////////////////// Getters & Setters //////////

	public List<TrainingCourse> getTraincourseTable() {
		return traincourseTable;
	}

	public void setTraincourseTable(List<TrainingCourse> traincourseTable) {
		this.traincourseTable = traincourseTable;
	}

	public TrainingCourse getSelectedTrainCour() {
		return selectedTrainCour;
	}

	public void setSelectedTrainCour(TrainingCourse selectedTrainCour) {
		this.selectedTrainCour = selectedTrainCour;
	}
}
