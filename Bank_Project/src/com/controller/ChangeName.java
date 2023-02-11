package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

public class ChangeName extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse  res)
	{
		try 
		{
			String on = req.getParameter("on");
			String nn = req.getParameter("nn");
			
			HttpSession hs = req.getSession();
			int accno = (int)hs.getAttribute("accno");
			Model m = new Model();
			
			m.setAccount_number(accno);
			m.setName(on);
			boolean status = m.changeName(nn);
			if(status == true)
			{
				res.sendRedirect("/Bank_Project/changenamesuccess.html");
			}
			else
			{
				res.sendRedirect("/Bank_Project/changenamefail.html");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
