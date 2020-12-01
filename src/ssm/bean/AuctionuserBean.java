package ssm.bean;

public class AuctionuserBean {

	
	private int userid;
	private String  username;
	private String  userpassword;
	private int  userisadmin;
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public String getUserpassword() {
		return userpassword;
	}
	
	public void setUserisadmin(int userisadmin) {
		this.userisadmin = userisadmin;
	}
	
	public int getUserisadmin() {
		return userisadmin;
	}

}
