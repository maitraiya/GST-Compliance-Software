import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Home implements ActionListener{
	
	int id;
	JLabel m1,m2;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JFrame f;
	JPanel p1,p2,p3;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1,stmt;
	public Home()
	{

		f=new JFrame("GST  BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();			
		p2=new JPanel();
		p2.setSize(1400,900);
		p1.setSize(1400,150);
	//	ImagePanel background=new ImagePanel(new ImageIcon("mz.jpg").getImage());
	//	f.add(background);
		f.add(p1);		
		f.add(p2);

		m1=new JLabel("GST ");
		m2=new JLabel("Bill Management");
		b1=new JButton("SIGN IN");
		b2=new JButton("SIGN UP");
		b3=new JButton("SEARCH EMPLOYEE");
		b4=new JButton("DELETE EMPLOYEE");
		b5=new JButton("UPDATE EMPLOYEE");
		b6=new JButton("Stock Audit");
		b7=new JButton("Setup Database(Only have to do this for first time after installation.)");	
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		p1.setBackground(Color.red);			
		p2.setBackground(Color.white);		
		m1.setForeground(Color.white);

		m1.setFont(f2);
		m2.setForeground(Color.white);
		m2.setFont(f2);
		
		b1.setBounds(400,320,500,40);
		b2.setBounds(400,380,500,40);
		b3.setBounds(400,440,500,40);
		b5.setBounds(400,500,500,40);		
		b4.setBounds(400,560,500,40);
		b6.setBounds(400,620,500,40);
		b7.setBounds(400,260,500,40);
		
		m1.setBounds(60,80,400,80);
		m2.setBounds(480,80,400,80);
		p2.add(b4);
		p1.add(m1);
		p1.add(m2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Home h=new Home();
//try{
	//MyConnection m=new MyConnection();
	//	Class.forName("oracle.jdbc.OracleDriver");
	//				}	
	//			catch(Exception ee){
	//				System.out.println("In Main Catch "+ee);	
	//			}

	}
	public void actionPerformed(ActionEvent e)
	{

		try{
		if(e.getSource()==b7)
		{
			MyConnection1 m1=new MyConnection1();
			con=m1.getConnection();			
	 		stmt = con.createStatement();
      		stmt.executeUpdate("CREATE DATABASE gst");
      		System.out.println("Database Created");
			MyConnection m=new MyConnection();
			con=m.getConnection();			      		
      		stmt = con.createStatement();
	     String sql = "create table employee(eid integer primary key AUTO_INCREMENT,ename varchar(20),epass varchar(20),emob long,eadd varchar(40))"; 
	      	stmt.executeUpdate(sql);
	      	System.out.println("Employee table created");
		stmt = con.createStatement();
	      	sql = "create table product(pid integer primary key AUTO_INCREMENT,pname varchar(20),pprice integer,pqty integer,pcat integer)"; 
	      	stmt.executeUpdate(sql);
		stmt = con.createStatement();
	      	sql = "create table bill(pid integer,foreign key(pid) references product(pid),pname varchar(20),pprice integer,pqty integer,pcat integer,primary key(pid))"; 
	      	stmt.executeUpdate(sql);
		stmt = con.createStatement();
	      	sql = "create table stock(pid integer,pname varchar(20),pprice integer,pqty integer,pcat integer,date date)"; 
	      	stmt.executeUpdate(sql);
		stmt = con.createStatement();
	      	sql = "create table maintains(eid int,foreign key(eid) references employee(eid),pid int,foreign key(pid) references product(pid),primary key(eid,pid))"; 
	      	stmt.executeUpdate(sql);

		}
		if(e.getSource()==b1)
		{

			MyConnection m=new MyConnection();
			con=m.getConnection();
      		stmt = con.createStatement();
    	      String sql = "use gst"; 
    	      	stmt.executeUpdate(sql);
    	      	System.out.println("GST opened");

			stat1=con.createStatement();
			Login l=new Login();
			f.dispose();
		}
		if(e.getSource()==b2)
		{
			MyConnection m=new MyConnection();
			con=m.getConnection();
      		stmt = con.createStatement();
    	      String sql = "use gst"; 
    	      	stmt.executeUpdate(sql);
    	      	System.out.println("GST opened");

		//	stat1=con.createStatement();
		//	result1 = stat1.executeQuery("select count(eid) from employee");
		//	result1.next();
		//	String sid=result1.getString(1);
		//	int id=Integer.parseInt(sid);
		//	System.out.println(id);
		//	id=id+1;
			Signup s=new Signup();
			f.dispose();
			
			
		}
		if(e.getSource()==b3)
		{
			MyConnection m=new MyConnection();
			con=m.getConnection();

			stat1=con.createStatement();
			Search sh=new Search();
			f.dispose();
		}
		if(e.getSource()==b4)
		{

			MyConnection m=new MyConnection();
			con=m.getConnection();

			stat1=con.createStatement();
			Delete dl=new Delete();
			f.dispose();
		}
		if(e.getSource()==b5)
		{

			MyConnection m=new MyConnection();
			con=m.getConnection();

			stat1=con.createStatement();
			Update up=new Update();
			f.dispose();
		}
		if(e.getSource()==b6)
		{
			MyConnection m=new MyConnection();
			con=m.getConnection();

			stat1=con.createStatement();
			Audit up=new Audit();
			f.dispose();
		}

	}
	catch(Exception ex){}
	}
}

