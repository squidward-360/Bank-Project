package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TransferValidation extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String taccno = req.getParameter("taccno");
			String amount = req.getParameter("amount");
			
			if(taccno.length()==0 || amount.length() == 0)
			{
				res.sendRedirect("/Bank_Project/transferinvalid.html");
			}
			else
			{
				req.getServletContext().getRequestDispatcher("/Transfer").forward(req,res);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
