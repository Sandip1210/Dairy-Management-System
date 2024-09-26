package com.userinterface;
import java.awt.SystemColor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.userinterface.CustomerMilkReceipt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class AddMilk extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton add;
	static String name;
	static float liter,fat,degree ;
	static int id;
	int maxid;
	ConnectionDemo cd=new ConnectionDemo();
	
	AddMilk()
	{
		
		
		 JLabel lblNewLabel = new JLabel("Add Milk");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		 lblNewLabel.setBounds(339, 32, 283, 48);
		 getContentPane().add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Customer Id");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1.setBounds(23, 118, 186, 36);
		 getContentPane().add(lblNewLabel_1);
		 
		 textField = new JTextField();
		 textField.setBounds(177, 118, 186, 36);
		 getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_1_1 = new JLabel("Milk In Litre");
		 lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1_1.setBounds(436, 118, 186, 36);
		 getContentPane().add(lblNewLabel_1_1);
		 
		 textField_1 = new JTextField();
		 textField_1.setColumns(10);
		 textField_1.setBounds(590, 118, 186, 36);
		 getContentPane().add(textField_1);
		 
		 JLabel lblNewLabel_1_2 = new JLabel("Milk Fat");
		 lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1_2.setBounds(23, 192, 186, 36);
		 getContentPane().add(lblNewLabel_1_2);
		 
		 textField_2 = new JTextField();
		 textField_2.setColumns(10);
		 textField_2.setBounds(177, 192, 186, 36);
		 getContentPane().add(textField_2);
		 
		 JLabel lblNewLabel_1_1_1 = new JLabel("Degree");
		 lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1_1_1.setBounds(436, 192, 186, 36);
		 getContentPane().add(lblNewLabel_1_1_1);
		 
		 textField_3 = new JTextField();
		 textField_3.setColumns(10);
		 textField_3.setBounds(590, 192, 186, 36);
		 getContentPane().add(textField_3);
		 
		 add= new JButton("add");
		 add.setBackground(new Color(255, 128, 128));
		 add.setFont(new Font("Tahoma", Font.BOLD, 20));
		 add.setBounds(339, 281, 128, 48);
		 add.addActionListener(this);
		 getContentPane().add(add);
		 
			getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
			getContentPane().setBackground(SystemColor.activeCaption);
			getContentPane().setLayout(null);
			 setSize(800,600);
			 setLocation(400,150);
			 setResizable(false);
			 setVisible(true);
			 
		
			 
			 
			 
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==add)
		{
			 id=Integer.parseInt(textField.getText());
			 liter=Float.parseFloat(textField_1.getText());
			 fat=Float.parseFloat(textField_2.getText());
			 degree=Float.parseFloat(textField_3.getText());
			 try
			 {
				 cd.rs=cd.st.executeQuery("select max(cust_id) from scustomer_details ");
				 while(cd.rs.next())
				 {
					 maxid=cd.rs.getInt(1);
				 }
			 }catch (Exception e) {
				// TODO: handle exception
			}
			 if(maxid>=1 && maxid>=id)
			 {
			 try {
				 cd.rs=cd.st.executeQuery("select cust_name from scustomer_details where cust_id="+id+"");
				 if(cd.rs.next())
				 {
					 name=cd.rs.getString(1);
				 }
				 new CustomerMilkReceipt();
					setVisible(false);
				 
				 
			 }catch (Exception e) {
				 System.out.println(e);
				// TODO: handle exception
			}
			
		}
		
		else
		{
			JOptionPane.showMessageDialog(this,"Plz Enter Valid Id");
		}
		
		}
	}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	             new AddMilk();
		}
	}

