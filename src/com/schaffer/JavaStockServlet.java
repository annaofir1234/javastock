package com.schaffer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class JavaStockServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
       
		int num1, num2, num3;
		
		num1 = 4;
		num2 = 3;
		num3 = 7;
		
		int result = (num1 + num2) * num3;
		
		String resultStr = new String("<h1>Result of (" + num1 + " + " + num2 +" ) * " + num3 + " = " + result + "</h1>");
		resp.getWriter().println(resultStr);
	}
}

