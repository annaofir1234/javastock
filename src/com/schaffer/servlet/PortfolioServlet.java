package com.schaffer.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schaffer.service.PortfolioManager;
import com.schaffer.model.Portfolio;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet{
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
		
		PortfolioManager portfolioManager = new PortfolioManager();
		
		Portfolio portfolio = portfolioManager.getPortfolio();
		
		//create portfolio2 which is a copy of portfolio 01 
		Portfolio portfolio2= new Portfolio(portfolio);
		portfolio2.setTitle("Portfolio 02");
					
		//Print Portfolio #1 and #2
		resp.setContentType("text/html");
		resp.getWriter().println(portfolio.getHtmlString(portfolio));
		resp.getWriter().println(portfolio2.getHtmlString(portfolio2));
		 			
		portfolio.removeStock(portfolio.getStock()[0]);
		
		//Print again
		resp.setContentType("text/html");
		resp.getWriter().println(portfolio.getHtmlString(portfolio));
		resp.getWriter().println(portfolio2.getHtmlString(portfolio2));
		
		//change last stock's bid value of portfolio2 to 55.55
		portfolio2.getStock()[2].setBid(55.55F );
		
		//print again
		resp.setContentType("text/html");
		resp.getWriter().println(portfolio.getHtmlString(portfolio));
		resp.getWriter().println(portfolio2.getHtmlString(portfolio2));
		
		}
}
