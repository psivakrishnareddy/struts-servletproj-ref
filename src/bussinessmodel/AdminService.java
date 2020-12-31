package bussinessmodel;

import java.sql.Date;

import model.ItemDTO;

public abstract class AdminService {
public abstract void addItemToInventory(String itemno, String name, String price , String unit, String shoopid);
public abstract void deleteitem(int itemno);
public abstract void getReports()throws Exception;
public abstract void getreportsByDate(Date d1, Date d2) throws Exception;
public abstract void getcusreportsByDate(Date d1, Date d2) throws Exception;
}
