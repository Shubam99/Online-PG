package sss.pgs.model;

import java.io.Serializable;

public class PGBookingDetailsInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	
	private String username;
	private String useremail;
	private String bookid;
	private String owneremail;
	private String pgname;
	
	public PGBookingDetailsInfo()
	{
		
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getOwneremail() {
		return owneremail;
	}

	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}

	public String getPgname() {
		return pgname;
	}

	public void setPgname(String pgname) {
		this.pgname = pgname;
	}
	
}