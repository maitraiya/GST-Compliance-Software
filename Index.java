import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Index implements ActionListener,MouseListener
{
	JLabel l1;
	JTextField tf0;
	JButton b1,b2,b3,b4;
	JFrame f;
	JPanel p1,p2;
	String s1,s2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1;
	public Index()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p2=new JPanel();
		p1=new JPanel();
		
		p2.setSize(1400,800);
		p1.setSize(1400,100);

		p1.setVisible(true);
		p2.setVisible(true);

		f.add(p1);
		f.add(p2);
		
		tf0=new JTextField();
		l1=new JLabel("What you Wish to Do...?");
		b1=new JButton("Stock Insertion");
		b2=new JButton("Stock Updation");
		b3=new JButton("Billing Section");
		b4=new JButton("Logout");
		
		p1.add(l1);
		p2.add(b4);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		//Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(60,100,400,80);
		p1.setBackground(Color.red);			
		p2.setBackground(Color.white);		
		l1.setForeground(Color.white);
		l1.setFont(f1);

		b1.setBounds(150,200,1000,40);
		b2.setBounds(150,260,1000,40);
		b3.setBounds(150,320,1000,40);
		b4.setBounds(150,380,1000,40);
				
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		try{
			MyConnection m=new MyConnection();	
			con=m.getConnection();
			
		}catch(Exception ex1){}
	}
	
	public static void main(String args[]) {
		Index t=new Index();

	}

	public void actionPerformed(ActionEvent e)
	{
		try{
		if(e.getSource()==b1)
		{
			
		//		System.out.println(name);
	/*			result1.next();
				String sid=result1.getString(1);
				int pid=Integer.parseInt(sid);
			//	System.out.println(id);
				pid=pid+1;
	*/			
				Insertion i=new Insertion();
				f.dispose();
			
		}
		if(e.getSource()==b2)
		{
			Updation up=new Updation();
			f.dispose();
		}
		if(e.getSource()==b3)
		{
		
			Bill b=new Bill();
			f.dispose();
		}
		if(e.getSource()==b4)
		{
			Home h=new Home();
			f.dispose();
			JOptionPane.showMessageDialog(null, new String("Logged Out Successfully..."));

		}
		}
	catch(Exception ex){}
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
	{ }
}

