package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeNameVal extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String on = req.getParameter("on");
			String nn = req.getParameter("nn");
			
			if(on.length()==0 || nn.length()==0)
			{
				res.sendRedirect("/Bank_Project/invalid.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/ChangeName").forward(req, res);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
