package com.userinterface;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static com.userinterface.LoginPage.*;
import java.awt.*;

public class ChangePassword extends JFrame{
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	String oldpass;
    ConnectionDemo cd1=new ConnectionDemo();
	public ChangePassword() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Old Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 153, 215, 44);
		getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 262, 234, -10);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(375, 162, 201, 31);
		getContentPane().add(passwordField_1);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password:");
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterNewPassword.setBounds(150, 218, 215, 44);
		getContentPane().add(lblEnterNewPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(375, 227, 201, 31);
		getContentPane().add(passwordField_2);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try
				{
				 cd1.rs=cd1.st.executeQuery("select password from login where adhar_no='"+adharno+"'");
				while(cd1.rs.next())
				{
				oldpass=cd1.rs.getString(1);
				}

				System.out.println(oldpass);
				
				 //String password;
				//String pass=new String(password);
				
				System.out.println(passwordField_2.getText());
				if(passwordField_1.getText().equals(oldpass))
				{
				
				cd1.st.executeUpdate("update login set password='"+passwordField_2.getText()+"' where adhar_no='"+adharno+"'");
				JOptionPane.showMessageDialog(null,"Password changed");
				setVisible(false);
				}else
				{
					 JOptionPane.showMessageDialog(null,"Old pin does not match");
				}
				
				}
				catch (Exception e) {
					// TODO: andle exception
				  System.out.println(e);
				}
			}
			
			});
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(197, 305, 172, 44);
		getContentPane().add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancle.setBackground(SystemColor.info);
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancle.setBounds(386, 305, 172, 44);
		getContentPane().add(btnCancle);
		
		JLabel lblChangePasswordHere = new JLabel("Change Password Here");
		lblChangePasswordHere.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChangePasswordHere.setBounds(249, 67, 268, 44);
		getContentPane().add(lblChangePasswordHere);
		 setSize(800,600);
		 setLocation(400,150);
		 setResizable(false);
		 setVisible(true);
		// TODO Auto-generated constructor stub
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new ChangePassword();
	}

}
