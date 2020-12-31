package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionController extends HttpServlet {
	RequestProcessor rp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
		ServletContext application=config.getServletContext();
		String path=application.getRealPath("/WEB-INF/config.properties");
		Properties prop=new Properties();
		prop.load(new FileInputStream(path));
		rp=new RequestProcessor(prop);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.process(request, response);
	}

}
