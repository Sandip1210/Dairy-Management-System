package com.userinterface;
import javax.swing.*;


import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import static com.userinterface.AddMilk.*;


public class CustomerMilkReceipt extends JFrame implements ActionListener{
	JButton btnNewButton;
	static LocalDate date=LocalDate.now();
	static LocalTime time=LocalTime.now();
	String date1;
	int count=0;
	AllMethods am=new AllMethods();
	ConnectionDemo cd=new ConnectionDemo();
	CustomerMilkReceipt()
	{
		
		try
		{
			cd.st.executeUpdate("insert into daily_milk_record  values("+id+",'"+date+"','"+time+"','"+name+"',"+liter+","+fat+","+degree+","+am.rateCalculate()+","+am.totalRsCalculate()+")");
//			cd.rs=cd.st.executeQuery("select date from daily_record where date='"+date+"'");
//			if(cd.rs.next())
//			{
//				count++;
//			    date1=cd.rs.getString(1);
//				
//			}
//			if(count!=0)
//			{
//				cd.st.executeUpdate("insert into daily_record values()");
//			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		 
		 JLabel lblNewLabel = new JLabel("Date:-");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel.setBounds(96, 99, 103, 24);
		 getContentPane().add(lblNewLabel);
		 
		 JLabel lblTime = new JLabel("Time:-");
		 lblTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblTime.setBounds(407, 99, 103, 24);
		 getContentPane().add(lblTime);
		 
		 JLabel lblId = new JLabel("Id:-");
		 lblId.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblId.setBounds(96, 151, 103, 24);
		 getContentPane().add(lblId);
		 
		 JLabel lblName = new JLabel("Name:-");
		 lblName.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblName.setBounds(407, 151, 103, 24);
		 getContentPane().add(lblName);
		 
		 JLabel lblLitre = new JLabel("Litre:-");
		 lblLitre.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblLitre.setBounds(96, 199, 103, 24);
		 getContentPane().add(lblLitre);
		 
		 JLabel lblFat = new JLabel("Fat:-");
		 lblFat.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblFat.setBounds(407, 199, 103, 24);
		 getContentPane().add(lblFat);
		 
		 JLabel lblDegree = new JLabel("Degree:-");
		 lblDegree.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblDegree.setBounds(96, 250, 103, 24);
		 getContentPane().add(lblDegree);
		 
		 JLabel lblRate = new JLabel("Rate:-");
		 lblRate.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblRate.setBounds(407, 250, 103, 24);
		 getContentPane().add(lblRate);
		 
		 JLabel lblTotalRs = new JLabel("Total Rs:-");
		 lblTotalRs.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblTotalRs.setBounds(96, 298, 103, 24);
		 getContentPane().add(lblTotalRs);
		 
		 JLabel lblNewLabel_1 = new JLabel(""+date);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_1.setBounds(163, 99, 103, 24);
		 getContentPane().add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel(""+time);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_2.setBounds(483, 99, 103, 24);
		 getContentPane().add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel(name);
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_3.setBounds(483, 151, 103, 24);
		 getContentPane().add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel(""+fat);
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_4.setBounds(483, 199, 103, 24);
		 getContentPane().add(lblNewLabel_4);
		 
		 JLabel lblNewLabel_5 = new JLabel(""+am.rateCalculate());
		 lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_5.setBounds(483, 250, 103, 24);
		 getContentPane().add(lblNewLabel_5);
		 
		 JLabel lblNewLabel_6 = new JLabel(""+am.totalRsCalculate());
		 lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_6.setBounds(194, 298, 103, 24);
		 getContentPane().add(lblNewLabel_6);
		 
		 JLabel lblNewLabel_7 = new JLabel(""+degree);
		 lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_7.setBounds(194, 250, 103, 24);
		 getContentPane().add(lblNewLabel_7);
		 
		 JLabel lblNewLabel_8 = new JLabel(""+liter);
		 lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_8.setBounds(163, 199, 103, 24);
		 getContentPane().add(lblNewLabel_8);
		 
		 JLabel lblNewLabel_9 = new JLabel(""+id);
		 lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblNewLabel_9.setBounds(163, 151, 103, 24);
		 getContentPane().add(lblNewLabel_9);
		 
		 JLabel lblTodaysMilkRecord = new JLabel("Todays Milk Record");
		 lblTodaysMilkRecord.setFont(new Font("Tahoma", Font.BOLD, 17));
		 lblTodaysMilkRecord.setBounds(248, 41, 182, 24);
		 getContentPane().add(lblTodaysMilkRecord);
		 
		  btnNewButton = new JButton("print");
		 btnNewButton.addActionListener(this);
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		 btnNewButton.setBounds(291, 378, 85, 34);
		 getContentPane().add(btnNewButton);
		 
		    setSize(700,500);
			getContentPane().setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerMilkReceipt();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==btnNewButton)
		{
			JOptionPane.showMessageDialog(this,"Milk Successfully Added");
			setVisible(false);
		}
	}
}
