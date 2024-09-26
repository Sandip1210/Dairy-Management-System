package com.userinterface;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {
	
	public UserPage()
	{
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setForeground(new Color(176, 224, 230));
		setSize(1600,850);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(40, 40, 1458, 49);
		getContentPane().add(menuBar);
		menuBar.setForeground(new Color(64, 224, 208));
		menuBar.setBackground(SystemColor.controlHighlight);
		
		JMenu mnMenu = new JMenu("menu");
		mnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		mnMenu.setFont(new Font("Arial", Font.BOLD, 16));
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("LOG OUT");
		mnMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoginPage();			
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Change Password");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePassword();
			}
		});
		menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 16));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View Milk History");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//milk history
				new ViewMilkHistory();
				}
		});
		menuBar.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("My Payment History");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Payment History
				new MyPaymentHistory();
			}
		});
		menuBar.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.BOLD, 16));
		mntmNewMenuItem_2.setForeground(new Color(0, 0, 0));
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new UserPage();
	}
}
