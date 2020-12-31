package control;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessmodel.AdminService;
import bussinessmodel.AdminServiceImpl;

public class ReportGenAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String from = request.getParameter("fromdate");
	String to = request.getParameter("todate");
	AdminService ads = new AdminServiceImpl();
	Date d1 = Date.valueOf(from);
	Date d2 = Date.valueOf(to);
	try {
		ads.getreportsByDate(d1, d2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return "report.success";
}
}
