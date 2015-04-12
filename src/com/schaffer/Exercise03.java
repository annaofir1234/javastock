package com.schaffer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Exercise03 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
			
			//3.1 - Area of Circle
			int radius = 50;
			double area = radius * radius * Math.PI;
			String line1 = new String("calculation 1: Area of circle with " + radius + " radius is " + area);
			
			//3.2 - Opposite in Triangle
			int hypotenuse = 50;
			double angleB = 30;
			double angleBradians = Math.toRadians(angleB);
			double opposite = Math.sin(angleBradians) * hypotenuse;
			String line2 = new String("calculation 2: Length of opposite where angle B is " + angleB + " and hypotenuse is " + hypotenuse + " is " + opposite);
			
			//3.3 - Calculating Power
			int base = 20;
			int exp = 13;
			long power = (long) Math.pow(base, exp);
			String line3 = new String("calculation 3: Power of " + base + " with exp " + exp + " is " + power);
			
			String resultStr = line1 + "<br>" + line2 + "<br>" + line3;
			resp.getWriter().println(resultStr);
			}
		}
