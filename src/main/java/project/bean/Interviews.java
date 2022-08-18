package project.bean;

import java.sql.Date;
import java.sql.Time;

public class Interviews {
	private int Interviews_id;
	private Student studentID;
	private Date Interviews_Date;
	private Time Interviews_Time;

	// Default Constructor
	public Interviews() {
	}

	public Interviews(int interviews_id, Date interviews_Date, Time interviews_Time) {
		Interviews_id = interviews_id;
		Interviews_Date = interviews_Date;
		Interviews_Time = interviews_Time;
	}

	public Interviews(int interviews_id, Student studentID, Date interviews_Date, Time interviews_Time) {
		super();
		Interviews_id = interviews_id;
		this.studentID = studentID;
		Interviews_Date = interviews_Date;
		Interviews_Time = interviews_Time;
	}

	//////// Sets & Gets /////////
	public int getInterviews_id() {
		return Interviews_id;
	}

	public void setInterviews_id(int interviews_id) {
		Interviews_id = interviews_id;
	}

	public Student getStudentID() {
		return studentID;
	}

	public void setStudentID(Student studentID) {
		this.studentID = studentID;
	}

	public Date getInterviews_Date() {
		return Interviews_Date;
	}

	public void setInterviews_Date(Date interviews_Date) {
		Interviews_Date = interviews_Date;
	}

	public Time getInterviews_Time() {
		return Interviews_Time;
	}

	public void setInterviews_Time(Time interviews_Time) {
		Interviews_Time = interviews_Time;
	}

	// To String
	@Override
	public String toString() {
		return "Interviews [Interviews_id=" + Interviews_id + ", studentID=" + studentID + ", Interviews_Date="
				+ Interviews_Date + ", Interviews_Time=" + Interviews_Time + "]";
	}
}
