package com.userinterface;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class Payment extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	String date1="24-09-09",date2;
	JButton btnNewButton;
	ConnectionDemo cd1=new ConnectionDemo();
	Double payment;
	String name;
	JButton btnView;
	int count=0;
	int maxid;
	JDateChooser dateChooser;
	Payment()
	{
		getContentPane().setBackground(new Color(128, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(293, 42, 424, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Customer Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(107, 143, 206, 38);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(347, 146, 189, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Starting Date:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(107, 209, 206, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 212, 189, 35);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("End Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(107, 267, 206, 38);
		getContentPane().add(lblNewLabel_1_2);
		
		 btnNewButton = new JButton("make payment");
	//	btnNewButton.setBackground(new Color(64, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(283, 369, 206, 48);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		getContentPane().setLayout(null);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(347, 267, 189, 38);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		getContentPane().add(dateChooser);
		
		 btnView = new JButton("view");
		btnView.setBackground(new Color(255, 255, 255));
		btnView.addActionListener(this);
		btnView.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnView.setBounds(583, 143, 114, 48);
		getContentPane().add(btnView);
		 setSize(800,600);
		 setLocation(400,150);
		 setVisible(true);
		 setResizable(false);
		 
//		 
//		 try {
//			 cd1.rs=cd1.st.executeQuery("select * from payment_history where cust_id="+id+"; ");
//			 while(cd1.rs.next())
//				{
//					date1=cd1.rs.getString("ldate");
//					
//				}
//			 System.out.println(date1);
//				textField_1.setText(date1);
//				textField_1.setEditable(false);
//		 }catch (Exception e) {
//			System.out.println(e);
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Payment();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnView)
		{
			textField_1.setText("");
		int id=Integer.parseInt(textField.getText());
		 try {
			 
			 cd1.rs=cd1.st.executeQuery("select max(cust_id)from daily_milk_record");
			 while(cd1.rs.next())
				{
					maxid=cd1.rs.getInt(1);
					
				}
			 if(id>=1 && id<=maxid )
			 {
			 
			 cd1.rs=cd1.st.executeQuery("select * from payment_history where cust_id="+id+"; ");
			 while(cd1.rs.next())
				{
					date1=cd1.rs.getString("ldate");
					
				}
			 System.out.println(date1);
				textField_1.setText(date1);
				textField_1.setEditable(false);
		 }

		 else
			 JOptionPane.showMessageDialog(this,"Plz Enter valid Id");
		 }
			 catch (Exception e) {
			System.out.println(e);
		}
		}
		// TODO Auto-generated method stub
		if(ae.getSource()==btnNewButton)
		{
			payment=0.0;
			try
			{
				
				
			
			date2=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			cd1.rs=cd1.st.executeQuery("select * from payment_history where cust_id="+Integer.parseInt(textField.getText())+" AND sdate='"+date1+"'  AND ldate='"+date2+"' ");
			while(cd1.rs.next())
			{
				count++;
			}
			if(count==0)
			{
			cd1.rs=cd1.st.executeQuery("select * from daily_milk_record where cust_id="+Integer.parseInt(textField.getText())+" AND date>='"+date1+"'  AND date<='"+date2+"'");
			while(cd1.rs.next())
			{
				payment=payment+cd1.rs.getInt("totalrs");
				name=cd1.rs.getString("name");
			}
			cd1.st.executeUpdate("insert into payment_history values("+Integer.parseInt(textField.getText())+",'"+date1+"','"+date2+"','"+name+"',"+payment+")");
			JOptionPane.showMessageDialog(this,"Customer Id="+textField.getText()+"\nTotal Rs="+payment+"\nPayment Sucessfully Done");
			setVisible(false);
			}
			
			else
				JOptionPane.showMessageDialog(this,"Payment already done");
			}
			catch (Exception e) {
				// TODO: handle exception	
				System.out.println(e);
			}
			
		}
		//date1=date2;
	}
}
