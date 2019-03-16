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
public class Update implements ActionListener,MouseListener{
	

	int n=0;
	JLabel l1;
	JButton b1,b2,b3,b4;
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

	public Update()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();		
		p2=new JPanel();

		f.add(p1);		
		f.add(p2);
				
		p2.setSize(1400,900);
		p1.setSize(1400,100);
		p1.setVisible(true);
		p2.setVisible(true);
					
		
		l1=new JLabel("Update");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(12);
		tf4=new JTextArea(5,10);
		tf2=new JPasswordField(20);
		b1=new JButton("Update");
		b2=new JButton("Clear");
		b3=new JButton("Home");
		b4=new JButton("Search");
		p1.add(l1);
		p2.add(tf0);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(160,80,400,80);
		p1.setBackground(Color.red);
		p2.setBackground(Color.white);
		
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf0.setBounds(100,200,1000,40);
		tf1.setBounds(100,270,1000,40);
		tf2.setBounds(100,330,1000,40);
		tf3.setBounds(100,390,1000,40);
		tf4.setBounds(100,450,1000,40);
		b4.setBounds(100,530,500,40);
		b1.setBounds(600,530,500,40);
		b2.setBounds(100,600,500,40);
		b3.setBounds(600,600,500,40);
				
		
				
		tf1.setText("Employee id");
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
		b4.addActionListener(this);
		tf0.addMouseListener(this);
		 tf1.addMouseListener(this);
		tf2.addMouseListener(this);
		tf3.addMouseListener(this);
		tf4.addMouseListener(this);
		MyConnection m=new MyConnection();
		con=m.getConnection();
		try{
//		stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	//	result1 = stat1.executeQuery("select * from employee");
		}
		catch(Exception ex1){}
	}
	
	public static void main(String[] args) {
		Update up=new Update();
		
		}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(n==1)
			{
			n=0;
			String nmchk=tf0.getText();
			String echk=tf1.getText();
			String passchk=tf2.getText();
			String mobchk=tf3.getText();
			String addchk=tf4.getText();
			if(!nmchk.equals("") && !echk.equals("") && !passchk.equals("") && !mobchk.equals("")  && !addchk.equals("") && !nmchk.equals("Employee Name") && !echk.equals("Employee id") && !passchk.equals("Password") && !mobchk.equals("Employee Contact no.") && !addchk.equals("Employee Address"))
			{

				if(!Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
					JOptionPane.showMessageDialog(null,new String("Enter Alphabets For Employee Name "));
				}	
				else if(Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
						if(Pattern.matches("^[0-9]+$",tf1.getText())){
							if(mobchk.length()==10){
							if(Pattern.matches("^[0-9]+$",tf3.getText())){
				try
				{

					stat=con.prepareStatement("update employee set ename=?, epass=?,emob=?,eadd=? where eid = ?");			
					stat.setInt(5,Integer.parseInt(tf1.getText()));
					stat.setString(1,tf0.getText());
					stat.setString(2,tf2.getText());
					stat.setLong(3,Long.parseLong(tf3.getText()));
					stat.setString(4,tf4.getText());
					stat.executeUpdate();
//					result1 = stat1.executeQuery("select * from employee");
					JOptionPane.showMessageDialog(null, new String("Record Updated Successfully..."));
					tf1.setText("Employee Id");
					tf2.setText("Employee Password");
					tf0.setText("Employee Name");
					tf3.setText("Employee Contact no.");
					tf4.setText("Employee Address");
					tf0.setForeground(Color.gray);
					tf1.setForeground(Color.gray);
					tf2.setForeground(Color.gray);
					tf3.setForeground(Color.gray);
					tf4.setForeground(Color.gray);


				}
				catch(Exception ex)
				{
					System.out.println("Error.4......"+e);
				}
							}
							else
								JOptionPane.showMessageDialog(null, new String("Enter Numerical values in Contact field "));
							}
									else
									JOptionPane.showMessageDialog(null, new String("Contact no. not in limit "));
							}
							else
								JOptionPane.showMessageDialog(null, new String("Insert Numeric Values for Employee Id "));
						}
						else
							JOptionPane.showMessageDialog(null, new String("Please Enter Alphabets for Name "));
					}
					else
					{
						JOptionPane.showMessageDialog(null, new String("Please Enter All The Required Valid Credentials"));
					}	
			}
			else
				JOptionPane.showMessageDialog(null, new String("Initially Please enter search button to search the employee info to be Updated"));
			
		}
		if(e.getSource()==b2)
		{
			tf1.setText("Employee id");
			tf2.setText("Password");
			tf0.setText("Employee Name");
			tf3.setText("Employee Contact no.");
			tf4.setText("Employee Address");
			tf0.setForeground(Color.gray);
			tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			Home h=new Home();
			f.dispose();
		}
		if(e.getSource()==b4)
		{
				n=1;
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				String echk=tf1.getText();
				if(!echk.equals("") && !echk.equals("Employee id"))
				{
						try
						{
							stat=con.prepareStatement("select * from employee where eid = ?");
							stat.setInt(1,Integer.parseInt(tf1.getText()));
							result = stat.executeQuery();
							result.next();
							tf1.setText(result.getString(1));
							tf0.setText(result.getString(2));
							tf2.setText(result.getString(3));
							tf3.setText(result.getString(4));
							tf4.setText(result.getString(5));
						}
						catch(Exception ex)
						{
							System.out.println("Error2......"+e);
						tf1.setText("Employee id");						
						tf0.setText("Employee Name");
						tf3.setText("Employee Contact no.");
						tf4.setText("Employee Address");
						tf0.setForeground(Color.gray);
						tf1.setForeground(Color.gray);
						tf3.setForeground(Color.gray);
						tf4.setForeground(Color.gray);
						n=0;
						JOptionPane.showMessageDialog(null, new String("Please Enter Registered Employee Id"));
						
						}	
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, new String("Please Enter the id of employee to edit his/her info and then click on SEARCH"));
				}
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

