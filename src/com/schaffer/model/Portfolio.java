package com.schaffer.model;

import java.util.Date;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.schaffer.model.stock.ALGO_RECOMMENDATION;

public class Portfolio implements PortfolioInterface {
		
		String title;
		private final static int MAX_PORTFOLIO_SIZE=5;
		private StockInterface[] stocks;
	    int portfolioSize=0;
	    
	    private float balance;
	    
	    public float getBalance() {
			return balance;
		}

		public void setBalance(float balance) {
			this.balance = balance;
		}

		//getters and Setters
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public StockInterface[] getStocks() {
			return stocks;
		}

		//public void setStocks(StockInterface[] stocks) {
		//	this.stocks = stocks;
		//}
		
		public void setStocks(StockInterface[] stocks) {
			this.stocks = stocks;
		}

		public int getPortfolioSize() {
			return portfolioSize;
		}

		public void setPortfolioSize(int portfolioSize) {
			this.portfolioSize = portfolioSize;
		}
		

		public static int getMaxPortfolioSize() {
			return MAX_PORTFOLIO_SIZE;
		}

	//Empty constructor
		public Portfolio (){
			stocks = (StockInterface[]) new stock [MAX_PORTFOLIO_SIZE];

	 	}
		
	//Constructor that gets stockaray
		
		public Portfolio(stock[] stockArray){
			// TODO Auto-generated constructor stub
			this();
			this.title= new String();
			this.portfolioSize=stockArray.length;
			this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
			this.balance=0;
			for(int i = 0; i<this.portfolioSize; i++){
	 			this.stocks[i]= (StockInterface) new stock ((stock)stockArray[i]);
			}
		}
		
		//Copy constructor
		public Portfolio(Portfolio portfolio){
		
			this.setTitle(portfolio.getTitle());
			setPortfolioSize(portfolio.getPortfolioSize());
			setBalance(portfolio.getBalance());
			
			this.setStocks(portfolio.stocks);
			
			for(int i=0; i<portfolio.getPortfolioSize(); i++){
				//stocks[i]= new Stock(portfolio.getStock()[i]);	
				stock tmp = new stock(((stock)portfolio.stocks[i]));
				this.addStock(tmp);
			}
			
		}
		
		//Constructor
	//	public Portfolio(String title){
	//	
	//		this();
	//		this.stocks= new Stock[MAX_PORTFOLIO_SIZE];
	//		this.title= title;
	//		this.portfolioSize=0;
	//		this.balance=0;
	//	}*/
		
	
		public void updateBalance(float amount){
			
				this.balance+=amount;
				
				if(this.balance<0)
				{
					this.balance=0;
				}
		}
		
		
		public void addStock(stock stk){
			
			if(this.portfolioSize== MAX_PORTFOLIO_SIZE){
				System.out.println("“Can’t add new stock, portfolio can have only "+ MAX_PORTFOLIO_SIZE+ " stocks”");
				 return;
			}
			
			else if (stk==null){
				System.out.println("“ERROR!- NULL sock received!”");
				 return;
			}
			else{
				for(int i=0; i<this.portfolioSize; i++)
				{
					if(stk.getSymbol().equals(this.stocks[i].getSymbol()))
					{
						System.out.println("The Stock already exsist in the Portfolio!");
						return;
					}
				}
				
				this.stocks[this.portfolioSize]=(StockInterface) stk;
				((stock)stocks[this.portfolioSize]).setStockQuantity(0);
				this.portfolioSize++;
				return;
				
			}
		}

		public StockInterface[] getStock(){
			return this.stocks;
		}
		
		public String getHtmlString(/*Portfolio portfolio*/){
			
			String str= new String("<br>"+"<h>"+ this.title +"<h>"+ "<br/>");
			
			for(int i=0; i<this.portfolioSize; i++){
				str=str+ ((stock)this.stocks[i]).getHtmlDescription();
			}
			
			str+= "<br>"+"<h>"+"Total Portfolio Value :"+"<h>"+this.getTotalValue()+ "$.<br>"+"<h>"+"Total Stocks Value :"+"<h>"+this.getStocksValue()+"$. <br>"+"<h>"+"Balance :"+"<h>"+this.balance+"$.";
			
			return str;
		}
		

		
		public boolean removeStock(String symbol)
		{
			boolean res=false;
			
			for(int i=0; i < portfolioSize; i++)
			{
				if(this.stocks[i].getSymbol().equals(symbol)==true)
				{
					this.sellStock(this.stocks[i].getSymbol(), -1);
					
					//set stock reference at i to null
					
					//move last stock in array (if found) to i location.
					
					if(i != portfolioSize-1 && portfolioSize > 1){
						this.stocks[i]=null;
						this.stocks[i] = (StockInterface) new stock(((stock)this.stocks[portfolioSize-1]));
					}
					else{
						this.stocks[i]=null;
					}
						
				res=true;
				}
			}
			
			if(res=true){
				this.portfolioSize--;
			}
			
			else{
				System.out.println("The Stock you wish to remove does not exsist in Portfolio!”");
			}
			
			return res;
		}
		
		public boolean sellStock(String symbol, int quantity){
			
			if(symbol==null || quantity <-1)
			{
				System.out.println("Please check the 'symbol' you entered or the 'quanitity' asked"+ "<br>");
				return false;
			}
			
			for(int i=0; i<this.portfolioSize; i++){
				
				if(this.stocks[i].getSymbol().equals(symbol)== true){
					
					if(((stock)this.stocks[i]).getStockQuantity()-quantity <0 ){
						System.out.println("Not enough stocks to sell!!”"+"<br>");
						return false;
					}
					
					else if (quantity==-1){
						this.balance+= ((stock)this.stocks[i]).getStockQuantity() * ((stock)this.stocks[i]).getBid();
						((stock)this.stocks[i]).setStockQuantity(0);
						((stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.SELL);
						System.out.println("The whole stock "+ symbol +" holdings was sold succefully"+"<br>");
					    return  true;
					}
					
					else{
						this.balance+= quantity * this.stocks[i].getBid();
						((stock)this.stocks[i]).setStockQuantity(((stock)this.stocks[i]).getStockQuantity()-quantity);
						((stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.SELL);
						System.out.println("Stock "+ symbol +" "+quantity+" holdings was sold succefully"+"<br>");
					    return  true;
					}
					
				}
			}
			System.out.println("Stock does not found in the Portfolio");
			return false; 
		}
		
		
		
		
		public boolean buyStock(stock stock, int quantity){
			
			int howManyToBuy=0;

			if(stock==null || quantity <-1)
			{
				System.out.println("ERROR! Please chack the stock you wish to buy or the quantity entered!"+"<br>");
				return false;
				
			}
			
			if( stock.getAsk()* quantity > this.balance){
				System.out.println("ERROR! Not enough balance to process the purchas!"+"<br>");
				return false;
			}
			
			for(int i=0; i<this.portfolioSize; i++){
				
				if (this.stocks[i].getSymbol().equals(stock.getSymbol())){
					
					if(quantity==-1){
						 howManyToBuy= (int)this.balance/ (int)this.stocks[i].getAsk();
						 //this.balance-= howManyToBuy * this.stocks[i].getAsk();
						 this.updateBalance(-(howManyToBuy * this.stocks[i].getAsk()));
						 ((stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.BUY);
						 ((stock)this.stocks[i]).setStockQuantity(((stock)this.stocks[i]).getStockQuantity() + howManyToBuy);
						 System.out.println("You bought the whole holdings for stock "+stock.getSymbol()+" seccsesfully! "+"<br>");
						 return true;
					}
					
					if(quantity>0)
					{
						this.balance-= quantity * this.stocks[i].getAsk();
						//this.updateBalance(-(quantity * this.stocks[i].getAsk()));
						((stock)this.stocks[i]).setRecomendation(ALGO_RECOMMENDATION.BUY);
						((stock)this.stocks[i]).setStockQuantity(((stock)this.stocks[i]).getStockQuantity() + quantity);
						 System.out.println("You bought the requested holding for stock "+stock.getSymbol()+" seccsesfully! "+"<br>");
						 return true;
					}
				}
			}
			
			addStock(stock);
			//this.balance-=this.stocks[this.portfolioSize-1].getAsk()*quantity;
			this.updateBalance(- (float)(this.stocks[this.portfolioSize-1].getAsk()*quantity));
			((stock)this.stocks[this.portfolioSize-1]).setStockQuantity( quantity);
			System.out.println("The requested  stock "+stock.getSymbol()+" was added to the Portfolio seccsesfully! "+"<br>");
			 return true;
			
		}
		
		
		public float getStocksValue(){
			
			float total = 0;
			
			for (int i=0; i<this.portfolioSize; i++){
				
				total += this.stocks[i].getBid() * ((stock)this.stocks[i]).getStockQuantity() ;
			}
			return total;
		}
		

		public float getTotalValue(){
			
			return this.getStocksValue() + this.getBalance();
		}
		
		//this function finds stock in the array, returns NULL in case the stock does not exist
		public StockInterface findStock(String stockSymbol){
			
			for(int i=0; i<this.portfolioSize; i++)
			{
				if(getStocks()[i].getSymbol().equals(stockSymbol)){
					return this.getStocks()[i];
				}
			}
			
			return null;
			
		}
		
	}		



			
		

