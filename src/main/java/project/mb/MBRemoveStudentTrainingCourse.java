package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Student;
import project.bean.StudentTrainingCourse;
import project.dao.StudentDAO;
import project.dao.StudentTrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbRemoveSTR")
public class MBRemoveStudentTrainingCourse {
	private StudentTrainingCourseDAO strDAO;
	private StudentTrainingCourse selectedStr;
	private List<StudentTrainingCourse> strTable;
	private Student std;
	private List<Student> stdTabl;

	@PostConstruct
	public void init() {
		strDAO = new StudentTrainingCourseDAO();
		strTable = strDAO.selectAll();
		selectedStr = new StudentTrainingCourse();

		StudentDAO stdDAO = new StudentDAO();
		stdTabl = stdDAO.selectAll();
		std = new Student();
	}

	public String remove() {
		strDAO = new StudentTrainingCourseDAO();
		strDAO.delete(getStd().getStudentID());
		strTable = strDAO.selectAll();
		selectedStr = new StudentTrainingCourse();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}

	///////////////// Getters & Setters //////////////////
	public StudentTrainingCourse getSelectedStr() {
		return selectedStr;
	}

	public void setSelectedStr(StudentTrainingCourse selectedStr) {
		this.selectedStr = selectedStr;
	}

	public List<StudentTrainingCourse> getStrTable() {
		return strTable;
	}

	public void setStrTable(List<StudentTrainingCourse> strTable) {
		this.strTable = strTable;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public List<Student> getStdTabl() {
		return stdTabl;
	}

	public void setStdTabl(List<Student> stdTabl) {
		this.stdTabl = stdTabl;
	}
}
