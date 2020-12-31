package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvoiceDAOImpl extends InvoiceDAO{
	Connection con;PreparedStatement ps;ResultSet rs;Statement st;
@Override
public void addInvoice(int cid, int invno) {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		
//		 ps = con.prepareStatement("insert into invoice_master(customerid , inv_date) values (?, ?)");
		ps = con.prepareStatement("insert into invoice_master values (?,?, ? , ?)");
	    ps.setInt(1, invno);
		ps.setInt(2, cid);
		ps.setDate(3, Date.valueOf(LocalDate.now()));
		ps.setFloat(4, 0);
		ps.execute();
		con.commit();

	
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	
}
@Override
public void updateInvoice(int invno , float amt) {
	try {
		con = ConnectionUtility.getConnectionUtility().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE invoice_master SET ammount=? where invno =?");
        
        ps.setFloat(1, amt);
        ps.setInt(2, invno);
		ps.execute();
		con.commit();
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	
}
@Override
public int getNextInvno() {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		
//	    ps = con.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?");
////		ps.execute();
		st = con.createStatement();
	    
	    
	    rs = st.executeQuery("SELECT count(*) from invoice_master" );
		if(rs.next()) {
			return rs.getInt(1);
		}

	
	}catch(Exception e) {
		try {
		con.rollback();
		
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	return 0;
}
@Override
public InvoiceDTO getInvoiceById(int id) {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		
		 ps = con.prepareStatement("select * from invoice_master where invno = ?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if(rs.next()) {
			InvoiceDTO obj = new InvoiceDTO();
			obj.setInvno(rs.getInt("invno"));
			obj.setCustomerid(rs.getInt("customerid"));
			obj.setInv_date(rs.getDate("inv_date"));
			obj.setAmmount(rs.getFloat("ammount"));
			return obj;
		}
		con.commit();

	
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	return null;
}


@Override
public List<ReportInvoice> getReportInvoices() {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from invoice_master as inv inner join customer_master as c where inv.customerid = c.customerid order by inv.ammount desc");
		List<ReportInvoice> reports = new ArrayList<ReportInvoice>();
		while(rs.next()) {
		ReportInvoice report = new ReportInvoice();
		report.setInvno(rs.getInt("invno"));
		report.setCustomerid(rs.getInt("customerid"));
		report.setInv_date(rs.getDate("inv_date"));
		report.setAmmount(rs.getFloat("ammount"));
		report.setCustomername(rs.getString("customername"));
		report.setCustomercity(rs.getString("customeraddress"));
		reports.add(report);
		}
		return reports;
		

	
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	return null;
}

@Override
public List<ReportInvoice> getReportInvoicesByDates(Date d1, Date d2) {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		ps = con.prepareStatement("select * from invoice_master as i inner join customer_master as c where c.customerid = i.customerid and (i.inv_date between ? and ?) order by i.ammount desc");
		ps.setDate(1, d1);
		ps.setDate(2, d2);
		rs = ps.executeQuery();
		List<ReportInvoice> reports = new ArrayList<ReportInvoice>();
		while(rs.next()) {
		ReportInvoice report = new ReportInvoice();
		report.setInvno(rs.getInt("invno"));
		report.setCustomerid(rs.getInt("customerid"));
		report.setInv_date(rs.getDate("inv_date"));
		report.setAmmount(rs.getFloat("ammount"));
		report.setCustomername(rs.getString("customername"));
		report.setCustomercity(rs.getString("customeraddress"));
		reports.add(report);
		}
		return reports;
		

	
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	return null;
}

@Override
public List<ReportInvoice> getCReportsInvoicesByDates(Date d1, Date d2) {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		ps = con.prepareStatement("select i.customerid,c.customername,c.customeraddress, sum(ammount) as ammount  from invoice_master as i inner join customer_master as c on c.customerid = i.customerid where (i.inv_date between ? and ?) group by c.customerid order by i.ammount desc");
		ps.setDate(1, d1);
		ps.setDate(2, d2);
		rs = ps.executeQuery();
		List<ReportInvoice> reports = new ArrayList<ReportInvoice>();
		while(rs.next()) {
		ReportInvoice report = new ReportInvoice();
//		report.setInvno(rs.getInt("invno"));
		report.setCustomerid(rs.getInt("customerid"));
//		report.setInv_date(rs.getDate("inv_date"));
		report.setAmmount(rs.getFloat("ammount"));
		report.setCustomername(rs.getString("customername"));
		report.setCustomercity(rs.getString("customeraddress"));
		reports.add(report);
		}
		return reports;
		

	
	}catch(Exception e) {
		try {
		con.rollback();
		ps.close();
		ConnectionUtility.getConnectionUtility().killConnection(con);			
		}catch(Exception e2) {e2.printStackTrace();}
		e.printStackTrace();
		
	}
	return null;
}
//public static void main(String[] args) {
//	InvoiceDAOImpl i = new InvoiceDAOImpl();
//	i.addInvoice(8 , 100);
//	i.updateInvoice(100, 340);
//	System.out.println(i.getNextInvno());
//	List<ReportInvoice> list = new ArrayList<ReportInvoice>();
//	list = i.getReportInvoices();
//	Iterator<ReportInvoice> iter = list.iterator();
//	while(iter.hasNext()) {
//		System.out.println(iter.next().getInvno());
//	}
//}

// select sum(ammount) , i.customerid from invoice_master as i inner join customer_master as c on c.customerid = i.customerid where (i.inv_date between '2020-11-26' and '2020-11-27') group by c.customerid order by i.ammount desc ;
//select * from invoice_master as i inner join customer_master as c where c.customerid = i.customerid and (i.inv_date between '2020-11-26' and '2020-11-27');
}
