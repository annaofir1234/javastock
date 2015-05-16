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
	
		resp.setContentType("text/html");
		resp.getWriter().println(portfolio.getHtmlString(portfolio));	
	}
}
