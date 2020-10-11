package sss.pgs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	public static Connection getDBConnection()
	{
		Connection mysqlcon = null;
			
	   	try 
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {System.out.println(e);}
			
		try 
	    {
	       mysqlcon = DriverManager.getConnection
		    		   ("jdbc:mysql://localhost/jeedgp","root","admin");
			
		} catch (SQLException e) {System.out.println(e);}
		    
		return mysqlcon;
	}
}
