package com.schaffer.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class stock {
	
	public enum ALGO_RECOMMENDATION{
		BUY, SELL, REMOVE, HOLD
	}
	
	private ALGO_RECOMMENDATION recomendation;
	private int stockQuantity=0;
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;

	 
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
 	public ALGO_RECOMMENDATION getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(ALGO_RECOMMENDATION recomendation) {
		this.recomendation = recomendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;	}
	
	public stock(){
		this.symbol=new String();
		this.ask=0;
		this.bid=0;
		this.date= new Date();
		this.recomendation= ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity=0;
	}
	
	//Constructor
	public stock ( String newsymbol, Float newask , Float newbid , java.util.Date newdate){
		this.setSymbol(newsymbol);
		this.setBid(newbid);
		this.setAsk(newask);
		this.setDate(newdate);
		this.stockQuantity=0;
		this.recomendation=ALGO_RECOMMENDATION.HOLD;
	}
	 
	//Copy constructor
	 public stock (stock stock){
    	 this(new String(stock.getSymbol()), stock.getAsk(), stock.getBid(),
			 new Date(stock.getDate().getTime()));
    	 this.setStockQuantity(stock.getStockQuantity());
	   	 this.setRecomendation(stock.getRecomendation());
	 }
	 
	public String getHtmlDescription (){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(getDate());
		
		String stock = new String ("<br/>" + "<b>Symbol</b>: " + this.getSymbol() + "  <b>Ask</b>: " +
				this.getAsk() + "  <b>Bid</b>: " + this.getBid() + "  <b>Date</b>: " + date + "<br/>");
		
		return stock;
	}

}
