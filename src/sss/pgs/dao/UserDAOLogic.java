package sss.pgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sss.pgs.model.UserDetailsInfo;

public class UserDAOLogic 
{

	public boolean userRegistration(UserDetailsInfo uobj)
	{
		boolean f = false;
		Connection con = DBConnect.getDBConnection();
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into userdetailsinfo values(?,?,?,?)");
			
			pst.setString(1, uobj.getUsername());
			pst.setString(2, uobj.getUseremail());
			pst.setString(3, uobj.getUsermobile());
			pst.setString(4, uobj.getUserpassword());
			
			int i = pst.executeUpdate();
			
			if(i > 0)
				f = true;
			
		}catch (SQLException e) {System.out.println(e);}
		return f;
	}
	
	public UserDetailsInfo userLoginCheck(String useremail, String userpassword)
	{
				ResultSet rs = null;
				UserDetailsInfo userobj = null; 
				Connection con = DBConnect.getDBConnection();
				PreparedStatement pst=null;
		try
		{
			 pst = con.prepareStatement	
					 	("select * from userdetailsinfo where useremail = ? and userpassword = ?");
				
			pst.setString(1, useremail);
			pst.setString(2, userpassword);
			
			rs = pst.executeQuery();
			
			if(rs.next())
				userobj = new UserDetailsInfo();
			userobj.setUsername(rs.getString(1));
			userobj.setUseremail(rs.getString(2));
			userobj.setUsermobile(rs.getString(3));
			
			}catch (SQLException e) {System.out.println(e);}
		
			finally 
			{
				try 
					{
						if(pst !=null)
								pst.close();
						if(rs !=null)
								rs.close();
						if(con !=null)
								con.close();
			}		catch (Exception e) {
				
			}
		}
		
		return userobj;

	}
	
}
