package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl extends CustomerDAO{
	Connection con;PreparedStatement ps;ResultSet rs;Statement st;
	@Override
	public void addCustomer(CustomerDTO customer) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into customer_master values (?,?,?)");
			ps.setInt(1, customer.getCustomerid());
			ps.setString(2, customer.getCustomername());
			ps.setString(3, customer.getCustomeraddress());
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
	public void updateCustomer(CustomerDTO customer) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE customer_master SET customername = ?, customeraddress = ? WHERE customerid = ?");
			ps.setString(1, customer.getCustomername());
			ps.setString(2, customer.getCustomeraddress());
			ps.setInt(3, customer.getCustomerid());
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
	public void deleteCustomer(CustomerDTO customer) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM customer_master WHERE customerid = ? or customername = ?");
			ps.setInt(1, customer.getCustomerid());
			ps.setString(2, customer.getCustomername());
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
	public CustomerDTO getCustomerById(int cid) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer_master WHERE customerid = ?");
			
			ps.setInt(1, cid);
		    rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	CustomerDTO obj = new CustomerDTO();
		    	
		    	obj.setCustomerid(rs.getInt("customerid"));
		    	obj.setCustomername(rs.getString("customername"));
		    	obj.setCustomeraddress(rs.getString("customeraddress"));
		    	return obj;
		    }
		} catch (Exception e) {
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
	public List<CustomerDTO> getAllCustomers() {
		try {
			List<CustomerDTO> CustomerList = new ArrayList<CustomerDTO>();
			con = ConnectionUtility.getConnectionUtility().getConnection();
			st = con.createStatement();
			
		    rs = st.executeQuery("select * from customer_master");
		    
		    
		    while(rs.next()) {
		    	CustomerDTO obj = new CustomerDTO();
		    	
		    	obj.setCustomerid(rs.getInt("customerid"));
		    	obj.setCustomername(rs.getString("customername"));
		    	obj.setCustomeraddress(rs.getString("customeraddress"));
		    	CustomerList.add(obj);
		    
		    }
		    return CustomerList;
		} catch (Exception e) {
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
//	CustomerDAOImpl c = new CustomerDAOImpl();
//	CustomerDTO cuss = c.getCustomerById(8);
//	System.out.println(cuss.getCustomername() + cuss.getCustomeraddress());
//	
//}
}
