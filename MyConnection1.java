import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection1
{
	Connection con=null;
	public Connection getConnection()
	{
		try
		{		
		//Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		System.out.println("connected\n"+con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
