package com.schaffer;

import java.io.IOException;

import java.util.Date;
import java.util.Calendar;

import com.schaffer.stock;

/*import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.servlet.http.*;	*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.query.evaluator.memory.CurrentDateFunctionEvaluator;
	
	public class StockDetailsServlet extends HttpServlet{
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			resp.setContentType("text/html");
	
			Calendar cal = Calendar.getInstance();
			cal.set(2015,10 ,15);
			
			stock stock1 = new stock( "PIH" ,(float)13.1 ,(float)12.4, cal.getTime());
			stock stock2 = new stock( "AAL" , (float)5.78 ,(float)5.5, cal.getTime());
			stock stock3 = new stock( "CAAS" , (float)32.2 ,(float)31.5, cal.getTime());
				
			resp.getWriter().println(stock1.getHtmlDescription());
			resp.getWriter().println("<p");
			resp.getWriter().println(stock2.getHtmlDescription());
			resp.getWriter().println("<p");
			resp.getWriter().println(stock3.getHtmlDescription());
			
		}
	}


