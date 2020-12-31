package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class InvoiceTransactionDAOImpl extends InvoiceTransactionDAO {
	Connection con;PreparedStatement ps;ResultSet rs;Statement st;
@Override
public void addinvItem(InvoiceTransactionDTO inv) {
	try {
		con=ConnectionUtility.getConnectionUtility().getConnection();
		
ps = con.prepareStatement("insert into inv_transaction values(? , ? , ?)");
		ps.setInt(1, inv.getInvno());
		ps.setInt(2, inv.getItemno());
		ps.setInt(3, inv.getQty());
	
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
}
