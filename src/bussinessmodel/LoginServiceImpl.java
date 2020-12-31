package bussinessmodel;

import model.UserDAO;
import model.UserDAOImpl;
import model.UserDTO;

public class LoginServiceImpl implements LoginService {
	UserDAO userdao=new UserDAOImpl();
	@Override
	public String checkUser(String uname, String upass) {
		UserDTO user=userdao.getUserByName(uname);
		System.out.println("User iobj" + user);
		if(user!=null) {
			if(user.getFlag()==1) {
				return "already";
			}		
		if(upass.equals(user.getUpass())) {
				if(user.getRoleid() == 1) {
					return "valid-admin";
				}else {
					
					return "valid";
				}
			}
			else
			{
				return "invalid";
			}
		}else {
			System.out.println("New user..");
			return "newuser";
		}
	}

	@Override
	public String checkFlag(String uname) {
		UserDTO user=userdao.getUserByName(uname);
		if(user!=null) {
			int flag=user.getFlag();
			if(flag==1) {
				return "loggedin";
			}
			else {
				return "notloggedin";
			}
		}
		else {
			return "invaliduser";
		}
	}

	@Override
	public void updateFlag(String uname, int flag) {
		// TODO Auto-generated method stub
		UserDTO user=userdao.getUserByName(uname);
		if(user!=null) {
			user.setFlag(flag);
			userdao.updateUser(user);
		}
		
	}

}
