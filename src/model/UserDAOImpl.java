package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl  extends UserDAO{
	Connection con;PreparedStatement ps;ResultSet rs;Statement st;
	@Override
	public int addUser(UserDTO user) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			ps=con.prepareStatement("insert into users(uname , upass, flag , roleid) values (?,?,?, ?)");
//			ps.setInt(1, null);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());
			ps.setInt(3, user.getFlag());
			ps.setInt(4, user.getRoleid());
			int update=ps.executeUpdate();
			con.commit();
			return update;
		}catch(Exception e) {
			try {
			con.rollback();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateUser(UserDTO user) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			ps=con.prepareStatement("update users set uname=?, upass=?, flag=? where uid=?");
			
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());
			ps.setInt(3, user.getFlag());
			ps.setInt(4, user.getUid());
			int update=ps.executeUpdate();
			con.commit();
			return update;
		}catch(Exception e) {
			try {
			con.rollback();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteUser(UserDTO user) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			ps=con.prepareStatement("delete from users where uid=? or uname=?");
			ps.setInt(1, user.getUid());
			ps.setString(2, user.getUname());
			
			int update=ps.executeUpdate();
			con.commit();
			return update;
		}catch(Exception e) {
			try {
			con.rollback();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public UserDTO getUser(int uid) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			ps=con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			UserDTO userdto=new UserDTO();
			if(rs.next()) {
				userdto.setUid(uid);
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				return userdto;
			}
		
			
		}catch(Exception e) {
			try {
			con.rollback();
			rs.close();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		try {
			List<UserDTO> listdto=new ArrayList<UserDTO>();
			con=ConnectionUtility.getConnectionUtility().getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from users");
			
			while(rs.next()) {
				UserDTO userdto=new UserDTO();
				userdto.setUid(rs.getInt(1));
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				listdto.add(userdto);
			}
			return listdto;
			
		}catch(Exception e) {
			try {
			con.rollback();
			rs.close();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserDTO getUserByName(String uname) {
		try {
			con=ConnectionUtility.getConnectionUtility().getConnection();
			ps=con.prepareStatement("select * from users where uname=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			UserDTO userdto=new UserDTO();
			if(rs.next()) {
				userdto.setUid(rs.getInt("uid"));
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setRoleid(rs.getInt("roleid"));
				return userdto;
			}
		
			
		}catch(Exception e) {
			try {
			con.rollback();
			rs.close();
			ps.close();
			ConnectionUtility.getConnectionUtility().killConnection(con);			
			}catch(Exception e2) {e2.printStackTrace();}
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		UserDAOImpl obj=new UserDAOImpl();
//		UserDTO userdto=new UserDTO();
//		userdto.setUid(3);
////		userdto.setUname("maheshmahi");
////		userdto.setUpass("spidi");
////		userdto.setFlag(1);
////		int u=obj.addUser(userdto);
////		int u=obj.updateUser(userdto);
////		int u=obj.deleteUser(userdto);
////		System.out.println("Records updated..:"+u);
//		List<UserDTO> user=obj.getAllUsers();
//		System.out.println(user);
//	}
//public static void main(String[] args) {
//	UserDAOImpl u  = new UserDAOImpl();
//	UserDTO user = u.getUserByName("admin");
//	System.out.println(user);
//	
//}
}
