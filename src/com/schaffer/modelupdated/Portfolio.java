package com.schaffer.modelupdated;

import java.util.Date;

public class Portfolio {
	
		private final static int MAX_PORTFOLIO_SIZE = 5;
		
		String title;
		
		private stock[] stocks;
		int portfolioSize = 0;
				
		public  Portfolio(String title) {
			stocks = new stock[MAX_PORTFOLIO_SIZE];
			this.title = title;
		}

		public void addStock(stock stk) {
			
			if(stk != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
				this.stocks[this.portfolioSize] = stk;
				this.portfolioSize++;
			}else {
				System.out.println("Sorry, stock is full, or is stock is null!");
			}
		}
			
			public stock[] getStock(){
				return this.stocks;
			}
			
			public String getHtmlString(Portfolio portfolio) {
				
				String str = new String( "<h1>" + this.title + "</h1>" + "<br/>" );
				
				for(int i = 0; i < this.portfolioSize ;i++) {
					str = str + stocks[i].getHtmlDescription() + "<br>";
				}
				
				return str;
			}
		}		
		

