package bussinessmodel;

public abstract class User {
	public abstract String login(String uname,String upass);
	public abstract String logout(String uname);
}