package bussinessmodel;

import model.CustomerDAO;
import model.CustomerDAOImpl;
import model.CustomerDTO;
import model.UserDAO;
import model.UserDAOImpl;
import model.UserDTO;

public class RegisterationServiceImpl implements RegistrationService {
	UserDAO userdao=new UserDAOImpl();
	CustomerDAO cdao = new CustomerDAOImpl();
	@Override
	public void createCustomer(String uname, String upass , String ucity) {
		UserDTO user = new UserDTO();
		user.setUname(uname);
		user.setUpass(upass);
		user.setFlag(0);
		user.setRoleid(roleid);
		userdao.addUser(user);
		
		UserDTO reguser=userdao.getUserByName(uname);
		CustomerDTO customer = new CustomerDTO();
		customer.setCustomerid(reguser.getUid());
		customer.setCustomername(uname);
		customer.setCustomeraddress(ucity); 
		cdao.addCustomer(customer);
		
	}
}
