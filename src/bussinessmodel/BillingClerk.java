package bussinessmodel;



public class BillingClerk extends User {
	LoginService ls=new LoginServiceImpl();
	@Override
	public String login(String uname, String upass) {
		String result=ls.checkUser(uname, upass);
		if(result.equals("valid")) {
			ls.updateFlag(uname, 1);
			return "success";
		}
		else if(result.equals("newuser")) {
			return "registerpage";
		}
		else {
			return "alreadylogedinpage";
		}
	}

	@Override
	public String logout(String uname) {
		System.out.println("Loggin ouut");
		
		ls.updateFlag(uname, 0);
		return "logoutsuccess";
	}

}
