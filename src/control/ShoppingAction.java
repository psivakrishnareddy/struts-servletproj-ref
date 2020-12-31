package control;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinessmodel.ItemService;
import bussinessmodel.ItemServiceImpl;
import model.ItemDTO;

public class ShoppingAction extends Action{  
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	ItemService is = new ItemServiceImpl();
	HttpSession session=request.getSession();
	Enumeration<String> e=request.getParameterNames();
	BillingItems items;
	if(session.getAttribute("selected-items")!=null) {
		items = (BillingItems) session.getAttribute("selected-items");
	}else {
		items = new BillingItems();
	}
	while(e.hasMoreElements()) {
		
		String name=(String)e.nextElement();
		String value=(String)request.getParameter(name);
//		System.out.println( name +" yes" + value);
		if(name.equals("formid") || name.equals("shopid"))  {
			continue;
		}
		int itemno = Integer.parseInt(name);
		ItemDTO item = is.getItem(itemno);
	  items.setItemslist(item);
	}
	session.setAttribute("selected-items", items);	
	return request.getParameter("shopid");
}
}