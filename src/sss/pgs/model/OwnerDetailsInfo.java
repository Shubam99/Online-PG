package sss.pgs.model;

import java.io.Serializable;

public class OwnerDetailsInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String ownername;
	private String owneremail;
	private String ownermobile;
	private String ownerpassword;
	
	public OwnerDetailsInfo()
	{
		
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwneremail() {
		return owneremail;
	}
	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}
	public String getOwnermobile() {
		return ownermobile;
	}
	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}
	public String getOwnerpassword() {
		return ownerpassword;
	}
	public void setOwnerpassword(String ownerpassword) {
		this.ownerpassword = ownerpassword;
	}
	

}
