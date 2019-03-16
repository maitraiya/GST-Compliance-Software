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
public class Billfinal implements ActionListener{
	

	int n=0,n1=0;
	float s1,s2,s3,s4,s5,total;
	

	JLabel l1;
	JButton b1,b2,b5,b7,b9,b0,b0n,b0p,b5n,b5p,b12n,b12p,b18n,b18p,b28n,b28p,bind,bmb;
	JTextField tf1,tf0,tf3, tf2,tfcb,tf5,tfmb;
	JComboBox tf4;
	JFrame f;
	JPanel p1,p2;
	static ResultSet 			result1,result2,result3,result4,result5,result6,result11,result22,result33,result44,result55,result66,result111,result222,result333,result444,result555,result666;
	static ResultSet result0;
	static Connection con;
	static PreparedStatement stat,stat0;
	static Statement stat1,stat2,stat3,stat4,stat5,stat6,stat11,stat22,stat33,stat44,stat55,stat66,stat111,stat222,stat333,stat444,stat555,stat666;

	public Billfinal()
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

		p1.setBackground(Color.red);
		p2.setBackground(Color.white);
				

		l1=new JLabel("Bill ");
		tf0=new JTextField(10);
		tf1=new JTextField(10);
		tf3=new JTextField(12);
		String s[]={"Product Category(%)","0","5","12","18","28"};
		tf4=new JComboBox(s);
		tf2=new JTextField(10);
		tfcb=new JTextField(10);
		tfmb=new JTextField(10);

		b1=new JButton("5% Category");
		b2=new JButton("12% Category");
		b9=new JButton("0% Category");
		b5=new JButton("18% Category");
		b7=new JButton("28% Category");
		b0=new JButton("Clear");
		bind=new JButton("Index");
		b0n=new JButton(">");
		b0p=new JButton("<");
		b5n=new JButton(">");
		b5p=new JButton("<");
		b12n=new JButton(">");
		b12p=new JButton("<");
		b18n=new JButton(">");
		b18p=new JButton("<");
		b28n=new JButton(">");
		b28p=new JButton("<");
		bmb=new JButton("Gross Total Amount ");
		p1.add(l1);
		p2.add(tf0);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		p2.add(tfcb);
		p2.add(tfmb);
		p2.add(b1);
		p2.add(b2);
		p2.add(b5);
		p2.add(b7);
		p2.add(b9);
		p2.add(b0);
		p2.add(b0n);
		p2.add(b0p);
		p2.add(b5n);
		p2.add(b5p);
		p2.add(b12n);
		p2.add(b12p);
		p2.add(b18n);
		p2.add(b18p);
		p2.add(b28n);
		p2.add(b28p);
		p2.add(bind);
		p2.add(bmb);
		p2.setLayout(null);
		Font f1=new Font("Algerian",Font.BOLD,48);
		Font f2=new Font("chiller",Font.BOLD,80);
		l1.setBounds(60,80,500,80);
		l1.setForeground(Color.white);
		l1.setFont(f1);
		tf0.setBounds(100,150,500,40);
		tf1.setBounds(100,210,500,40);
		tf2.setBounds(100,270,500,40);
		tf3.setBounds(100,330,500,40);
		tf4.setBounds(100,390,500,40);
		tfcb.setBounds(100,460,500,40);
		tfmb.setBounds(100,520,500,40);		
	
		b0p.setBounds(700,150,50,40);		
		b9.setBounds(770,150,300,40);
		b0n.setBounds(1090,150,50,40);
		
		b5p.setBounds(700,220,50,40);
		b1.setBounds(770,220,300,40);
		b5n.setBounds(1090,220,50,40);

		b12p.setBounds(700,290,50,40);		
		b2.setBounds(770,290,300,40);
		b12n.setBounds(1090,290,50,40);
		
		b18p.setBounds(700,360,50,40);
		b5.setBounds(770,360,300,40);
		b18n.setBounds(1090,360,50,40);
		
		b28p.setBounds(700,430,50,40);		
		b7.setBounds(770,430,300,40);
		b28n.setBounds(1090,430,50,40);
	
		b0.setBounds(100,650,550,40);
		bind.setBounds(650,650,550,40);


		bmb.setBounds(700,520,440,40);

		tf0.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tfcb.setEditable(false);
		tfmb.setEditable(false);
		
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
		tfcb.setText("Categorywise Total Amount");
		tfmb.setText("Gross Net Amount");
		tf0.setForeground(Color.gray);
		tfcb.setForeground(Color.gray);
		tfmb.setForeground(Color.gray);
		tf1.setForeground(Color.gray);
		tf2.setForeground(Color.gray);
		tf3.setForeground(Color.gray);
		tf4.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b5.addActionListener(this);
		b7.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		b0n.addActionListener(this);
		b0p.addActionListener(this);
		b5n.addActionListener(this);
		b5p.addActionListener(this);
		b12n.addActionListener(this);
		b12p.addActionListener(this);
		b18n.addActionListener(this);
		b18p.addActionListener(this);
		b28n.addActionListener(this);
		b28p.addActionListener(this);
		bind.addActionListener(this);
		bmb.addActionListener(this);
		MyConnection m=new MyConnection();
		con=m.getConnection();
try{
		stat11=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat22=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat33=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat44=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat55=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat4=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat5=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		result11 = stat11.executeQuery("select * from bill where pcat=0");
		result22 = stat22.executeQuery("select * from bill where pcat=5");
		result33 = stat33.executeQuery("select * from bill where pcat=12");
		result44 = stat44.executeQuery("select * from bill where pcat=18");
		result55 = stat55.executeQuery("select * from bill where pcat=28");
		result1 = stat1.executeQuery("select * from bill where pcat=0");
		result2 = stat2.executeQuery("select * from bill where pcat=5");
		result3 = stat3.executeQuery("select * from bill where pcat=12");
		result4 = stat4.executeQuery("select * from bill where pcat=18");
		result5 = stat5.executeQuery("select * from bill where pcat=28");

		stat111=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat222=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat333=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat444=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		stat555=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
			}
catch(Exception ex1){}
	}
	
	public static void main(String[] args) {
		Billfinal b=new Billfinal();

	}
	void five()
	{
		try
		{
			int i,count=0,c[];
			float sum=0,b[];
			result2= stat2.executeQuery("select count(pid) from bill where pcat=5");
			result2.next();
			count=Integer.parseInt(result2.getString(1));
			result2= stat2.executeQuery("select pqty from bill where pcat=5");
			result2.next();
			c=new int[count];
			for(i=0;i<count;i++)
			{
				c[i]=Integer.parseInt(result2.getString(1));
				result2.next();
			}
			result2 = stat2.executeQuery("select pprice from bill where pcat=5");
			float a[];
			a=new float[count];
			b=new float[count];				
			for(i=0;i<count;i++)
			{
				result2.next();
				a[i]=Integer.parseInt(result2.getString(1));
			}
			for(i=0;i<count;i++)
			{
				a[i]=a[i]*c[i];
			}
			
			for(i=0;i<count;i++)
			{
				b[i]=(a[i]*5)/100;
				a[i]=a[i]+b[i];
			}
			
			for(i=0;i<count;i++)
			{
				sum=sum+a[i];
			}
			//String Sum=Integer.toString(sum);
			//System.out.println(Sum);
			String Sum=Float.toString(sum);
			System.out.println(sum);
			tfcb.setText(""+Sum+" INR");
			tfcb.setForeground(Color.BLACK);
			s2=sum;
			}
		catch(Exception ex)
		{
			
		}
	}
	void twelve()
	{
		try
		{
			int i,count=0,c[];
			float sum=0,b[];
			result3 = stat3.executeQuery("select count(pid) from bill where pcat=12");
			result3.next();
			count=Integer.parseInt(result3.getString(1));
			result3= stat3.executeQuery("select pqty from bill where pcat=12");
			result3.next();
			c=new int[count];
			for(i=0;i<count;i++)
			{
				c[i]=Integer.parseInt(result3.getString(1));
				result3.next();
			}
			result3 = stat3.executeQuery("select pprice from bill where pcat=12");
			float a[];
			a=new float[count];
			b=new float[count];				
			for(i=0;i<count;i++)
			{
				result3.next();
				a[i]=Integer.parseInt(result3.getString(1));
			}
			for(i=0;i<count;i++)
			{
				a[i]=a[i]*c[i];
			}

			for(i=0;i<count;i++)
			{
				b[i]=(a[i]*12)/100;
				a[i]=a[i]+b[i];
			}
			
			for(i=0;i<count;i++)
			{
				sum=sum+a[i];
			}
			//String Sum=Integer.toString(sum);
			//System.out.println(Sum);
			String Sum=Float.toString(sum);
			System.out.println(sum);
			tfcb.setText(""+Sum+" INR");
			tfcb.setForeground(Color.BLACK);
			s3=sum;
		}
		catch(Exception ex)
		{
			
		}
		
	}

	void eighteen()
	{
		try
		{
			int i,count=0,c[];
			float sum=0,b[];
			result4= stat4.executeQuery("select count(pid) from bill where pcat=18");
			result4.next();
			count=Integer.parseInt(result4.getString(1));
			result4= stat4.executeQuery("select pqty from bill where pcat=18");
			result4.next();
			c=new int[count];
			for(i=0;i<count;i++)
			{
				c[i]=Integer.parseInt(result4.getString(1));
				result4.next();
			}
			result4 = stat4.executeQuery("select pprice from bill where pcat=18");
			float a[];
			a=new float[count];
			b=new float[count];				
			for(i=0;i<count;i++)
			{
				result4.next();
				a[i]=Integer.parseInt(result4.getString(1));
			}
			for(i=0;i<count;i++)
			{
				a[i]=a[i]*c[i];
			}

			for(i=0;i<count;i++)
			{
				b[i]=(a[i]*18)/100;
				a[i]=a[i]+b[i];
			}
			
			for(i=0;i<count;i++)
			{
				sum=sum+a[i];
			}
			//String Sum=Integer.toString(sum);
			//System.out.println(Sum);
			String Sum=Float.toString(sum);
			System.out.println(sum);
			tfcb.setText(""+Sum+" INR");
			tfcb.setForeground(Color.BLACK);
			s4=sum;
		}
		catch(Exception ex)
		{
			
		}
	}
	void zero()
	{
		try
		{
			int i,count=0,c[];
			float sum=0,b[];
			result1 = stat1.executeQuery("select count(pid) from bill where pcat=0");
			result1.next();
			count=Integer.parseInt(result1.getString(1));
			result1= stat1.executeQuery("select pqty from bill where pcat=0");
			result1.next();
			c=new int[count];
			for(i=0;i<count;i++)
			{
				c[i]=Integer.parseInt(result1.getString(1));
				result1.next();
			}
			result1 = stat1.executeQuery("select pprice from bill where pcat=0");
			float a[];
			a=new float[count];
			b=new float[count];				
			for(i=0;i<count;i++)
			{
				result1.next();
				a[i]=Integer.parseInt(result1.getString(1));
			}
			for(i=0;i<count;i++)
			{
				a[i]=a[i]*c[i];
			}

			/*		for(i=0;i<count;i++)
			{
				b[i]=(a[i]*5)/100;
				a[i]=a[i]+b[i];
			}
	*/		
			for(i=0;i<count;i++)
			{
				sum=sum+a[i];
			}
			//String Sum=Integer.toString(sum);
			//System.out.println(Sum);
			String Sum=Float.toString(sum);
			System.out.println(sum);
			tfcb.setText(""+Sum+" INR");
			tfcb.setForeground(Color.BLACK);
			s1=sum;
		}
		catch(Exception ex)
		{
			
		}
	}
	void twentyeight()
	{
		try
		{
			int i,count=0,c[];
			float sum=0,b[];
			result5= stat5.executeQuery("select count(pid) from bill where pcat=28");
			result5.next();
			count=Integer.parseInt(result5.getString(1));
			result5= stat5.executeQuery("select pqty from bill where pcat=28");
			result5.next();
			c=new int[count];
			for(i=0;i<count;i++)
			{
				c[i]=Integer.parseInt(result5.getString(1));
				result5.next();
			}
			result5 = stat5.executeQuery("select pprice from bill where pcat=28");
			float a[];
			a=new float[count];
			b=new float[count];				
			for(i=0;i<count;i++)
			{
				result5.next();
				a[i]=Integer.parseInt(result5.getString(1));
			}
			for(i=0;i<count;i++)
			{
				a[i]=a[i]*c[i];
			}

			for(i=0;i<count;i++)
			{
				b[i]=(a[i]*28)/100;
				a[i]=a[i]+b[i];
			}
			
			for(i=0;i<count;i++)
			{
				sum=sum+a[i];
			}
			//String Sum=Integer.toString(sum);
			//System.out.println(Sum);
			String Sum=Float.toString(sum);
			System.out.println(sum);
			tfcb.setText(""+Sum+" INR");
			tfcb.setForeground(Color.BLACK);
			s5=sum;
		}
		catch(Exception ex)
		{
			
		}

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bmb)
		{
			zero();
			five();
			twelve();
			eighteen();
			twentyeight();
			total=s1+s2+s3+s4+s5;
			JOptionPane.showMessageDialog(null, new String("Net Amount Of Your Invoice is "+total+" INR"));
			tfmb.setText(total+ "INR");
			tfmb.setForeground(Color.BLACK);
			
		}
		if(e.getSource()==b1)
		{
			try
			{
				int i,count=0,c[];
				float sum=0,b[];
				result2= stat2.executeQuery("select count(pid) from bill where pcat=5");
				result2.next();
				count=Integer.parseInt(result2.getString(1));
				result2= stat2.executeQuery("select pqty from bill where pcat=5");
				result2.next();
				c=new int[count];
				for(i=0;i<count;i++)
				{
					c[i]=Integer.parseInt(result2.getString(1));
					result2.next();
				}
				result2 = stat2.executeQuery("select pprice from bill where pcat=5");
				float a[];
				a=new float[count];
				b=new float[count];				
				for(i=0;i<count;i++)
				{
					result2.next();
					a[i]=Integer.parseInt(result2.getString(1));
				}
				for(i=0;i<count;i++)
				{
					a[i]=a[i]*c[i];
				}
				
				for(i=0;i<count;i++)
				{
					b[i]=(a[i]*5)/100;
					a[i]=a[i]+b[i];
				}
				
				for(i=0;i<count;i++)
				{
					sum=sum+a[i];
				}
				//String Sum=Integer.toString(sum);
				//System.out.println(Sum);
				String Sum=Float.toString(sum);
				System.out.println(sum);
				tfcb.setText(""+Sum+" INR");
				tfcb.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, new String("Total Amount Of Product Present In 5% Cateogary Is "+Sum+" INR"));
				s2=sum;
				}
			catch(Exception ex)
			{
				
			}
		}
		if(e.getSource()==b2)
		{
			try
			{
				int i,count=0,c[];
				float sum=0,b[];
				result3 = stat3.executeQuery("select count(pid) from bill where pcat=12");
				result3.next();
				count=Integer.parseInt(result3.getString(1));
				result3= stat3.executeQuery("select pqty from bill where pcat=12");
				result3.next();
				c=new int[count];
				for(i=0;i<count;i++)
				{
					c[i]=Integer.parseInt(result3.getString(1));
					result3.next();
				}
				result3 = stat3.executeQuery("select pprice from bill where pcat=12");
				float a[];
				a=new float[count];
				b=new float[count];				
				for(i=0;i<count;i++)
				{
					result3.next();
					a[i]=Integer.parseInt(result3.getString(1));
				}
				for(i=0;i<count;i++)
				{
					a[i]=a[i]*c[i];
				}

				for(i=0;i<count;i++)
				{
					b[i]=(a[i]*12)/100;
					a[i]=a[i]+b[i];
				}
				
				for(i=0;i<count;i++)
				{
					sum=sum+a[i];
				}
				//String Sum=Integer.toString(sum);
				//System.out.println(Sum);
				String Sum=Float.toString(sum);
				System.out.println(sum);
				tfcb.setText(""+Sum+" INR");
				tfcb.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, new String("Total Amount Of Product Present In 12% Cateogary Is "+Sum+" INR"));
				s3=sum;
			}
			catch(Exception ex)
			{
				
			}
			
		}
		if(e.getSource()==b0)
		{
			tf1.setText("Product Id");
			tf2.setText("Product Price");
			tf0.setText("Product Name");
			tf3.setText("Product Quantity");
			tf4.setSelectedItem("Product Category(%)");
			tfcb.setText("Categorywise Total Amount");
			tfmb.setText("Gross Net Amount");
			tfcb.setForeground(Color.gray);
			tfmb.setForeground(Color.gray);
			tf0.setForeground(Color.gray);
			tf1.setForeground(Color.gray);
			tf2.setForeground(Color.gray);
			tf3.setForeground(Color.gray);
			tf4.setForeground(Color.gray);
		}
		if(e.getSource()==bind)
		{
			try
			{
				
				stat111.executeUpdate("delete from bill where pcat=0");
				stat222.executeUpdate("delete from bill where pcat=5");
				stat333.executeUpdate("delete from bill where pcat=12");
				stat444.executeUpdate("delete from bill where pcat=18");
				stat555.executeUpdate("delete from bill where pcat=28");
				
				tf1.setText("Product Id");
				tf2.setText("Product Price");
				tf0.setText("Product Name");
				tf3.setText("Product Quantity");
				tf4.setSelectedItem("Product Category(%)");
				tfcb.setText("Categorywise Total Amount");
				tfmb.setText("Gross Net Amount");
				tfcb.setForeground(Color.gray);
				tfmb.setForeground(Color.gray);
				tf0.setForeground(Color.gray);
				tf1.setForeground(Color.gray);
				tf2.setForeground(Color.gray);
				tf3.setForeground(Color.gray);
				tf4.setForeground(Color.gray);
				JOptionPane.showMessageDialog(null, new String("Database Cleared Successfully..."));
				Index t=new Index();
				f.dispose();
				
			}
			catch(Exception ex)
			{}
			
			
		}
		if(e.getSource()==b5)
		{
		
			try
			{
				int i,count=0,c[];
				float sum=0,b[];
				result4= stat4.executeQuery("select count(pid) from bill where pcat=18");
				result4.next();
				count=Integer.parseInt(result4.getString(1));
				result4= stat4.executeQuery("select pqty from bill where pcat=18");
				result4.next();
				c=new int[count];
				for(i=0;i<count;i++)
				{
					c[i]=Integer.parseInt(result4.getString(1));
					result4.next();
				}
				result4 = stat4.executeQuery("select pprice from bill where pcat=18");
				float a[];
				a=new float[count];
				b=new float[count];				
				for(i=0;i<count;i++)
				{
					result4.next();
					a[i]=Integer.parseInt(result4.getString(1));
				}
				for(i=0;i<count;i++)
				{
					a[i]=a[i]*c[i];
				}

				for(i=0;i<count;i++)
				{
					b[i]=(a[i]*18)/100;
					a[i]=a[i]+b[i];
				}
				
				for(i=0;i<count;i++)
				{
					sum=sum+a[i];
				}
				//String Sum=Integer.toString(sum);
				//System.out.println(Sum);
				String Sum=Float.toString(sum);
				System.out.println(sum);
				tfcb.setText(""+Sum+" INR");
				tfcb.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, new String("Total Amount Of Product Present In 18% Cateogary Is "+Sum+" INR"));
				s4=sum;
			}
			catch(Exception ex)
			{
				
			}
		}
		if(e.getSource()==b7)
		{
			try
			{
				int i,count=0,c[];
				float sum=0,b[];
				result5= stat5.executeQuery("select count(pid) from bill where pcat=28");
				result5.next();
				count=Integer.parseInt(result5.getString(1));
				result5= stat5.executeQuery("select pqty from bill where pcat=28");
				result5.next();
				c=new int[count];
				for(i=0;i<count;i++)
				{
					c[i]=Integer.parseInt(result5.getString(1));
					result5.next();
				}
				result5 = stat5.executeQuery("select pprice from bill where pcat=28");
				float a[];
				a=new float[count];
				b=new float[count];				
				for(i=0;i<count;i++)
				{
					result5.next();
					a[i]=Integer.parseInt(result5.getString(1));
				}
				for(i=0;i<count;i++)
				{
					a[i]=a[i]*c[i];
				}

				for(i=0;i<count;i++)
				{
					b[i]=(a[i]*28)/100;
					a[i]=a[i]+b[i];
				}
				
				for(i=0;i<count;i++)
				{
					sum=sum+a[i];
				}
				//String Sum=Integer.toString(sum);
				//System.out.println(Sum);
				String Sum=Float.toString(sum);
				System.out.println(sum);
				tfcb.setText(""+Sum+" INR");
				tfcb.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, new String("Total Amount Of Product Present In 28% Cateogary Is "+Sum+" INR"));
				s5=sum;
			}
			catch(Exception ex)
			{
				
			}
		}
		
		if(e.getSource()==b9)
		{
			try
			{
				int i,count=0,c[];
				float sum=0,b[];
				result1 = stat1.executeQuery("select count(pid) from bill where pcat=0");
				result1.next();
				count=Integer.parseInt(result1.getString(1));
				result1= stat1.executeQuery("select pqty from bill where pcat=0");
				result1.next();
				c=new int[count];
				for(i=0;i<count;i++)
				{
					c[i]=Integer.parseInt(result1.getString(1));
					result1.next();
				}
				result1 = stat1.executeQuery("select pprice from bill where pcat=0");
				float a[];
				a=new float[count];
				b=new float[count];				
				for(i=0;i<count;i++)
				{
					result1.next();
					a[i]=Integer.parseInt(result1.getString(1));
				}
				for(i=0;i<count;i++)
				{
					a[i]=a[i]*c[i];
				
				}

				/*		for(i=0;i<count;i++)
				{
					b[i]=(a[i]*5)/100;
					a[i]=a[i]+b[i];
				}
		*/		
				for(i=0;i<count;i++)
				{
					sum=sum+a[i];
				}
				//String Sum=Integer.toString(sum);
				//System.out.println(Sum);
				String Sum=Float.toString(sum);
				System.out.println(sum);
				tfcb.setText(""+Sum+" INR");
				tfcb.setForeground(Color.BLACK);
				JOptionPane.showMessageDialog(null, new String("Total Amount Of Product Present In 0% Cateogary Is "+Sum+" INR"));
				s1=sum;
			}
			catch(Exception ex)
			{
				
			}
		}
	
		if(e.getSource()==b0n)
		{
			try
			{	
				result11.next();
				tf1.setText(result11.getString(2));
				tf0.setText(result11.getString(1));
				tf3.setText(result11.getString(4));
				tf4.setSelectedItem(result11.getString(5));
				tf2.setText(result11.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
				String idchk=tf1.getText();
			}
			catch(Exception ex){}

		}
		if(e.getSource()==b0p)
		{
			try
			{					  
				result11.previous();
				tf1.setText(result11.getString(2));
				tf0.setText(result11.getString(1));
				tf3.setText(result11.getString(4));
				tf4.setSelectedItem(result11.getString(5));
				tf2.setText(result11.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}

		}
		if(e.getSource()==b5n)
		{
			try
			{					  
				result22.next();
				tf1.setText(result22.getString(2));
				tf0.setText(result22.getString(1));
				tf3.setText(result22.getString(4));
				tf4.setSelectedItem(result22.getString(5));
				tf2.setText(result22.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}

		}
		if(e.getSource()==b5p)
		{
			try
			{					  
				result22.previous();
				tf1.setText(result22.getString(2));
				tf0.setText(result22.getString(1));
				tf3.setText(result22.getString(4));
				tf4.setSelectedItem(result22.getString(5));
				tf2.setText(result22.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
			
		}
		if(e.getSource()==b12n)
		{
			try{
			result33.next();
			tf1.setText(result33.getString(2));
			tf0.setText(result33.getString(1));
			tf3.setText(result33.getString(4));
			tf4.setSelectedItem(result33.getString(5));
			tf2.setText(result33.getString(3));
			tf0.setForeground(Color.black);
			tf1.setForeground(Color.black);
			tf3.setForeground(Color.black);
			tf4.setForeground(Color.black);
			tf2.setForeground(Color.black);
			}
			catch(Exception ex)
			{
				
			}
		}
		if(e.getSource()==b12p)
		{
			try
			{					  
				result33.previous();
				tf1.setText(result33.getString(2));
				tf0.setText(result33.getString(1));
				tf3.setText(result33.getString(4));
				tf4.setSelectedItem(result33.getString(5));
				tf2.setText(result33.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}

		}
		if(e.getSource()==b18n)
		{
			try{
			result44.next();
			tf1.setText(result44.getString(2));
			tf0.setText(result44.getString(1));
			tf3.setText(result44.getString(4));
			tf4.setSelectedItem(result44.getString(5));
			tf2.setText(result44.getString(3));
			tf0.setForeground(Color.black);
			tf1.setForeground(Color.black);
			tf3.setForeground(Color.black);
			tf4.setForeground(Color.black);
			tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
		}
		if(e.getSource()==b18p)
		{
			try
			{					  
				result44.previous();
				tf1.setText(result44.getString(2));
				tf0.setText(result44.getString(1));
				tf3.setText(result44.getString(4));
				tf4.setSelectedItem(result44.getString(5));
				tf2.setText(result44.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
			
		}
		if(e.getSource()==b28n)
		{
			try{
			result55.next();
			tf1.setText(result55.getString(2));
			tf0.setText(result55.getString(1));
			tf3.setText(result55.getString(4));
			tf4.setSelectedItem(result55.getString(5));
			tf2.setText(result55.getString(3));
			tf0.setForeground(Color.black);
			tf1.setForeground(Color.black);
			tf3.setForeground(Color.black);
			tf4.setForeground(Color.black);
			tf2.setForeground(Color.black);
			}
			catch(Exception ex)
			{}
		}
		if(e.getSource()==b28p)
		{
			try
			{					  
				result55.previous();
				tf1.setText(result55.getString(2));
				tf0.setText(result55.getString(1));
				tf3.setText(result55.getString(4));
				tf4.setSelectedItem(result55.getString(5));
				tf2.setText(result55.getString(3));
				tf0.setForeground(Color.black);
				tf1.setForeground(Color.black);
				tf3.setForeground(Color.black);
				tf4.setForeground(Color.black);
				tf2.setForeground(Color.black);
			}
			catch(Exception ex){}
			
		}
		
		
	}
	
}

