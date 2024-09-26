package com.userinterface;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class DailyRecord extends JFrame implements ActionListener {
	Choice choiceempid;
	JDateChooser dateChooser ;
	JTable table;
	double count,tliter;
	int totalrs,dt;
	JButton print;
	static Date date;
	String bdate;
	static LocalDate ldt;
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	ConnectionDemo cd1=new ConnectionDemo();
	DailyRecord()
	{
		table=new JTable();
		
		String query1="select *from daily_record ";
		try {
			 cd1.rs=cd1.st.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
			
		}catch(Exception E) {
			E.printStackTrace();
		}
		
		
		getContentPane().setBackground(new Color(100,131,122));
		dateChooser = new JDateChooser();
		 dateChooser.setBounds(427, 14, 211, 35);
		 dateChooser.setDateFormatString("yyyy-MM-dd");
		 getContentPane().add(dateChooser);
		JLabel lblDateOfBirth=new JLabel("Select date: ");
		lblDateOfBirth.setForeground(SystemColor.desktop);
		 lblDateOfBirth.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblDateOfBirth.setBounds(257, 10, 156, 46);
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
	print.setBounds(437,59,80,25);
	print.setBackground(new Color(255, 0, 128));
	print.setFont(f);
	getContentPane().add(print);
	print.addActionListener(this);

		setSize(1000,700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		 if(ae.getSource()==print) {
			 count=0;
			 tliter=0;
			 dt=0;
			 totalrs=0;
			 
			 bdate=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				//date=new Date();
				//DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd");

				try
				{
					cd1.rs=cd1.st.executeQuery("select * from daily_record where date='"+bdate+"' ");
					while(cd1.rs.next())
					{
						
						dt++;
					}
				
					System.out.println(bdate);
					cd1.rs=cd1.st.executeQuery("select * from daily_milk_record where date='"+bdate+"' ");
					while(cd1.rs.next())
					{
						totalrs=totalrs+cd1.rs.getInt("totalrs");
						tliter=tliter+Double.parseDouble(cd1.rs.getString("qty"));
						count++;
						
					}
			
					if(dt==0)
					{
					cd1.st.executeUpdate("insert into daily_record values('"+bdate+"',"+count+","+tliter+","+totalrs+")");
				
					}
					else
					{
						cd1.st.executeUpdate("update daily_record set total_cust="+count+",total_milk="+tliter+", total_rs="+totalrs+" where date='"+bdate+"'  ");
					}
				}
				
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
				 
			String query="select *from daily_record where date='"+bdate+"'";
			try {
				 cd1.rs=cd1.st.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
//		else if(e.getSource()==print) {
//			try {
//				table.print();
//			}catch(Exception E) {
//				E.printStackTrace();
//			}
//		}
//		else if(e.getSource()==update) {
//			setVisible(false);
//			new UpdateEmployee();
//		}
//		else if(e.getSource()==back) {
//				setVisible(false);
//				new Home();
//			}
	//	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DailyRecord();

	}

}
