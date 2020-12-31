package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessmodel.AdminService;
import bussinessmodel.AdminServiceImpl;

public class AdminAddItemAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String itemno = (String)request.getParameter("itemno");
	String itemname = (String)request.getParameter("itemname");
	String itemprice = (String)request.getParameter("itemprice");
	String itemunit = (String)request.getParameter("itemunit");
	String shopid = (String)request.getParameter("itemshopid");
	AdminService ads = new AdminServiceImpl();
	ads.addItemToInventory(itemno, itemname, itemprice, itemunit, shopid);

	System.out.println(itemname + itemno + itemunit + itemprice+" " + shopid);
	return "additem.success";
}
}
