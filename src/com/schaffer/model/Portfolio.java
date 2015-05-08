package com.schaffer.model;

import com.schaffer.modelupdated.stock;
import java.util.Date;

public class Portfolio {
	
		private final static int MAX_PORTFOLIO_SIZE = 5;
		String title;
		private stock[] stocks;
		int portfolioSize = 0;
		
		//Constructor
	 	public Portfolio(String title){
		stocks= new stock[MAX_PORTFOLIO_SIZE];
		
			this.stocks= new stock[MAX_PORTFOLIO_SIZE];
	 		this.title= title;
	 		this.portfolioSize=0;
	 	}
		
	 	//copy constructor
		public Portfolio(Portfolio portfolio){
		
			this(portfolio.getTitle());
			setPortfolioSize(portfolio.getPortfolioSize());
				
			for(int i=0; i<this.portfolioSize; i++){
					stocks[i]= new stock(portfolio.getStock()[i]);		
			}		
		}
		
		//getters and Setters
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public stock[] getStocks() {
				return stocks;
		}
			
		public void setStocks(stock[] stocks) {
				this.stocks = stocks;
		}
			
		public int getPortfolioSize() {
				return portfolioSize;
		}
			
		public void setPortfolioSize(int portfolioSize) {
				this.portfolioSize = portfolioSize;
		}
				
		public void addStock(stock stk) {
			
			if(stk != null && this.portfolioSize < MAX_PORTFOLIO_SIZE) {
				this.stocks[this.portfolioSize] = stk;
				this.portfolioSize++;
			}else {
				System.out.println("Sorry, portfolio is full, or is portfolio is null!");
			}
		}
			
		public stock[] getStock(){
			return this.stocks;
			}
			
		 public String getHtmlString(Portfolio portfolio) {
				
				String str = new String( "<h1>" + this.title + "</h1>" + "<br/>" );
				
				for(int i = 0; i < this.portfolioSize ;i++) {
					str = str + this.stocks[i].getHtmlDescription()+ "<br/>" ;
				}
				return str;
		}	
		 
		 public void removeStock(stock stock)
		 {
		 	for(int i=0; i < portfolioSize; i++)
		 	{
		 		if(this.stocks[i].getSymbol().equals(stock.getSymbol()))
	            {	
					if(i != portfolioSize-1 && portfolioSize > 1)
						for(int j = i; j < portfolioSize-1; j++)
		 				{
								this.stocks[j] = new stock(this.stocks[j+1]);
		 				}
					}
				}
		 	this.portfolioSize--;
		}	
}
