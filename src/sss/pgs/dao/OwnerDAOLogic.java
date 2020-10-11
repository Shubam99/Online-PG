package sss.pgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sss.pgs.model.OwnerDetailsInfo;

public class OwnerDAOLogic 
{

	public boolean ownerRegistration(OwnerDetailsInfo oobj) 
	{
		boolean f = false;
		Connection con = DBConnect.getDBConnection();
		try 
		{
			PreparedStatement pst = con.prepareStatement
					         ("insert into ownerdetailsinfo values(?,?,?,?)");
			
			pst.setString(1, oobj.getOwnername());
			pst.setString(2, oobj.getOwneremail());
			pst.setString(3, oobj.getOwnermobile());
			pst.setString(4, oobj.getOwnerpassword());
			
			int i = pst.executeUpdate();
			
			if(i > 0)
				f = true;
		
		} catch (SQLException e) {System.out.println(e);}
		
		return f;
		
	}
	 public OwnerDetailsInfo ownerLoginCheck(String owneremail, String ownerpassword)
	 {

		ResultSet rs = null;
	
		Connection con = DBConnect.getDBConnection();
		OwnerDetailsInfo ownerobj = null;
		
		
		try 
		{
			PreparedStatement pst = con.prepareStatement
		   ("select * from ownerdetailsinfo where owneremail =? and ownerpassword = ?");
			pst.setString(1, owneremail);
			pst.setString(2, ownerpassword);
								
			rs = pst.executeQuery();
				
			if(rs.next()) 
			{
				ownerobj=new OwnerDetailsInfo();
				ownerobj.setOwnername(rs.getString(1));
				ownerobj.setOwneremail(rs.getString(2));
				ownerobj.setOwnermobile(rs.getString(3));
			}
			
			
		} catch (SQLException e) {System.out.println(e);}
		
		return ownerobj;
	 }
	
}

