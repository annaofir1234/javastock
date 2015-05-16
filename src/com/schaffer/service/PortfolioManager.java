package com.schaffer.service;

import java.util.Date;
import java.util.Calendar;

import com.schaffer.model.Portfolio;
import com.schaffer.model.stock;

public class PortfolioManager {
	
	public Portfolio getPortfolio(){
			
		Portfolio myPortfolio= new Portfolio("<h>"+"Exercise 07 Portfolio: "+"<h>");
		 myPortfolio.setBalance(10000);
			
		Calendar c= Calendar.getInstance();
		c.set(2014, 10, 15);
			
		Date date1 = c.getTime();
		stock stock1= new stock("PIH",(float) 10.0,(float) 8.5,date1);
		
		Date date2 = c.getTime();
		stock stock2= new stock("AAL",(float) 30.0, (float) 25.5, date2);
		
		Date date3 = c.getTime();
		stock stock3= new stock("CAAS",(float) 20.0, (float) 15.5, date3);
		
		myPortfolio.buyStock(stock1,20);
		myPortfolio.buyStock(stock2,30);
		myPortfolio.buyStock(stock3,40);
		
		myPortfolio.sellStock("AAL", -1);
		
		myPortfolio.removeStock("CAAS");
		
		return myPortfolio;
	}
}

