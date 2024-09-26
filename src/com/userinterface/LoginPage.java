package com.userinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginPage extends JFrame {
	JLabel emailid, pass;
	JTextField t1, t2, t3;
	private JTextField textField;
	private JTextField textField_1;
	JRadioButton rdbtnNewRadioButton, rdbtnUser;
	JFrame f;
	static  String adharno;
	ConnectionDemo cd1=new ConnectionDemo();

	LoginPage()
	 {
           getContentPane().setLayout(null);
         
		 JLabel lblNewLabel = new JLabel("Enter ld:-");
		 lblNewLabel.setForeground(new Color(0, 0, 0));
		 lblNewLabel.setBackground(new Color(255, 255, 255));
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel.setBounds(887, 317, 109, 32);
		 getContentPane().add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		textField.setText("");
		 	}
		 });
		 textField.setBounds(1021, 322, 171, 32);
		 getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblPassword = new JLabel("Password:-");
		 lblPassword.setForeground(new Color(0, 0, 0));
		 lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblPassword.setBounds(887, 376, 120, 32);
		 getContentPane().add(lblPassword);
		 
		 textField_1 = new JTextField();
		 textField_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		
		 		textField_1.setText("");
		 	}
		 });
		 textField_1.setColumns(10);
		 textField_1.setBounds(1021, 376, 171, 32);
		 getContentPane().add(textField_1);
		 
		 JLabel lblUserLogin = new JLabel("Login here");
		 lblUserLogin.setBackground(new Color(0, 0, 0));
		 lblUserLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblUserLogin.setBounds(1007, 175, 126, 32);
		 getContentPane().add(lblUserLogin);
		 
		 JButton btnNewButton = new JButton("login");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent ae) {
		 		
		 		if(rdbtnNewRadioButton.isSelected())
		 		{
		 			
		 		     if(textField.getText().trim().length()>0)
		 	         {   
		 	           if(textField_1.getText().trim().length()>0)
		 	              {
		 	                  if("Admin2024".equals(textField.getText()))
		 	                   {

		 	                    if("Admin@123".equals(textField_1.getText()))
		 	                     {
		 	                        new MainPage();
		 	                        dispose();
		 	                                  }
		 	                 else
		 	                  JOptionPane.showMessageDialog(null,"Invalid Password");

		 	                        }
		 	           else
		 	           {
		 	               JOptionPane.showMessageDialog(null,"Invalid LoginId");
		 	                 }

		 	           }
		 	     else
		 	      {
		 	        JOptionPane.showMessageDialog(null,"Plz Enter Password");
		 	          }

		 	   }
		 	else
		 	{
		 	JOptionPane.showMessageDialog(null,"Plz Enter LoginId");
		 	}
		 	
		 		
		 		
		 		}
		 		
		 		else if(rdbtnUser.isSelected())
		 		{
		 		
		 			try
		 			{
		 			if(textField.getText().trim().length()>0)
		 			{
		 			if(textField_1.getText().trim().length()>0)
		 			{
		 			 cd1.rs=cd1.st.executeQuery("select password from login where adhar_no='"+ textField.getText()+"'");
		 			 if(cd1.rs.next())
		 			{
		 			if(cd1.rs.getString(1).equals(textField_1.getText()))
		 			{
		 			        new UserPage();
		 				//JOptionPane.showMessageDialog(null,"Successfully");
		 				adharno=textField.getText();
		 			     dispose();
		 			}
		 			else
		 			JOptionPane.showMessageDialog(null,"Invalid Password");

		 			}
		 			else
		 			{
		 			JOptionPane.showMessageDialog(null,"Invalid User Name");
		 			}

		 			}
		 			else
		 			{
		 			JOptionPane.showMessageDialog(null,"Plz Enter Password");
		 			}

		 			}
		 			else
		 			{
		 			JOptionPane.showMessageDialog(null,"Plz Enter User name");
		 			}
		 			}
		 			catch(Exception e)
		 			{
		 			JOptionPane.showMessageDialog(null,"Error is="+e);
		 			}
		 			}
		 			
		 		else {
		 			JOptionPane.showMessageDialog(null, "Please select Admin or User");	
		 		}
		 		
		 		
		 	}
		 });btnNewButton.setBackground(new Color(0,128,192));btnNewButton.setFont(new Font("Tahoma",Font.BOLD,18));btnNewButton.setBounds(930,479,102,32);

	getContentPane().add(btnNewButton);
		 
		 JButton btnClear = new JButton("clear");
		 btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		 btnClear.setBackground(new Color(0, 128, 192));
		 btnClear.setBounds(1053, 479, 102, 32);
		 getContentPane().add(btnClear);
	
		 JLabel lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setForeground(new Color(0, 0, 0));
		 lblNewLabel_1.setBounds(773, 276, 597, 29);
		 getContentPane().add(lblNewLabel_1);
		 
		 
	      ButtonGroup bg=new ButtonGroup();
	      
	      
	       rdbtnNewRadioButton = new JRadioButton("Admin");
	       rdbtnNewRadioButton.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		lblNewLabel_1.setText("");
	       		textField.setText("Please Enter admin id here");
	       	}
	       });
	      rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	      rdbtnNewRadioButton.setBounds(913, 230, 110, 40);
	      bg.add(rdbtnNewRadioButton);
	      
	       rdbtnUser = new JRadioButton("User");
	       rdbtnUser.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		textField.setText("Please Enter User AdharId here");
	       		lblNewLabel_1.setText("Note: In case of first login user can login by Password: Cow@123 After login please change the password");
	       	}
	       });
	      rdbtnUser.setFont(new Font("Tahoma", Font.BOLD, 20));
	      rdbtnUser.setBounds(1066, 230, 110, 40);
	      bg.add(rdbtnUser);
	 
	      getContentPane().add(rdbtnNewRadioButton);
	      getContentPane().add(rdbtnUser);

			 JLabel lblNewLabel_2 = new JLabel("Dairy Management System");
			 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
			 lblNewLabel_2.setBounds(751, 55, 663, 47);
			 getContentPane().add(lblNewLabel_2);
	    
	      
			 setSize(1600,1000);
			 getContentPane().setLayout(null);
			 
			 
			 setVisible(true);

		        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("img/loginimg.jpg"));
				 Image i2=i1.getImage().getScaledInstance(1600,850,Image.SCALE_DEFAULT);
				 ImageIcon i3=new ImageIcon (i2);
				 JLabel l=new JLabel(i3);
				 l.setBackground(new Color(255, 255, 255));
				 l.setBounds(29,10,1600,850);
				 getContentPane().add(l);
				 
		 
	 }

	public static void main(String[] args) {
		
          new LoginPage();
	}
}
