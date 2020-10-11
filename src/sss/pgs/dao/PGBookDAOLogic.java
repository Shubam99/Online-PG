package sss.pgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sss.pgs.model.PGBookingDetailsInfo;



public class PGBookDAOLogic 
{
	public boolean pgBooking(PGBookingDetailsInfo pgbobj)
	{
		boolean f = false;
		Connection con = DBConnect.getDBConnection();
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into pgbookingdetailsinfo values (?,?,?,?,?)");
			
			pst.setString(1, pgbobj.getUsername());
			pst.setString(2,pgbobj.getUseremail());
			pst.setString(3, pgbobj.getBookid());
			pst.setString(4, pgbobj.getOwneremail());
			pst.setString(5, pgbobj.getPgname());
			
			int i = pst.executeUpdate();
			
			if(i > 0)
				f = true;
			
		}catch(SQLException e)	{System.out.println(e);}
		return f;
		}
	public ArrayList<PGBookingDetailsInfo> fetchAllPGBookRecord(String useremail)
	{
		ArrayList<PGBookingDetailsInfo> pgblist = new ArrayList<PGBookingDetailsInfo>();
		ResultSet rs = null;
		
		Connection con = DBConnect.getDBConnection();
		
		try
		{
			PreparedStatement pst = con.prepareStatement("select * from pgbookingdetailsinfo where useremail = ?");
			pst.setString(1, useremail);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				//CREATE BEAN CLASS OBJECT
				PGBookingDetailsInfo pgbobj = new PGBookingDetailsInfo();
				//FROM A RECORD FETCH ALL DATA AND STORE IT WITHIN OBJECT
				pgbobj.setUsername(rs.getString(1));
				pgbobj.setUseremail(rs.getString(2));
				pgbobj.setBookid(rs.getString(3));
				pgbobj.setOwneremail(rs.getString(4));
				pgbobj.setPgname(rs.getString(5));
				pgblist.add(pgbobj);
				
			}
		} catch (SQLException e)	{System.out.println(e);}
		
		return pgblist;
	}
	
	 public boolean cancelBookingByUser(String bookid)
		{
			boolean f = false;
			Connection con = DBConnect.getDBConnection();
		try 
			{
				PreparedStatement pst = con.prepareStatement
					         ("delete from pgbookingdetailsinfo where bookid = ?");
				pst.setString(1, bookid);
					
				int i = pst.executeUpdate();
			
				if(i > 0)
					f = true;
			
			} catch (SQLException e) {System.out.println(e);}
		return f;
		}
}
