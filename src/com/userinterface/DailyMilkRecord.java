package com.userinterface;

import static com.userinterface.LoginPage.adharno;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DailyMilkRecord extends JFrame {
             JTable table;
             LocalDate ldt;
             ConnectionDemo cd1=new ConnectionDemo();
	public DailyMilkRecord() {
		table=new JTable();
		
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 ldt=LocalDate.now();
		String query1="select *from daily_milk_record where date='"+ldt+"'";
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
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new DailyMilkRecord();
	}

}
