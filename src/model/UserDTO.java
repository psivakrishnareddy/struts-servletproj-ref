package model;


import java.io.Serializable;

public class UserDTO implements Serializable,Comparable<UserDTO>{
	private int uid;
	private String uname;
	private String upass;
	private int flag;
	private int roleid;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		if(this.uid==o.uid) {
			return 0;
		}
		else if(this.uid>o.uid) {
			return 1;
		}
		else {
			return -1;
		}
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag + ", roleid=" + roleid
				+ "]";
	}

	
}

