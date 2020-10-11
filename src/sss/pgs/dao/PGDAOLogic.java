package sss.pgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sss.pgs.model.PGDetailsInfo;

public class PGDAOLogic 
{
	public boolean pgAddition(PGDetailsInfo pgobj)
	{
		boolean f = false;
		Connection con = DBConnect.getDBConnection();
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into pgdetailsinfo values (?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, pgobj.getPGName());
			pst.setString(2, pgobj.getPGState());
			pst.setString(3, pgobj.getPGDistrict());
			pst.setString(4, pgobj.getPGLocation());
			pst.setString(5, pgobj.getPGLandmark());
			pst.setString(6, pgobj.getPGAddress());
			pst.setLong(7, pgobj.getPGDisPin());
			pst.setString(8, pgobj.getPGType());
			pst.setString(9, pgobj.getPGTypac());
			pst.setInt(10, pgobj.getPGCost());
			pst.setInt(11, pgobj.getPGCapacity());
			pst.setString(12, pgobj.getOwnerEmail());
			
			int i = pst.executeUpdate();
			
			if(i > 0)
				f = true;
			
		}catch(SQLException e)	{System.out.println(e);}
		return f;
	}
	public ArrayList<PGDetailsInfo> fetchAllPGRecord(String owneremail)
	{
		ArrayList<PGDetailsInfo> pglist = new ArrayList<PGDetailsInfo>();
		ResultSet rs = null;
		
		Connection con = DBConnect.getDBConnection();
		
		try
		{
			PreparedStatement pst = con.prepareStatement("select * from pgdetailsinfo where OwnerEmail = ?");
			pst.setString(1, owneremail);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				//CREATE BEAN CLASS OBJECT
				PGDetailsInfo pgobj = new PGDetailsInfo();
				//FROM A RECORD FETCH ALL DATA AND STORE IT WITHIN OBJECT
				pgobj.setPGName(rs.getString(1));
				pgobj.setPGState(rs.getString(2));
				pgobj.setPGDistrict(rs.getString(3));
				pgobj.setPGLocation(rs.getString(4));
				pgobj.setPGLandmark(rs.getString(5));
				pgobj.setPGAddress(rs.getString(6));
				pgobj.setPGDisPin(rs.getInt(7));
				pgobj.setPGType(rs.getString(8));
				pgobj.setPGTypac(rs.getString(9));
				pgobj.setPGCost(rs.getInt(10));
				pgobj.setPGCapacity(rs.getInt(11));
				//ADD OBJECT INTO ARRAYLIST
				pglist.add(pgobj);
				
			}
		} catch (SQLException e)	{System.out.println(e);}
		
		return pglist;
	}
	 public boolean PGDelByOwner(String pgname)
		{
			boolean f = false;
			Connection con = DBConnect.getDBConnection();
		try 
			{
				PreparedStatement pst = con.prepareStatement
					         ("delete from pgdetailsinfo where pgname = ?");
				pst.setString(1, pgname);
					
				int i = pst.executeUpdate();
			
				if(i > 0)
					f = true;
			
			} catch (SQLException e) {System.out.println(e);}
		return f;
		}
	 public ArrayList<PGDetailsInfo> searchPGRecordUser(String pgstate,String pgdistrict,String pglocation) 
		{
			ArrayList<PGDetailsInfo> pglist = new ArrayList<PGDetailsInfo>();
			ResultSet rs = null;
			
			Connection con = DBConnect.getDBConnection();
			
			try
			{
				PreparedStatement pst = con.prepareStatement("select * from pgdetailsinfo where pgstate = ? and pgdistrict = ? and pglocation = ?");
				pst.setString(1, pgstate);
				pst.setString(2, pgdistrict);
				pst.setString(3, pglocation);
				rs = pst.executeQuery();
				
				while(rs.next())
				{
					//CREATE BEAN CLASS OBJECT
					PGDetailsInfo pgobj = new PGDetailsInfo();
					//FROM A RECORD FETCH ALL DATA AND STORE IT WITHIN OBJECT
					pgobj.setPGName(rs.getString(1));
					pgobj.setPGState(rs.getString(2));
					pgobj.setPGDistrict(rs.getString(3));
					pgobj.setPGLocation(rs.getString(4));
					pgobj.setPGLandmark(rs.getString(5));
					pgobj.setPGAddress(rs.getString(6));
					pgobj.setPGDisPin(rs.getInt(7));
					pgobj.setPGType(rs.getString(8));
					pgobj.setPGTypac(rs.getString(9));
					pgobj.setPGCost(rs.getInt(10));
					pgobj.setPGCapacity(rs.getInt(11));
					pgobj.setOwnerEmail(rs.getString(12));
					//ADD OBJECT INTO ARRAYLIST
					pglist.add(pgobj);
					
				}
			} catch (SQLException e)	{System.out.println(e);}
			
			return pglist;
		}
}
