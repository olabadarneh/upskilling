package project.mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import project.bean.Student;
import project.dao.StudentDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbRemoveStd")
public class MBRemoveStd {

	private StudentDAO stdDAO;
	private List<Student> stdTable;
	private Student selectedStd;

	@PostConstruct
	public void init() {
		stdDAO = new StudentDAO();
		stdTable = stdDAO.selectAll();
		selectedStd = new Student();

	}

	public String remove() {
		StudentDAO stdDao = new StudentDAO();
		stdDao.delete(selectedStd.getStudentID());
		stdTable = stdDao.selectAll();
		Message.addMessageByKey("INFO", " ", "msg_remove");
		return null;
	}

	//////////////// Getters & Setters ////////////////////
	public List<Student> getStdTable() {
		return stdTable;
	}

	public void setStdTable(List<Student> stdTable) {
		this.stdTable = stdTable;
	}

	public Student getSelectedStd() {
		return selectedStd;
	}

	public void setSelectedStd(Student selectedStd) {
		this.selectedStd = selectedStd;
	}

}
