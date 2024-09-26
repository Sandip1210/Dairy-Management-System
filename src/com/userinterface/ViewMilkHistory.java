package com.userinterface;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static com.userinterface.LoginPage.*;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class ViewMilkHistory extends JFrame implements ActionListener {
	Choice choiceempid;
	JDateChooser dateChooser ;
	JTable table;
	double count,tliter;
	int totalrs,dt;
	JButton print;
	static Date date;
	String bdate;
	int id;
	static LocalDate ldt;
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	ConnectionDemo cd1=new ConnectionDemo();
	ViewMilkHistory()
	{
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
		String query1="select *from daily_milk_record where cust_id="+id+"";
		try {
			 cd1.rs=cd1.st.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		
		getContentPane().setBackground(new Color(100,131,122));
		dateChooser = new JDateChooser();
		 dateChooser.setBounds(462, 14, 211, 35);
		 dateChooser.setDateFormatString("yyyy-MM-dd");
		 getContentPane().add(dateChooser);
		JLabel lblDateOfBirth=new JLabel("Search Specific Day Milk Record: ");
		lblDateOfBirth.setForeground(SystemColor.desktop);
		 lblDateOfBirth.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblDateOfBirth.setBounds(160, 14, 273, 46);
		 getContentPane().add(lblDateOfBirth);
		getContentPane().add(lblDateOfBirth);
		try {
			
			 cd1.rs=cd1.st.executeQuery("select * from scustomer_details");
			while(cd1.rs.next()) {
				//System.out.println("1");
				//choiceempid.add(cd1.rs.getString("date"));
				
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		/*To fetch Employee id's from table and add to the dropdown*/

//		try {
//			 cd1.rs=cd1.st.executeQuery("select *  from scustomer_details");
//			//To convert data of resultset into the table
//			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	JScrollPane jp=new JScrollPane(table);
	jp.setBounds(0,100,1000,600);
	getContentPane().add(jp);

	print=new JButton("view");
	print.setBounds(378,66,80,25);
	print.setBackground(new Color(255, 0, 128));
	print.setFont(f);
	getContentPane().add(print);
	print.addActionListener(this);

		setSize(1000,700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ViewMilkHistory();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==print)
		{
			
			bdate=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
			System.out.println(id);
			String query="select *from daily_milk_record where date='"+bdate+"' and cust_id="+id+"";
			try {
				 cd1.rs=cd1.st.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		
	}

}
