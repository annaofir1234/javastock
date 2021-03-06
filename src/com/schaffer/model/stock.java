package com.schaffer.model;
import java.text.*;
import java.util.*;

import org.algo.model.StockInterface;

import com.schaffer.model.Portfolio.ALGO_RECOMMENDATION;
/**
 * This class represents a Stock of Stocks.
 * @param symbol
 * @param bid : buy value
 * @param ask : sell value
 * @param date : creation date
 * @param recommendation : price recommendation
 * @param stockQuantity : the amount of stocks of that kind
 * @author ���
 */
public class stock implements StockInterface{


	private String symbol;
	private float bid, ask;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	transient private SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");

	/* TEMPORARY SITUATION - recommendation and stockQuantity are set to default of 0 
	   until next exercise or further change by lecturer (orr). */

	/**
	 * C'tor of stock.
	 * @author ���
	 */
	public stock (){
		this.symbol = new String();
		this.bid = 0;
		this.ask = 0;
		this.date = new Date();
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;				
	}
	/**
	 * C'tor of Stock.
	 * @param newSymbol
	 * 		  : Stock Symbol.
	 * @param newBid
	 * 		  : Stock bid value.
	 * @param newAsk
	 * 		  : Stock ask value.
	 * @param date
	 * 		  : Creation date of the stock.
	 * @author ���
	 */
	public stock (String newSymbol, float newBid, float newAsk, Date date){
		this.symbol = newSymbol;
		this.bid = newBid;
		this.ask = newAsk;
		this.date = date;
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;				
	}

	/**
	 * Copy C'tor of Stock class.
	 * @param oldStock
	 * @author ���
	 */
	public stock (stock oldStock)
	{
		// ���� ���� ���� �� ����� ������ ���� ������ �� ��������
		//�������� �� ����� ������� ��� ��� ������. ���� ������ ����� ������� ������� ���

		this(oldStock.getSymbol(),oldStock.getBid(),oldStock.getAsk(),new Date(oldStock.getDate().getTime()));
		this.recommendation = oldStock.getRecommendation();
		this.stockQuantity = oldStock.getStockQuantity();
	}

	/**
	 * Method uses the stock's details.
	 * @return string with stock's details in HTML code.
	 */
	public String getHtmlDescription(){
		return "<b>Stock symbol: </b>"+this.getSymbol()+" <b>Ask: </b>"+this.getAsk()+"<b> Bid: </b>"+this.getBid()+
				"<b> Date: </b>"+this.formDate.format(this.getDate())+" <b>Quantity: </b>"+this.getStockQuantity();
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	//	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
	//		this.recommendation = recommendation;
	//	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getBid() {
		return this.bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public float getAsk() {
		return this.ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setRecommendation(ALGO_RECOMMENDATION valueOf) {
		this.recommendation = valueOf;

	}

}