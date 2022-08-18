package project.mb;

import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;

@ManagedBean(name = "mbTrainCourse")
public class MBTrainingCourse {

	private TrainingCourseDAO trainCourseDAO;
	private List<TrainingCourse> trainCourseTable;
	private TrainingCourse selectedTrainCourse;
	private List<TrainingCourse> filtered;

	@PostConstruct
	public void init() {
		trainCourseDAO = new TrainingCourseDAO();
		trainCourseTable = trainCourseDAO.selectAll();
		selectedTrainCourse = new TrainingCourse();
	}

	public boolean filter(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}
		return filter(filtered, "", locale);
	}

	/////// Getters & Setters ///////

	public List<TrainingCourse> getTrainCourseTable() {
		return trainCourseTable;
	}

	public void setTrainCourseTable(List<TrainingCourse> trainCourseTable) {
		this.trainCourseTable = trainCourseTable;
	}

	public TrainingCourse getSelectedTrainCourse() {
		return selectedTrainCourse;
	}

	public void setSelectedTrainCourse(TrainingCourse selectedTrainCourse) {
		this.selectedTrainCourse = selectedTrainCourse;
	}

	public List<TrainingCourse> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<TrainingCourse> filtered) {
		this.filtered = filtered;
	}
}
