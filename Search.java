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
public class Search implements ActionListener,MouseListener{
	

	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JTextField tf1,tf0,tf3;
	JTextArea tf4;
	JFrame f;
	JPanel p1,p2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat;
	static Statement stat1;

	public Search()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();
		p2=new JPanel();
	
		p2.setSize(1400,900);
		p1.setSize(1400,100);
		p1.setVisible(true);
		p2.setVisible(true);

		f.add(p1);
		f.add(p2);
		
		l1=new JLabel("SEARCH");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(12);
		tf4=new JTextArea(5,10);
		b1=new JButton("Search");
		b2=new JButton("Clear");
		b3=new JButton("Home");
		b4=new JButton("First");
		b7=new JButton("Previous");
		b6=new JButton("Next");
		b5=new JButton("Last");
		
		
		p1.add(l1);
		p2.add(tf0);
		p2.add(tf1);
		p2.add(tf3);
		p2.add(tf4);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		//Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(60,100,400,80);
		p1.setBackground(Color.red);			
		p2.setBackground(Color.white);		
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf0.setBounds(100,200,500,40);
		tf1.setBounds(100,260,500,40);
		tf3.setBounds(100,320,500,40);
		tf4.setBounds(100,380,500,40);
		b1.setBounds(740,200,400,40);		
		b3.setBounds(100,550,510,40);
		b2.setBounds(610,550,520,40);		
		b4.setBounds(740,250,400,40);
		b5.setBounds(740,400,400,40);
		b6.setBounds(740,300,400,40);
		b7.setBounds(740,350,400,40);
		
		tf0.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
				
		tf1.setText("Employee id");
		tf1.setToolTipText("Employee id");
		tf0.setToolTipText("Name");
		tf3.setToolTipText("Employee Contact no");
		tf4.setToolTipText("Employee Address");
		tf0.setText("Employee Name");
		tf3.setText("Employee Contact no.");
		tf4.setText("Employee Address");
		
		tf0.setForeground(Color.gray);
		tf1.setForeground(Color.gray);
		tf3.setForeground(Color.gray);
		tf4.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf0.addMouseListener(this);
		tf1.addMouseListener(this);
		tf3.addMouseListener(this);
		tf4.addMouseListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		MyConnection m=new MyConnection();
		con=m.getConnection();
		try{
		stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		result1 = stat1.executeQuery("select * from employee");
		}
		catch(Exception ex1){}
	}
	
	public static void main(String[] args) {
		Search s=new Search();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			tf0.setForeground(Color.black);
			tf1.setForeground(Color.black);
			tf3.setForeground(Color.black);
			tf4.setForeground(Color.black);
			
			String echk=tf1.getText();
			if(!echk.equals("") && !echk.equals("Employee id"))
			{
				if(Pattern.matches("^[0-9]+$",tf1.getText())){

				try
					{
			/*		MyConnection m=new MyConnection();
					con=m.getConnection();
		*/			
						stat=con.prepareStatement("select * from employee where eid = ?");
						stat.setInt(1,Integer.parseInt(tf1.getText()));
						result = stat.executeQuery();
						result.next();
						tf1.setText(result.getString(1));
						tf0.setText(result.getString(2));
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

						JOptionPane.showMessageDialog(null, new String("Please Enter Registered Employee Id"));

					}	
				}
				else
					JOptionPane.showMessageDialog(null, new String("Please Enter the Numeric ID of employee"));
			}
			else
			{
				JOptionPane.showMessageDialog(null, new String("Please Enter the ID of employee"));
			}
		}
		if(e.getSource()==b2)
		{
			tf1.setText("Employee id");
			tf0.setText("Employee Name");
			tf3.setText("Employee Contact no.");
			tf4.setText("Employee Address");
			tf0.setForeground(Color.gray);
			tf1.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			try
			{
			MyConnection m=new MyConnection();
			con=m.getConnection();
		
			Home h=new Home();
			f.dispose();
			}
		catch(Exception ex1){}
		}
		if(e.getSource()==b4)
		{
			System.out.println("test1..");
			try
			{					  
			result1.first();
		System.out.println(result1.getString(1));
		tf1.setText(result1.getString(1));
		tf0.setText(result1.getString(2));
		tf3.setText(result1.getString(4));
		tf4.setText(result1.getString(5));
			}
		

			catch(Exception ex){}
		}
		if(e.getSource()==b5)
		{
			try
			{					  
			result1.last();
		System.out.println(result1.getString(1));
		tf1.setText(result1.getString(1));
		tf0.setText(result1.getString(2));
		tf3.setText(result1.getString(4));
		tf4.setText(result1.getString(5));
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b6)
		{
			try
			{					  
				result1.next();
		System.out.println(result1.getString(1));
		tf1.setText(result1.getString(1));
		tf0.setText(result1.getString(2));
		tf3.setText(result1.getString(4));
		tf4.setText(result1.getString(5));
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b7)
		{
			try
			{					  
	result1.previous();
		System.out.println(result1.getString(1));
		tf1.setText(result1.getString(1));
		tf0.setText(result1.getString(2));
		tf3.setText(result1.getString(4));
		tf4.setText(result1.getString(5));
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
		{
			tf1.setText("");
			tf1.setForeground(Color.black);
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

