package bussinessmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

import model.InvoiceDAO;
import model.InvoiceDAOImpl;
import model.ItemDAO;
import model.ItemDAOImpl;
import model.ItemDTO;

public class AdminServiceImpl extends AdminService   {
	ItemDAO idao = new ItemDAOImpl();
	
@Override
public void addItemToInventory(String itemno, String name, String price , String unit, String shoopid) {
	ItemDTO item = new ItemDTO();
	item.setItemno(Integer.parseInt(itemno));
	item.setItemdesc(name);
	item.setUnit(unit);
	item.setPrice(Float.parseFloat(price));
	item.setShopid(Integer.parseInt(shoopid));
	System.out.println(item.getPrice());
	idao.addItem(item);
	System.out.println("item added to store,");
}
@Override
public void deleteitem(int itemno) {
	ItemDTO item = new ItemDTO();
	item.setItemno(itemno);
	idao.deleteItem(item);
	System.out.println("item Deleted from inventory");
}
@Override
public void getReports() throws Exception {
   InvoiceDAO indao = new InvoiceDAOImpl();
//   ReportsGenerator rpg = new ReportsGenerator();
   ReportsGenerator.createExcel(indao.getReportInvoices());
	
}
@Override
public void getreportsByDate(Date d1, Date d2) throws Exception {
	// TODO Auto-generated method stub
	 InvoiceDAO indao = new InvoiceDAOImpl();
//   ReportsGenerator rpg = new ReportsGenerator();
   ReportsGenerator.createExcel(indao.getReportInvoicesByDates(d1, d2));
   CReportGenerator.createExcel(indao.getCReportsInvoicesByDates(d1, d2));
}

@Override
public void getcusreportsByDate(Date d1, Date d2) throws Exception {
	// TODO Auto-generated method stub
	 InvoiceDAO indao = new InvoiceDAOImpl();
//   ReportsGenerator rpg = new ReportsGenerator();
   CReportGenerator.createExcel(indao.getCReportsInvoicesByDates(d1, d2));
}


//public static void main(String[] args)throws Exception  {
//	AdminServiceImpl ad = new AdminServiceImpl();
//	ad.getReports();
//}
}
