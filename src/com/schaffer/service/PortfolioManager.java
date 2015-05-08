package com.schaffer.service;

import java.util.Date;
import java.util.Calendar;

import com.schaffer.model.Portfolio;
import com.schaffer.modelupdated.stock;

public class PortfolioManager {
	
	public Portfolio getPortfolio(){
			
		Portfolio myportfolio= new Portfolio("My Portfolio:"+ "<br/>");
			
		Calendar c= Calendar.getInstance();
		c.set(2014, 10, 15);
			
		Date date1 = c.getTime();
		stock stock1= new stock("PIH",(float) 13.1,(float) 12.4,date1 );
				
		Date date2 = c.getTime();
		stock stock2= new stock("AAL",(float) 5.78, (float) 5.5, date2);
			
		Date date3 = c.getTime();
		stock stock3= new stock("CAAS",(float) 32.2, (float) 31.5, date3);
		
		myportfolio.addStock(stock1);
		myportfolio.addStock(stock2);
		myportfolio.addStock(stock3);
		
		return myportfolio;
	}
}

