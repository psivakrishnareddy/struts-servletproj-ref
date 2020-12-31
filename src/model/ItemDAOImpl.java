package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl extends ItemDAO{
	Connection con;PreparedStatement ps;ResultSet rs;Statement st;
	@Override
	public void addItem(ItemDTO item) {
		try {
	    	
			con = ConnectionUtility.getConnectionUtility().getConnection();
			ps = con.prepareStatement("insert into item_master values (?,?,?, ? , ?)");
	        ps.setInt(1, item.getItemno());
	        ps.setString(2, item.getItemdesc());
	        ps.setString(3, item.getUnit());
	        ps.setFloat(4, item.getPrice());
	        ps.setInt(5, item.getShopid());
			ps.execute();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
				con.commit();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateItem(ItemDTO item) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE item_master SET itemdesc = ? ,unit=?, price=?, shopid=? WHERE itemno=?");
	        
	        ps.setString(1, item.getItemdesc());
	        ps.setString(2, item.getUnit());
	        ps.setFloat(3, item.getPrice());
	        ps.setInt(4, item.getItemno());
	        ps.setInt(5, item.getShopid());
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
	public void deleteItem(ItemDTO item) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM item_master WHERE itemno = ?");
			ps.setInt(1, item.getItemno());
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
	public ItemDTO getItem(int itemno) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM item_master WHERE itemno = ?");
		    ps.setInt(1,itemno);
		    rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	ItemDTO obj = new ItemDTO();
		    	obj.setItemno(rs.getInt("itemno"));
		    	obj.setItemdesc(rs.getString("itemdesc"));
		    	obj.setUnit(rs.getString("unit"));
		    	obj.setPrice(rs.getFloat("prize"));
		    	obj.setShopid(rs.getInt("shopid"));
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
	public List<ItemDTO> getAllItems() {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
		 st = con.createStatement();
		    
		    rs = st.executeQuery("SELECT * FROM item_master");
		    List<ItemDTO> itemslist = new ArrayList<ItemDTO>();
		    
		    while(rs.next()) {
		    	ItemDTO obj = new ItemDTO();
		    	obj.setItemno(rs.getInt("itemno"));
		    	obj.setItemdesc(rs.getString("itemdesc"));
		    	obj.setUnit(rs.getString("unit"));
		    	obj.setPrice(rs.getFloat("prize"));
		    	obj.setShopid(rs.getInt("shopid"));
		    	itemslist.add(obj);
		    }
		    return itemslist;
		    
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
	public List<ItemDTO> getItemByShop(int shopid) {
		try {
			con = ConnectionUtility.getConnectionUtility().getConnection();
			ps = con.prepareStatement("SELECT * FROM Item_master where shopid= ?");
			ps.setInt(1, shopid);
			 rs = ps.executeQuery();
			    List<ItemDTO> itemslist = new ArrayList<ItemDTO>();
			    
			    while(rs.next()) {
			    	ItemDTO obj = new ItemDTO();
			    	obj.setItemno(rs.getInt("itemno"));
			    	obj.setItemdesc(rs.getString("itemdesc"));
			    	obj.setUnit(rs.getString("unit"));
			    	obj.setPrice(rs.getFloat("prize"));
			    	obj.setShopid(rs.getInt("shopid"));
			    	itemslist.add(obj);
			    }
			    return itemslist;
		    
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

}
