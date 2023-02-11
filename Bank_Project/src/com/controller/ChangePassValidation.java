package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePassValidation extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			String cnp = req.getParameter("cnp");
			
			if(op.length()==0 || np.length()==0 || cnp.length()==0)
			{
				res.sendRedirect("invalidchangepass.html");
			}
			else
			{
				if(np.equals(cnp))
				{
					req.getServletContext().getRequestDispatcher("/ChangePassword").forward(req, res);
				}
				else
				{
					res.sendRedirect("invalidchangepass.html");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
