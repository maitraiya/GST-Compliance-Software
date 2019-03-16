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
public class Bill implements ActionListener,MouseListener{
	

	int n=0,n1=0,z=0;
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JTextField tf1,tf0,tf3, tf2;
	JComboBox tf4;
	JFrame f;
	JPanel p1,p2;
	static ResultSet result,result2;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat,stat2;
	static Statement stat1;

	public Bill()
	{
		
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();		
		p2=new JPanel();
		
		p1.setSize(1400,100);
		p2.setSize(1400,900);

		p1.setBackground(Color.red);
		p2.setBackground(Color.white);
		
		f.add(p1);
		f.add(p2);
		
		l1=new JLabel("Selection Window");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(12);
		String s[]={"Product Category(%)","0","5","12","18","28"};
		tf4=new JComboBox(s);
		tf2=new JTextField(10);
		b1=new JButton("Add to Cart");
		b2=new JButton("Clear");
		b3=new JButton("Home");
		b4=new JButton("Search");
		b5=new JButton("First");
		b6=new JButton("Next");
		b9=new JButton("Open Cart");
		b7=new JButton("Previous");
		b8=new JButton("Last");
		p1.add(l1);
		p2.add(tf0);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
	//	p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);	
		
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(60,80,500,80);
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf0.setBounds(150,200,500,40);
		tf1.setBounds(150,270,500,40);
		tf2.setBounds(150,330,500,40);
		tf3.setBounds(150,390,500,40);
		tf4.setBounds(150,450,500,40);
		b1.setBounds(200,600,500,40);		
		b2.setBounds(700,600,500,40);
		b9.setBounds(200,660,500,40);
		b3.setBounds(700,660,500,40);		
		b4.setBounds(800,200,400,40);
		b5.setBounds(800,260,400,40);
		b6.setBounds(800,320,400,40);
		b7.setBounds(800,380,400,40);
		b8.setBounds(800,440,400,40);
				
		
		tf0.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf4.setEditable(false);
		
		tf1.setText("Product Id");
		tf1.setToolTipText("Product id");
		tf0.setToolTipText("Product Name");
		tf2.setToolTipText("Product Price");
		tf3.setToolTipText("Product Quantity");
		tf4.setToolTipText("Product Category");
		tf2.setText("Product Price");
		tf0.setText("Product Name");
		tf3.setText("Product Quantity");
		tf4.setSelectedItem("Product Category(%)");
		
		tf0.setForeground(Color.gray);
		tf1.setForeground(Color.gray);
		tf2.setForeground(Color.gray);
		tf3.setForeground(Color.gray);
		tf4.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		tf3.addMouseListener(this);
		MyConnection m=new MyConnection();
		con=m.getConnection();
		try{
		stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		result1=stat1.executeQuery("Select * from product");
		}
		catch(Exception ex1){}
	}
	
	public static void main(String[] args) {
		Bill b=new Bill();

	}
	int stock()
	{
		try{
			
		stat2=con.prepareStatement("select * from product where pid = ?");
		stat2.setInt(1,Integer.parseInt(tf1.getText()));
		result2=stat2.executeQuery();
		result2.next();
		int qty=(Integer.parseInt(tf3.getText()));
		int id=(Integer.parseInt(result2.getString(4)));
		if(qty>id)
		{
			JOptionPane.showMessageDialog(null, new String("Not Enough Quantity of "+tf0.getText()+" Available in shop"));
			n1=1;
		}
		else if(qty<=id && id!=0)
		{
			int c=id-qty;
			stat=con.prepareStatement("update product set pqty=? where pid = ?");			
			stat.setInt(2,Integer.parseInt(tf1.getText()));
			stat.setInt(1,c);
			stat.executeUpdate();
			result1 = stat1.executeQuery("select * from product");
	//		JOptionPane.showMessageDialog(null, new String("Stock Updated Successfully..."));
			n1=0;
		}
		
		}
		catch(Exception ex){}
		return 0;
	}
	int stock1()
	{
		try{
			stat2=con.prepareStatement("select * from product where pid = ?");
			stat2.setInt(1,Integer.parseInt(tf1.getText()));
			result2=stat2.executeQuery();
			result2.next();
			int qty=(Integer.parseInt(tf3.getText()));
			int id=(Integer.parseInt(result2.getString(4)));
				int c=id+qty;
				stat=con.prepareStatement("update product set pqty=? where pid = ?");			
				stat.setInt(2,Integer.parseInt(tf1.getText()));
				stat.setInt(1,c);
				stat.executeUpdate();
				result1 = stat1.executeQuery("select * from product");
				//JOptionPane.showMessageDialog(null, new String("Stock Updated Successfully..."));
		
			
		}
		catch(Exception ex1){}
		return 0;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(n==1)
			{
				//n=0;
				int x=stock();
				if(n1==0){	
				String nmchk=tf0.getText();
				String echk=tf1.getText();
				String pricechk=tf2.getText();
				String qchk=tf3.getText();
				String catchk=(String)tf4.getSelectedItem();
				if(!nmchk.equals("") && !echk.equals("") && !pricechk.equals("") && !qchk.equals("") && !qchk.equals("0")  && !catchk.equals("") && !nmchk.equals("Product Name") && !echk.equals("Product Id") && !pricechk.equals("Product Price") && !qchk.equals("Product Quantity") && !catchk.equals("Product Category(%)"))
				{
					if(Pattern.matches("^[0-9]+$",tf1.getText())){

					try
				{
					stat=con.prepareStatement("insert into bill(pid,pname,pprice,pqty,pcat) values(?,?,?,?,?)");						
					stat.setString(2,tf0.getText());
					stat.setInt(1,Integer.parseInt(tf1.getText()));
					stat.setInt(3,Integer.parseInt(tf2.getText()));
					stat.setInt(4,Integer.parseInt(tf3.getText()));
					String s2=(String)tf4.getSelectedItem();
					stat.setInt(5,Integer.parseInt(s2));
					int i=stat.executeUpdate();//DML			
//					result1 = stat1.executeQuery("select * from product");
		
					if(i>=1)
{					
						System.out.println("Record  added to cart.....");
JOptionPane.showMessageDialog(null,new String("Record added to cart...\n Please Clear the data and add new Item"));			
}
					else
						System.out.println("Unable to add record.....");
						
					z=z+1;
					tf1.setText("Product Id");
					tf2.setText("Product Price");
					tf0.setText("Product Name");
					tf3.setText("Product Quantity");
					tf4.setSelectedItem("Product Category(%)");
					tf0.setForeground(Color.gray);
					tf1.setForeground(Color.gray);
					tf2.setForeground(Color.gray);
					tf3.setForeground(Color.gray);
					tf4.setForeground(Color.gray);

				}
				catch(Exception ex)
				{

					JOptionPane.showMessageDialog(null, new String("Cannot insert Duplicate value for Product Id "));
					stock1();
					System.out.println("Error.4......"+e);
					
				}
					}
					else
						JOptionPane.showMessageDialog(null, new String("Please Enter Numeric Value for Employee id to search"));

			}
				else
				{
					JOptionPane.showMessageDialog(null, new String("Please Enter all the credentials"));

				}
			}
			}
			else
				JOptionPane.showMessageDialog(null, new String("Initially Please enter search buttons to search the product info of product"));	
			
			
		}
		if(e.getSource()==b2)
		{
			tf1.setText("Product Id");
			tf2.setText("Product Price");
			tf0.setText("Product Name");
			tf3.setText("Product Quantity");
			tf4.setSelectedItem("Product Category(%)");
			tf0.setForeground(Color.gray);
			tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			Index t=new Index();
			f.dispose();
		}
	/*	if(e.getSource()==b4)
		{
				n=1;
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
				String echk=tf1.getText();
				if(!echk.equals("") && !echk.equals("Product Id"))
				{
						try
						{
							stat=con.prepareStatement("select * from product where pid = ?");
							stat.setInt(1,Integer.parseInt(tf1.getText()));
							result = stat.executeQuery();
							result.next();
							tf0.setText(result.getString(1));
							tf1.setText(result.getString(2));
							tf2.setText(result.getString(3));
							tf3.setText(result.getString(4));
							tf4.setSelectedItem(result.getString(5));
						}
						catch(Exception ex)
						{
							System.out.println("Error2......"+e);
						}	
				}
				else
				{
					JOptionPane.showMessageDialog(null, new String("Please Enter the id of product to edit its info and then click on SEARCH"));
					
				}
			}*/
		if(e.getSource()==b5)
		{
			try
			{					  
				n=1;
			//	result1.next();
				result1.first();
				tf0.setText(result1.getString(2));
				tf1.setText(result1.getString(1));
				tf3.setText(result1.getString(4));
				tf4.setSelectedItem(result1.getString(5));
				tf2.setText(result1.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b6)
		{
			try
			{		
				n=1;			  
				result1.next();
				tf0.setText(result1.getString(2));
				tf1.setText(result1.getString(1));
				tf3.setText(result1.getString(4));
				tf4.setSelectedItem(result1.getString(5));
				tf2.setText(result1.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b7)
		{
			try
			{	
				n=1;
				result1.previous();
				tf0.setText(result1.getString(2));
				tf1.setText(result1.getString(1));
				tf3.setText(result1.getString(4));
				tf4.setSelectedItem(result1.getString(5));
				tf2.setText(result1.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b8)
		{
			try
			{					  
				n=1;
				result1.last();
				tf0.setText(result1.getString(2));
				tf1.setText(result1.getString(1));
				tf3.setText(result1.getString(4));
				tf4.setSelectedItem(result1.getString(5));
				tf2.setText(result1.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b9)
		{
			try
			{					  
				JOptionPane.showMessageDialog(null, new String(z+" DIfferent types of Products selected"));
				Billconfig bi=new Billconfig();
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
		if(me.getSource()==tf3)
		{
			tf3.setText("");
			tf3.setForeground(Color.black);
		}
	} 
}

