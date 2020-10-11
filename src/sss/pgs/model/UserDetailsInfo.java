package sss.pgs.model;

import java.io.Serializable;
//BEAN CLASS
public class UserDetailsInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String username;
	private String useremail;
	private String usermobile;
	private String userpassword;
	
	public UserDetailsInfo()
	{
		
	}

	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getUseremail()
	{
		return useremail;
	}
	
	public void setUseremail(String useremail)
	{
		this.useremail = useremail;
	}
	
	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	
	public String getUserpassword()
	{
		return userpassword;
	}
	
	public void setUserpassword(String userpassword)
	{
		this.userpassword = userpassword;
	}
	
}
