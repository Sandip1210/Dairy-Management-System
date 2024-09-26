package com.userinterface;
import javax.swing.*;

import java.awt.event.*;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.time.*;
import java.time.format.*;
public class AddCustomer extends JFrame implements ActionListener  {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static String cname,cno,cadhar,bdate;
	JButton btnNewButton;
	JDateChooser dateChooser ;
	static Date date;
	static LocalDateTime ldt;
	int id,count1,number,count2,adhar,count3;
	ConnectionDemo cd1=new ConnectionDemo();
	private JTextField textField_3;
	AddCustomer()
	{
	
		JLabel lblNewLabel_1 = new JLabel("Customer Details");
		 lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 25));
		 lblNewLabel_1.setBounds(272, 17, 355, 46);
		 getContentPane().add(lblNewLabel_1); 
		 
		 JLabel lblNewLabel = new JLabel("Customer Name");
		 lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblNewLabel.setForeground(SystemColor.desktop);
		 lblNewLabel.setBounds(209, 125, 156, 46);
		 getContentPane().add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		 textField.setForeground(SystemColor.infoText);
		 textField.setBackground(SystemColor.inactiveCaptionBorder);
		 textField.setBounds(379, 128, 211, 35);
		 getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 textField_1 = new JTextField();
		 textField_1.setForeground(SystemColor.infoText);
		 textField_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		 textField_1.setColumns(10);
		 textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		 textField_1.setBounds(379, 184, 211, 35);
		 getContentPane().add(textField_1);
		 
		 JLabel lblMobileNumber = new JLabel("Mobile Number");
		 lblMobileNumber.setForeground(SystemColor.desktop);
		 lblMobileNumber.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblMobileNumber.setBounds(209, 181, 156, 46);
		 getContentPane().add(lblMobileNumber);
		 
		 textField_2 = new JTextField();
		 textField_2.setForeground(SystemColor.infoText);
		 textField_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		 textField_2.setColumns(10);
		 textField_2.setBackground(SystemColor.inactiveCaptionBorder);
		 textField_2.setBounds(379, 242, 211, 35);
		 getContentPane().add(textField_2);
		 
		 JLabel lblAdharNumber = new JLabel("Aadhar Number");
		 lblAdharNumber.setForeground(SystemColor.desktop);
		 lblAdharNumber.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblAdharNumber.setBounds(209, 239, 156, 46);
		 getContentPane().add(lblAdharNumber);
		 
		  dateChooser = new JDateChooser();
		 dateChooser.setBounds(379, 299, 211, 35);
		 dateChooser.setDateFormatString("yyyy-MM-dd");
		 getContentPane().add(dateChooser);
		 
		 JLabel lblDateOfBirth = new JLabel("Date of Birth");
		 lblDateOfBirth.setForeground(SystemColor.desktop);
		 lblDateOfBirth.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		 lblDateOfBirth.setBounds(209, 295, 156, 46);
		 getContentPane().add(lblDateOfBirth);
		 
		  btnNewButton = new JButton("submit");
		 btnNewButton.setForeground(Color.BLACK);
		 btnNewButton.setBackground(Color.MAGENTA);
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 btnNewButton.setBounds(330, 380, 123, 35);
		 btnNewButton.addActionListener(this);
		 getContentPane().add(btnNewButton);
			getContentPane().setBackground(SystemColor.activeCaption);
			 getContentPane().setLayout(null);
			 
			 JLabel lblCustomerId = new JLabel("Customer Id");
			 lblCustomerId.setForeground(SystemColor.desktop);
			 lblCustomerId.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
			 lblCustomerId.setBounds(209, 73, 156, 46);
			 getContentPane().add(lblCustomerId);
			 
			 textField_3 = new JTextField();
			 textField_3.setForeground(SystemColor.infoText);
			 textField_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
			 textField_3.setColumns(10);
			 textField_3.setBackground(SystemColor.inactiveCaptionBorder);
			 textField_3.setBounds(379, 76, 211, 35);
			 getContentPane().add(textField_3);
			 setSize(800,600);
			 setLocation(400,150);
			 setVisible(true);
			
			 setResizable(false);
			 try {
				 cd1.rs=cd1.st.executeQuery("select MAX(cust_id) from scustomer_details");
				 while(cd1.rs.next())
				 {
					 id=cd1.rs.getInt(1);
				 }
				 
			 }
			 catch (Exception e) {
					
				}
			 textField_3.setText(""+(id+1));
			 
			 textField_3.setEditable(false);
			 
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		
		if(ae.getSource()==btnNewButton)
			
		{
			count1=0;
			number=0;
			adhar=0;
			count2=0;
			count3=0;
			cname=textField.getText();
			cno=textField_1.getText();
			cadhar=textField_2.getText();
			bdate=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			//date=new Date();

			if(cname.trim().length()==0)
			{
				JOptionPane.showMessageDialog(this, "Name is Requried");	
			
			}
			for(int i=0;i<cname.length();i++)
			{
		
				if( cname.charAt(i)=='0' || cname.charAt(i)=='1' ||cname.charAt(i)=='2' || cname.charAt(i)=='3'||cname.charAt(i)=='4' || cname.charAt(i)=='5'
						||cname.charAt(i)=='6' || cname.charAt(i)=='7'||cname.charAt(i)=='8' || cname.charAt(i)=='9')
				{
					count1++;
					JOptionPane.showMessageDialog(this, "Please Enter valid Name");	
					break;
					
				}
				
			}
			//mno validation
			if(cno.length()==10)
			{
			for(int i=0;i<cno.length();i++)
			{
			if(cno.charAt(i)>='0' && cno.charAt(i)<='9' )
				number++;
			}
			}
			
			if(number==10)
			{
				count2++;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Enter valid Mobile Number");	
			}
			
			//Adhar number validation
			if(cadhar.length()==12)
			{
			for(int i=0;i<cadhar.length();i++)
			{
			if(cadhar.charAt(i)>='0' && cadhar.charAt(i)<='9' )
				adhar++;
			}
			}
			
			if(adhar==12)
			{
				count3++;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Enter valid Aadhar Number");	
			}
				
			if(count1==0 && count2!=0 && count3!=0)
			{
			DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 ldt=LocalDateTime.now();
			
			try {
				id=id+1;
				cd1.insertCustomerData();
				cd1.st.executeUpdate("insert into login values("+(id)+",'"+cadhar+"','Cow@123')");
				
				JOptionPane.showMessageDialog(this, "Customer added succesfully");
				 setVisible(false);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCustomer();
	}
}
