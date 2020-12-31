package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinessmodel.LoginService;
import bussinessmodel.LoginServiceImpl;

public class LogoutAction extends Action{
	LoginService ls=new LoginServiceImpl();

@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session=request.getSession();
	String uname=(String)session.getAttribute("uname");
	ls.updateFlag(uname, 0);
//	session.invalidate();
	return "logout.success";
}
}
