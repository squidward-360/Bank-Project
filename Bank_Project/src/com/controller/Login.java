package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class Login extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try 
		{
			String accno = req.getParameter("accno");
			String pass = req.getParameter("pass");
			int accountnumber = Integer.parseInt(accno);
			
			Model m = new Model();
			m.setAccount_number(accountnumber);
			m.setPassword(pass);
			
			boolean status = m.login();
			if(status == true)
			{
				int a = m.getAccount_number();
				String b = m.getName();
				String c = m.getEmail_id();
				String d = m.getPassword();
				int e = m.getBalance();
				HttpSession session = req.getSession(true);
				session.setAttribute("accno", a);
				session.setAttribute("name", b);
				session.setAttribute("email", c);
				session.setAttribute("pass", d);
				session.setAttribute("balance", e);
				
				res.sendRedirect("/Bank_Project/welcome.jsp");
			}
			else
			{
				res.sendRedirect("/Bank_Project/incorrect.html");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
