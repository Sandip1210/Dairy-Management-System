package com.userinterface;

import static com.userinterface.LoginPage.adharno;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static com.userinterface.LoginPage.*;
import net.proteanit.sql.DbUtils;

public class MyPaymentHistory extends JFrame {
	JTable table;
	int id;
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	ConnectionDemo cd1=new ConnectionDemo();

	public MyPaymentHistory() {
		// TODO Auto-generated constructor stub
		table=new JTable();
		try
		{
			
		cd1.rs=cd1.st.executeQuery("select cust_id from scustomer_details where aadhar_no='"+adharno+"'");
		while(cd1.rs.next())
		{
			id=cd1.rs.getInt(1);
		}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		String query1="select *from payment_history where cust_id="+id+"";
		try {
			 cd1.rs=cd1.st.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		JScrollPane jp=new JScrollPane(table);
		jp.setBounds(0,0,1000,600);
		getContentPane().add(jp);
		setSize(1000,700);
		setLocation(200,130);
		getContentPane().setLayout(null);
		
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new MyPaymentHistory();
	}

}
