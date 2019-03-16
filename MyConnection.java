import java.sql.*;
public class MyConnection 
{
	Connection con=null;
	public Connection getConnection()
	{
		try
		{		
		//Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
		System.out.println("connected\n"+con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
