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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Insertion implements ActionListener,MouseListener{
	

	JLabel l1;
	JButton b1,b2,b3;
	JTextField tf1,tf0,tf3,tf2;
	JComboBox tf4;
	JFrame f;
	JPanel p1,p2;
	static ResultSet result;
	static ResultSet result1;
	static Connection con;
	static PreparedStatement stat,statp;
	static Statement stat1;

	public Insertion()
	{
		f=new JFrame("GST BILL MANAGEMENT");
		f.setSize(1400,900);
		f.setVisible(true);
		p1=new JPanel();		
		p2=new JPanel();
		f.add(p1);
		f.add(p2);
		
		p1.setSize(1400,100);
		p2.setSize(1400,900);
		
		p1.setVisible(true);
		p1.setVisible(true);

		l1=new JLabel("Stock Insertion");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(12);
		String s[]={"Product Category(%)","0","5","12","18","28"};
		tf4=new JComboBox(s);
		tf2=new JTextField(10);
		b1=new JButton("Insert in Shop ");
		b2=new JButton("Clear");
		b3=new JButton("Index");
		
		p1.setBackground(Color.red);
		p2.setBackground(Color.white);		
		
		p1.add(l1);
		p2.add(tf0);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		p2.setLayout(null);
		Font f1=new Font("Times new roman",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(160,80,600,80);
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf0.setBounds(200,200,900,40);
		tf2.setBounds(200,280,900,40);
		tf3.setBounds(200,360,900,40);
		tf4.setBounds(200,440,900,40);
		b1.setBounds(120,580,500,40);
		b2.setBounds(620,580,500,40);
		b3.setBounds(380,660,500,40);
		
				
		
				
		tf1.setText("Product Id");
		tf1.setToolTipText("Product Id");
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
		tf0.addMouseListener(this);
		tf1.addMouseListener(this);
		tf2.addMouseListener(this);
		tf3.addMouseListener(this);
		tf4.addMouseListener(this);
		try{
			MyConnection m=new MyConnection();
			con=m.getConnection();
			stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ex1){}
	}
	
	public static void main(String[] args) {
		Insertion ins=new Insertion();
		}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String nmchk=tf0.getText();
			String echk=tf1.getText();
			String pricechk=tf2.getText();
			String qchk=tf3.getText();
			String catchk=(String)tf4.getSelectedItem();
			if(!nmchk.equals("") && !pricechk.equals("") && !qchk.equals("")  && !qchk.equals("0") && !catchk.equals("") && !nmchk.equals("Product Name") &&  !pricechk.equals("Product Price") && !qchk.equals("Product Quantity") && !catchk.equals("Product Category(%)"))
			{
				if(!Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
					JOptionPane.showMessageDialog(null,new String("Enter Alphabets For Employee Name "));
				}	
				else if(Pattern.matches("^[a-zA-Z]+$",tf0.getText())){
			//			if(Pattern.matches("^[0-9]+$",tf1.getText())){
							if(Pattern.matches("^[0-9]+$",tf2.getText())){
							if(Pattern.matches("^[0-9]+$",tf3.getText())){
				try
				{
					
					stat=con.prepareStatement("insert into product(pname,pprice,pqty,pcat) values(?,?,?,?)");	
					stat.setString(1,tf0.getText());
					stat.setInt(2,Integer.parseInt(tf2.getText()));
					stat.setInt(3,Integer.parseInt(tf3.getText()));
					String s2=(String)tf4.getSelectedItem();
					stat.setInt(4,Integer.parseInt(s2));
					int i=stat.executeUpdate();				
					result=stat1.executeQuery("select max(pid) from product");
					result.next();
					int z=result.getInt(1);					
				        JOptionPane.showMessageDialog(null, new String("Your Product ID is "+z));
					
					if(i>=1 )
					{					
						System.out.println("Record  Saved.....");
			JOptionPane.showMessageDialog(null,new String("Record Save Successfully...\n Please Clear the data and add new Item"));				
					tf1.setText("Product Id");
					tf2.setText("Product Price");
					tf0.setText("Product Name");
					tf3.setText("Prodcut Quantity");
					tf4.setSelectedItem("Product Category(%)");
					tf0.setForeground(Color.gray);
					tf1.setForeground(Color.gray);
					tf2.setForeground(Color.gray);
					tf3.setForeground(Color.gray);
					tf4.setForeground(Color.gray);

					}
					else
						System.out.println("Unable to save record.....");
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, new String("Cannot insert Duplicate value for Product Id "));
					System.out.println("Error1......."+e);
				}
				}
				else
					JOptionPane.showMessageDialog(null, new String("Enter Numerical values in Quantity field "));
							}else
								JOptionPane.showMessageDialog(null, new String("Enter Numerical values in Price field "));
						//}else
						//	JOptionPane.showMessageDialog(null, new String("Enter Numerical values in Id field "));
				}else
					JOptionPane.showMessageDialog(null, new String("Enter Alpha values in Product Name field "));

				}
				else
				{
					JOptionPane.showMessageDialog(null, new String("Please Enter All The Required Credentials"));
				}
		}
		if(e.getSource()==b2)
		{
		//	tf1.setText("Product Id");
			tf2.setText("Product Price");
			tf0.setText("Product Name");
			tf3.setText("Prodcut Quantity");
			tf4.setSelectedItem("Product Category(%)");
			tf0.setForeground(Color.gray);
	//		tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
			
		}
		if(e.getSource()==b3)
		{
			Index t=new Index();
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
			tf4.setSelectedItem("Select");
			tf4.setForeground(Color.black);
		}
		if(me.getSource()==tf0)
		{
			tf0.setText("");
			tf0.setForeground(Color.black);
		}		
	}
}

