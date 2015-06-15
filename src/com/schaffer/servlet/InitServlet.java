package com.schaffer.servlet;

import javax.servlet.ServletException;

import org.algo.service.ServiceManager;

import com.schaffer.exception.BalanceException;
import com.schaffer.exception.PortfolioFullException;
import com.schaffer.exception.StockAlreadyExistsException;
import com.schaffer.exception.StockNotExistException;
import com.schaffer.service.PortfolioManager;

@SuppressWarnings("serial")
public class InitServlet extends  javax.servlet.http.HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);	
	}
}