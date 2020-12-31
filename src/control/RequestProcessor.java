package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
	Properties prop;
	public RequestProcessor(Properties prop) {
		// TODO Auto-generated constructor stub
		this.prop = prop;
	}
	public void process(HttpServletRequest request,HttpServletResponse response) {
		try {
			String formid = request.getParameter("formid");
			String actionclass = prop.getProperty(formid);
			Action action=(Action)Class.forName(actionclass).newInstance();
			String result=action.execute(request, response);
			String nextpage=prop.getProperty(result);
			RequestDispatcher rd=request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
