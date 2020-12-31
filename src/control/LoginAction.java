package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinessmodel.LoginService;
import bussinessmodel.LoginServiceImpl;

public class LoginAction extends Action{
LoginService ls = new LoginServiceImpl();
@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	String result=ls.checkUser(uname, upass);
	HttpSession session=request.getSession();
	ActionErrors errors = new ActionErrors();
	
	if(result.equals("valid")) {
		session.setAttribute("uname", uname);
		ls.updateFlag(uname, 1);
		return "login.success";
	}
	else if(result.equals("invalid")) {
		
		ActionError error = new ActionError("The passworrd is wrong");
		errors.setErrors(error);
		request.setAttribute("errors", errors);
		System.out.println("Pass wrods wrong..");
		return "login.login";
	}
	else if(result.equals("already")){
		return "login.already";
	}
	else if(result.equals("newuser")) {
		return "login.register";
	}else if(result.equals("valid-admin")) {
		return "login.admin.success";
	}
	return "login.register";
	}

}
