package com.schaffer.modelupdated;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class stock {
	
	private int recomendation=0;
	private int stockQuantity=0;
	private final static int BUY = 0;
	private final static int SELL = 1;
	private final static int REMOVE= 2;
	private final static int HOLD= 3;
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	public stock ( String newsymbol, Float newask , Float newbid , java.util.Date newdate){
		this.setSymbol(symbol);
		this.setBid( bid);
		this.setAsk(ask);
		this.setDate(date);
	}
	 
	 public stock (stock stock){
		 this.setSymbol(stock.getSymbol());
		 this.setBid(stock. getBid());
		 this.setAsk(stock.getAsk());
		 this.setDate(stock.getDate()); 
	 }
	 
	// Getters & Setters
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
 		return date;
 	}
 	public void setDate(Date date) {
 		this.date = date;
 	}
 	
	public int getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(int recomendation) {
		this.recomendation = recomendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;	}
	
		
	public String getHtmlDescription (){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(getDate());
		
		String stock = new String ( "<b>Symbol</b>: " + this.getSymbol() + "  <b>Ask</b>: " +
				this.getAsk() + "  <b>Bid</b>: " + this.getBid() + "  <b>Date</b>: " + this.date);
		
		return stock;
	}
}
