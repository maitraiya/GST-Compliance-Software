import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Login implements ActionListener,MouseListener
{
	JLabel l1;
	JButton b1,b2,b3;//,b4;
	JTextField tf1;
	JPasswordField tf2;
	JFrame f;
	JPanel p1,p2;
	int n1,n2;
	String s1,s2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1;
	int n=0;
	public Login()
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
	
		l1=new JLabel("SIGN IN");
		tf1=new JTextField(10);
		tf2=new JPasswordField(20);
		b1=new JButton("SIGN IN");
		b2=new JButton("Clear");
		b3=new JButton("Home");
	//	b4=new JButton("Sign up!");
	//	b4.setBackground(Color.red);
	//	b4.setForeground(Color.blue);

		p1.add(l1);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
	//	p1.add(b4);
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		p1.setBackground(Color.red);			
		p2.setBackground(Color.white);		

		l1.setBounds(60,80,400,80);
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf1.setBounds(200,300,1000,40);
		tf2.setBounds(200,370,1000,40);
		b1.setBounds(200,440,500,40);
		b2.setBounds(400,500,500,40);
		b3.setBounds(700,440,500,40);
	//	b4.setBounds(10,100,100,40);				
		
				
		tf1.setText("Employee id");
		tf2.setText("Password");
		tf1.setForeground(Color.gray);
		tf2.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf1.addMouseListener(this);
		tf2.addMouseListener(this);
		
	}
	
	public static void main(String args[]) {
		Login l=new Login();
		}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
			String echk=tf1.getText();
			String passchk=tf2.getText();
			if(!echk.equals("") && !passchk.equals("") && !echk.equals("Employee id") && !passchk.equals("Password"))
			{	
				if(Pattern.matches("^[0-9]+$",tf1.getText())){	
				try
				{
					MyConnection m=new MyConnection();	
					con=m.getConnection();
					stat=con.prepareStatement("select * from employee where eid =? and epass=?");
					stat.setInt(1,Integer.parseInt(tf1.getText()));
					stat.setString(2,tf2.getText());
					result = stat.executeQuery();
					result.next();
					n1=Integer.parseInt(tf1.getText());
					s1=tf2.getText();
					System.out.println(result.getString(3)+"\t"+result.getInt(1));			
					 	s2=result.getString(3);
						n2=result.getInt(1);
						System.out.println("\n"+n2+"\n"+s2);
						if((n1 == n2) && (s1.equals(s2)))
						{
								JOptionPane.showMessageDialog(null,new String("Logged in successfully..."));
								Index t=new Index();
								f.dispose();
						}
						else  //if(n1 != n2 && !(s1.equals(s2)))
						{
								JOptionPane.showMessageDialog(null,new String("Please Enter Valid Credentials..."));
						}
				}
				catch(Exception ex)
				{
					System.out.println("Error2......"+e);
					JOptionPane.showMessageDialog(null,new String("Please Enter Valid Credentials..."));
				}	
				}
				else
					JOptionPane.showMessageDialog(null,new String("Please Enter Numeric value for ID Field"));
					
			}
			else
			{
				JOptionPane.showMessageDialog(null, new String("Please Enter All The Required Valid Credentials"));
			}
		}
		if(e.getSource()==b2)
		{
			
			tf1.setText("Employee id");
			tf2.setText("Password");
			tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
		}
		if(e.getSource()==b3)
		{
			try{
			Home h=new Home();
			f.dispose();
			}
			catch(Exception ex){}
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
			{tf1.setText("");tf1.setForeground(Color.black);}
			if(me.getSource()==tf2)
			{tf2.setText("");
			
			tf2.setForeground(Color.black);}
	}
}

