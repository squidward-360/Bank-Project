package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;
public class ForgotPassword extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			int accno = Integer.parseInt(req.getParameter("accno"));
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String np = req.getParameter("np");
			
			Model m = new Model();
			m.setAccount_number(accno);
			m.setName(name);
			m.setEmail_id(email);
			m.setPassword(np);
			
			boolean status = m.forgotPassword();
			if(status == true)
			{
				res.sendRedirect("/Bank_Project/login.html");
			}
			else
			{
				res.sendRedirect("/Bank_Project/forgotpassfail.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
