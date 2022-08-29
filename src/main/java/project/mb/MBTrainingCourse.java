package project.mb;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;

import project.bean.TrainingCourse;
import project.dao.TrainingCourseDAO;
import project.report.Report;

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

	public String runCourseReport() throws Exception {

		Map<String, Object> parmeter = new HashMap<String, Object>();

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/traincourse.png"));
		parmeter.put("p_image", image);

		Report report = new Report();
		report.runPdf("trainingcourse.jasper", parmeter);
		return null;

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
