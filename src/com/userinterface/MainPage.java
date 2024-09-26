package com.userinterface;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class MainPage extends JFrame implements ActionListener {
	
	JButton b1,b2,b3,b4,b5,searchRoom,searchCustomer;
	MainPage()
	{
		        
		

	

		        b1=new JButton();
		        b1.setText("Add Customer");
		        b1.setForeground(Color.WHITE);
		        b1.setBackground(Color.black);
		        b1.setBounds(10,171,150,40);
		        b1.addActionListener(this);
		        getContentPane().add(b1);

		        b2=new JButton();
		        b2.setText("Dail Milk Record");
		        b2.setForeground(Color.WHITE);
		        b2.setBackground(Color.black);
		        b2.setBounds(10,231,150,40);
		        b2.addActionListener(this);
		        getContentPane().add(b2);

		        b3=new JButton();
		        b3.setText("Add Milk");
		        b3.setForeground(Color.WHITE);
		        b3.setBackground(Color.black);
		        b3.setBounds(10,291,150,40);
		        b3.addActionListener(this);
		        getContentPane().add(b3);

		        b4=new JButton();
		        b4.setText("Pyment");
		        b4.setForeground(Color.WHITE);
		        b4.setBackground(Color.black);
		        b4.setBounds(10,351,150,40);
		        b4.addActionListener(this);
		        getContentPane().add(b4);

		        searchRoom=new JButton();
		        searchRoom.setText("Daily Record");
		        searchRoom.setForeground(Color.WHITE);
		        searchRoom.setBackground(Color.black);
		        searchRoom.setBounds(10,411,150,40);
		        searchRoom.addActionListener(this);
		        getContentPane().add(searchRoom);

		        searchCustomer=new JButton();
		        searchCustomer.setText("Customer Details");
		        searchCustomer.setForeground(Color.WHITE);
		        searchCustomer.setBackground(Color.black);
		        searchCustomer.setBounds(10,471,150,40);
		        searchCustomer.addActionListener(this);
		        getContentPane().add(searchCustomer);

		        b5=new JButton();
		        b5.setText("Logout");
		        b5.setForeground(Color.WHITE);
		        b5.setBackground(Color.black);
		        b5.setBounds(10,531,150,40);
		        b5.addActionListener(this);
		        getContentPane().add(b5);
		        
		        getContentPane().setLayout(null);
		        
		        setBounds(0,0,1600,850);
		        setVisible(true);
		        
		         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/cow.png"));
				 Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);
				 ImageIcon i3=new ImageIcon (i2);
				 JLabel l=new JLabel(i3);
				 l.setBounds(0,0,1600,850);
				 getContentPane().add(l);
		       
				

		    }
		    @Override
		    public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1)
			new AddCustomer();
		if(ae.getSource()==b2)
			new DailyMilkRecord();
		if(ae.getSource()==b3)
			new AddMilk();
		if(ae.getSource()==b4)
			new Payment();
		if(ae.getSource()==b5)
		{
			setVisible(false);
			new LoginPage();
		}
			
		if(ae.getSource()==searchRoom)
			new DailyRecord();
		if(ae.getSource()==searchCustomer)
			new ViewCustomer();

		    }

	

		

	

	
		 

	
	public static void main(String args[])
	{
		new MainPage();
	}
}
