package com.userinterface;
import java.awt.Choice;






import java.sql.*;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import static com.userinterface.AddCustomer.*;

 public class ConnectionDemo {
	 Connection cn;
	 Statement st;
	 ResultSet rs;
	 JTable table;
	 Choice choiceempid;
	 
	 //AddCustomer addc=new AddCustomer();
	 
	 ConnectionDemo()
	 {
		 try
	 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/DairyProject","root","Sandy");
	      st=cn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	 }
	 
public  void insertCustomerData() throws Exception
{
	try
	{
	st.executeUpdate("insert into scustomer_details(cust_name,mobile_no,aadhar_no,bdate,join_date) values('"+cname+"','"+cno+"','"+cadhar+"','"+bdate+"','"+ldt+"')");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}

public void viewCustomerRecord()
{
	
	
	

	
	
}
public static void main(String args[])
{
	new ConnectionDemo();
	
}


}	


