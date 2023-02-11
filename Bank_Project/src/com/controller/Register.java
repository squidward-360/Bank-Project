package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

public class Register extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String accno = req.getParameter("accno");
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			String email = req.getParameter("email");
			String balance = req.getParameter("balance");
			
			int accountnumber = Integer.parseInt(accno);
			int bal = Integer.parseInt(balance);
			
			Model m = new Model();
			m.setAccount_number(accountnumber);
			m.setName(name);
			m.setPassword(pass);
			m.setEmail_id(email);
			m.setBalance(bal);
			
			boolean status = m.register();
			if(status == true)
			{
				res.sendRedirect("/Bank_Project/login.html");
			}
			else
			{
				res.sendRedirect("/Bank_Project/regincorrect.html");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
