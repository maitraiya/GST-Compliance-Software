import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Delete implements ActionListener,MouseListener
{
	JLabel l1;
	JButton b1,b2,b3;
	JTextField tf1;
	JFrame f;
	JPanel p1,p2;
	int n1,n2;
	String s1,s2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1;

	public Delete()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();		
		p2=new JPanel();

		f.add(p1);		
		f.add(p2);
		
		p1.setVisible(true);
		p1.setSize(1400,100);
		p2.setSize(1400,900);
		l1=new JLabel("Delete Employee");
		tf1=new JTextField(10);
		b1=new JButton("Delete");
		b2=new JButton("Clear");
		b3=new JButton("Home");

		p1.setBackground(Color.red);
		p2.setBackground(Color.white);		
		
	
		p1.add(l1);
		p2.add(tf1);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(160,80,500,80);
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf1.setBounds(200,200,900,40);
		b1.setBounds(200,320,500,40);
		b2.setBounds(700,320,500,40);
		b3.setBounds(400,400,500,40);	
				
		tf1.setText("Employee id");
		tf1.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf1.addMouseListener(this);
	}
	
	public static void main(String args[]) {
		Delete l=new Delete();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			
			String echk=tf1.getText();
			if(!echk.equals("") && !echk.equals("Employee id"))
			{	
				if(Pattern.matches("^[0-9]+$",tf1.getText())){
					try
				{
					MyConnection m=new MyConnection();
					con=m.getConnection();
					stat=con.prepareStatement("delete from employee where eid = ?");
						stat.setInt(1,Integer.parseInt(tf1.getText()));
						int i=stat.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(null,new String("Record Deleted successfully..."));
						}
						else
						{
							JOptionPane.showMessageDialog(null,new String("Coudnt find the record of this id"));
						}
				}
				catch(Exception ex)
				{
					System.out.println("Error.3......"+e);
				}
				}
				else
					JOptionPane.showMessageDialog(null, new String("Please Enter Numeric Value for Employee Id"));

			}
			else
			{
				JOptionPane.showMessageDialog(null, new String("Please Enter All The Required Credentials"));
			}
		}
		if(e.getSource()==b2)
		{
			
			tf1.setText("Employee id");
			tf1.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			MyConnection m=new MyConnection();
			con=m.getConnection();
			Home h=new Home();
			f.dispose();
		}
	}
//	public void ShowRes(ResultSet result,int n1,String s1)
//	{
//		try
//		{
			///		}
//		catch(Exception e3) {};		

//	}
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
				}
}

