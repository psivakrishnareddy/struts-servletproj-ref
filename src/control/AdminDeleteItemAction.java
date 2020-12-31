package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessmodel.AdminService;
import bussinessmodel.AdminServiceImpl;

public class AdminDeleteItemAction extends Action{
@Override 
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String itemno = (String) request.getParameter("itemno");
	AdminService ads = new AdminServiceImpl();
	ads.deleteitem(Integer.parseInt(itemno));
	return "deleteitem.success";
}
}
