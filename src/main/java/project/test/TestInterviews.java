package project.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.bean.Interviews;
import project.dao.InterviewsDAO;

public class TestInterviews {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("E , MMM-dd-yyyy");
		Date now = new Date();
		System.out.println(sdf.format(now));
		List<Interviews> interviewsTable = new ArrayList<Interviews>();
		InterviewsDAO interviewsDAO = new InterviewsDAO();

		//////////////////////////////////////////////////////////////////
		// selectTable
		interviewsTable = interviewsDAO.sellectAll();
		System.out.println(interviewsTable);
	}

}
