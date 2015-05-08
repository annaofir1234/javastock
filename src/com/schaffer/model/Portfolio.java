package com.schaffer.model;

import com.schaffer.modelupdated.stock;

public class Portfolio {
	
		private final static int MAX_PORTFOLIO_SIZE = 5;
		String title;
		private stock[] stocks;
		int portfolioSize = 0;
		
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
		
		//Constructor
	 	public Portfolio(String title){
		
			this.stocks= new stock[MAX_PORTFOLIO_SIZE];
	 		this.title= title;
	 		this.portfolioSize=0;
	 	}
		
	 	//copy constructor
		public Portfolio(Portfolio portfolio){
		
			setTitle(portfolio.getTitle());
			setPortfolioSize(portfolio.getPortfolioSize());
			this.stocks= new stock[MAX_PORTFOLIO_SIZE];
			
			for(int i=0; i<this.portfolioSize; i++){
					this.stocks[i]= new stock(portfolio.getStock()[i]);		
			}		
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
		 
		 public void removeStock(String symbol) {
			  if (portfolioSize == 1 || symbol.equals(stocks[portfolioSize-1].getSymbol())){
				  stocks[portfolioSize-1] = null;
				  portfolioSize--;
				  return;
			  }
			  for (int i = 0; i < portfolioSize; i++){
				  if (symbol == null){
				return;
			   }
			   else if (symbol.equals(stocks[i].getSymbol()))
			   {
			    stocks[i] = stocks[portfolioSize - 1];
			    stocks[portfolioSize - 1] =null;
			    portfolioSize--;
			   }
			  }
			  return;
			 }
}
