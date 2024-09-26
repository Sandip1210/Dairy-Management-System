package com.userinterface;
import static com.userinterface.AddMilk.*;

public class AllMethods extends AbstractDemo {

	 Double rate;
	 Double trs;

	@Override
	double rateCalculate() {
		// TODO Auto-generated method stub
		if(fat>=4&& degree>=28)
			return rate=35.00;
		else if(fat>3.5 || degree>27)
			return rate=32.00;
		else
			return rate=30.00;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	double totalRsCalculate() {
		// TODO Auto-generated method stub
		
		return trs=rate*liter ;
	}

}
