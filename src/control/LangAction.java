package control;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String lang = request.getParameter("language");
		Locale locale = new Locale(lang);
		ResourceBundle rb = ResourceBundle.getBundle("control.Dictionary",locale);
		HttpSession session = request.getSession();
		session.setAttribute("rb", rb);
		return "lang.success";
	}
}
