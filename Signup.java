import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Signup implements ActionListener,MouseListener{
	

	JLabel l1;
	JButton b1,b2,b3;
	JTextField tf1,tf0,tf3;
	JTextArea tf4;
	JPasswordField tf2;
	JFrame f;
	JPanel p1,p2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1;
int n;

	public Signup()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();					
		p2=new JPanel();
		p1.setSize(1400,100);
		p2.setSize(1400,900);
		f.add(p1);		
		f.add(p2);
		l1=new JLabel("SIGN UP");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(10);
		tf4=new JTextArea(5,10);
		tf2=new JPasswordField(20);
		b1=new JButton("SIGN UP");
		b2=new JButton("Clear");
		b3=new JButton("Home");

		p1.setBackground(Color.red);			
		p2.setBackground(Color.white);		
		Font f2=new Font("chiller",Font.BOLD,48);

		p1.add(l1);
		l1.setForeground(Color.white);
		l1.setFont(f2);		
		p2.add(tf0);
//		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		p2.setLayout(null);
		l1.setBounds(60,80,400,80);
		
		tf0.setBounds(100,200,1000,60);
//		tf1.setBounds(100,260,800,50);
		tf2.setBounds(100,270,1000,60);
		tf3.setBounds(100,340,1000,60);
		tf4.setBounds(100,410,1000,100);
		b1.setBounds(100,520,500,40);
		b2.setBounds(400,620,400,40);
		b3.setBounds(600,520,500,40);
						
						
		tf1.setText("Employee id");
		//tf1.setEditable(false);
		tf1.setToolTipText("Employee id");
		tf0.setToolTipText("Name");
		tf2.setToolTipText("Password");
		tf3.setToolTipText("Employee Contact no");
		tf4.setToolTipText("Employee Address");
		tf2.setText("Password");
		tf0.setText("Employee Name");
		tf3.setText("Employee Contact no.");
		tf4.setText("Employee Address");
		
		tf0.setForeground(Color.gray);
		tf1.setForeground(Color.gray);
		tf2.setForeground(Color.gray);
		tf3.setForeground(Color.gray);
		tf4.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf0.addMouseListener(this);
		tf1.addMouseListener(this);
		tf2.addMouseListener(this);
		tf3.addMouseListener(this);
		tf4.addMouseListener(this);

		MyConnection m=new MyConnection();
		con=m.getConnection();
	try{
		stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		result1 = stat1.executeQuery("select * from employee");
		}
		catch(Exception ex1){}
						
	}
	
	public static void main(String[] args) {
		Signup s=new Signup();
	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String nmchk=tf0.getText();
			String echk=tf1.getText();
			String passchk=tf2.getText();
			String mobchk=tf3.getText();
			String addchk=tf4.getText();
			System.out.println(mobchk.length());
			if(!nmchk.equals("") &&/* echk.equals("") && */!passchk.equals("") && !mobchk.equals("")  && !addchk.equals("") && !nmchk.equals("Employee Name") &&/* echk.equals("Employee id") &&*/ !passchk.equals("Password") && !mobchk.equals("Employee Contact no.") && !addchk.equals("Employee Address") )
			{			
								
				if(!Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
					JOptionPane.showMessageDialog(null,new String("Enter Alphabets For Employee Name "));
				}	
				else if(Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
			//			if(Pattern.matches("^[0-9]+$",tf1.getText())){
							if(mobchk.length()==10){
							if(Pattern.matches("^[0-9]+$",tf3.getText())){
					try
					{
										//stat1=con.createStatement();
					stat=con.prepareStatement("insert into employee(ename,epass,emob,eadd) values(?,?,?,?)");	
					stat.setString(1,tf0.getText());
											
				//	stat.setInt(2,Integer.parseInt(tf1.getText()));
					stat.setString(2,tf2.getText());
					stat.setLong(3,Long.parseLong(tf3.getText()));
					stat.setString(4,tf4.getText());
					int i=stat.executeUpdate();//DML
					if(i>=1)
					{
						System.out.println("Record  Saved.....");
			/*			result1 = stat1.executeQuery("select count(eid) from employee");
						result1.next();
						String eids=result1.getString(1);
						int eid=Integer.parseInt(eids);
						eid=eid+1;
						tf1.setText(""+eid);
			*/			stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
						result1 = stat1.executeQuery("select max(eid) from employee");
					//	result1.executeQuery();
						result1.next();
						int z=result1.getInt(1);					
						System.out.println(z);	
				        	JOptionPane.showMessageDialog(null, new String("Your Employee ID is "+z));

					}
					else
						System.out.println("Unable to save record.....");
				JOptionPane.showMessageDialog(null,new String("Record Save Successfully..."));				
					
					
					}
					catch(Exception ex1)
					{
						System.out.println(ex1);
						JOptionPane.showMessageDialog(null, new String("Cannot insert Duplicate value for employee id "));
					}
					}
					else
						JOptionPane.showMessageDialog(null, new String("Enter Numerical values in Contact field "));
					}
							else
							JOptionPane.showMessageDialog(null, new String("Contact no. not in limit "));
			//		}
			//		else
			//			JOptionPane.showMessageDialog(null, new String("Insert Numeric Values for Employee Id "));
				}
				else
					JOptionPane.showMessageDialog(null, new String("Please Enter Alphabets for Name "));
			}
				
			else
			{
				JOptionPane.showMessageDialog(null, new String("Please Enter All The Required Valid Credentials"));
			}
		}
		if(e.getSource()==b2)
		{
			
		//	tf1.setText(""+id);
			tf2.setText("Password");
			tf0.setText("Employee Name");
			tf3.setText("Employee Contact no.");
			tf4.setText("Employee Address");
			tf0.setForeground(Color.gray);
		//	tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			MyConnection m=new MyConnection();
			con=m.getConnection();
			Home h=new Home();
			f.dispose();
		}
		
	}
	public void mousePressed(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{ }
	public void mouseExited(MouseEvent me)
	{}
	public void mouseClicked(MouseEvent me)
	{ 
		if(me.getSource()==tf1)
		{
			tf1.setText("");
			tf1.setForeground(Color.black);
		}
		if(me.getSource()==tf2)
		{
			tf2.setText("");
			tf2.setForeground(Color.black);
		}
		if(me.getSource()==tf3)
		{
			tf3.setText("");
			tf3.setForeground(Color.black);
		}
		if(me.getSource()==tf4)
		{
			tf4.setText("");
			tf4.setForeground(Color.black);
		}
		if(me.getSource()==tf0)
		{
			tf0.setText("");
			tf0.setForeground(Color.black);
		}		
	}
}

