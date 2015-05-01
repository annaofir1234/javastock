package com.schaffer;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class stock {
	
	private int recomendation;
	private int stockQuantity;
	private final static int BUY = 0;
	private final static int SELL = 1;
	private final static int REMOVE= 2;
	private final static int HOLD= 3;
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	public stock (String symbol,float ask,float bid ,Date date){
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
	}
	
	/* Getters & Setters */
	
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
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public String getHtmlDescription (){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date = df.format(getDate());
		
		String stock = new String ( "<b>Symbol</b>: " + this.getSymbol() + "  <b>Ask</b>: " +
				this.getAsk() + "  <b>Bid</b>: " + this.getBid() + "  <b>Date</b>: " + this.date);
		
		return stock;
	}
	
		
}
