package com.userinterface;
import java.awt.*;


import javax.swing.*;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.*;
import java.awt.event.*;
import java.sql.*;


public class ViewCustomer extends JFrame implements ActionListener{
	Choice choiceempid;
	JTable table;
	JButton bsearch,print,update;
	Font f1=new Font("SAN_SERIF",Font.BOLD,15);
	Font f=new Font("SAN_SERIF",Font.BOLD,13);
	ConnectionDemo cd1=new ConnectionDemo();
public ViewCustomer() {
	
	getContentPane().setBackground(new Color(100,131,122));
	
	JLabel search=new JLabel("Search By Employee Id : ");
	search.setBounds(320,20,190,20);
	search.setFont(f1);
	getContentPane().add(search);
	
	choiceempid=new Choice();
	choiceempid.setBounds(530,20,150,25);
	choiceempid.setFont(f1);
	choiceempid.add(""+101);
	getContentPane().add(choiceempid);
	try {
		
		 cd1.rs=cd1.st.executeQuery("select * from scustomer_details");
		while(cd1.rs.next()) {
			//System.out.println("1");
			choiceempid.add(cd1.rs.getString("cust_id"));
			
		}
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	/*To fetch Employee id's from table and add to the dropdown*/
	table=new JTable();
	try {
		 cd1.rs=cd1.st.executeQuery("select *  from scustomer_details");
		//To convert data of resultset into the table
		table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
	}catch(Exception e) {
		e.printStackTrace();
	}
	
JScrollPane jp=new JScrollPane(table);
jp.setBounds(0,100,1000,600);
getContentPane().add(jp);
	
bsearch=new JButton("view details");
bsearch.setBounds(20,70,109,25);
bsearch.setBackground(new Color(255,50,100));
bsearch.setFont(f);
getContentPane().add(bsearch);

update=new JButton("payment details");
update.setBounds(144,70,142,25);
update.setBackground(new Color(255,50,100));
update.setFont(f);
getContentPane().add(update);

print=new JButton("Print");
print.setBounds(302,70,80,25);
print.setBackground(new Color(255,50,100));
print.setFont(f);
getContentPane().add(print);

bsearch.addActionListener(this);
update.addActionListener(this);
print.addActionListener(this);

	setSize(1000,700);
	getContentPane().setLayout(null);
	setLocationRelativeTo(null);
	setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	 if(e.getSource()==bsearch) {
		String query="select *from scustomer_details where cust_id='"+choiceempid.getSelectedItem()+"'";
		try {
			 cd1.rs=cd1.st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
			
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	else if(e.getSource()==print) {
		try {
			table.print();
		}catch(Exception E) {
			E.printStackTrace();
		}
	}
	 if(e.getSource()==update)
	 {
			String query="select *from payment_history where cust_id='"+choiceempid.getSelectedItem()+"'";
			try {
				 cd1.rs=cd1.st.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(cd1.rs));
				
			}catch(Exception E) {
				E.printStackTrace();
			}
		 
	 }
//	else if(e.getSource()==update) {
//		setVisible(false);
//		new UpdateEmployee();
//	}
//	else if(e.getSource()==back) {
//			setVisible(false);
//			new Home();
//		}
//	
}

	public static void main(String[] args) {
	new ViewCustomer();	
	}
	

}


