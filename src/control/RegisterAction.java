package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinessmodel.LoginService;
import bussinessmodel.LoginServiceImpl;
import bussinessmodel.RegisterationServiceImpl;
import bussinessmodel.RegistrationService;

public class RegisterAction extends Action{
	RegistrationService crs = new RegisterationServiceImpl();
	LoginService ls = new LoginServiceImpl();
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	String ucity = request.getParameter("ucity");
	crs.createCustomer(uname, upass, ucity);
	HttpSession session=request.getSession();
	session.setAttribute("uname",uname);
	ls.updateFlag(uname, 1);
	return "register.success";
	
}
}
