package bussinessmodel;

public interface LoginService {
	public String checkUser(String uname,String upass);
	public String checkFlag(String uname);
	public void updateFlag(String uname,int flag);
}

