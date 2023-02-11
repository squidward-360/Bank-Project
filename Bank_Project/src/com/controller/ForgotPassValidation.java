package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.accessibility.internal.resources.accessibility;

public class ForgotPassValidation extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String accno = req.getParameter("accno");
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String np = req.getParameter("np");
			String cnp = req.getParameter("cnp");
			
			if(accno.length()==0 || email.length()==0 || name.length()==0 || np.length()==0 || cnp.length()==0)
			{
				res.sendRedirect("/Bank_Project/forgotpassinvalid.html");
			}
			else
			{
				if(np.equals(cnp))
				{
					req.getServletContext().getRequestDispatcher("/ForgotPassword").forward(req, res);
				}
				else
				{
					res.sendRedirect("/Bank_Project/forgotpassinvalid.html");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
