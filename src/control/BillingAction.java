package control;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinessmodel.BillingService;
import bussinessmodel.BillingServiceImpl;
import model.ItemDTO;

public class BillingAction extends Action{
	BillingService bs = new BillingServiceImpl();
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	
	BillingItems list = (BillingItems) session.getAttribute("selected-items");
	bs.generateBill(list , (String)session.getAttribute("uname"));
//	Iterator<ItemDTO> iter = list.getItemslist().iterator();
//	System.out.println("You bought..");
//	while(iter.hasNext()) {
//		ItemDTO item = iter.next();
//		System.out.println(item.getItemdesc());
//	}
	return "billing.success";
}
}
