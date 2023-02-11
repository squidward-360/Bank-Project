package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model 
{
	int account_number;
	String name;
	String email_id;
	String password;
	int balance;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	String url="jdbc:oracle:thin:@//localhost:1521/xe";
	String path="oracle.jdbc.driver.OracleDriver";
	String user = "SYSTEM";
	String passw="SYSTEM";
	
	public Model()
	{
		try 
		{
			Class.forName(path);
			con = DriverManager.getConnection(url, user, passw);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean login()
	{
		try 
		{
			String sql = "SELECT * FROM KODNEST_BANK WHERE ACCOUNT_NUMBER=? AND PASSWORD = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account_number);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()==true)
			{
				account_number = rs.getInt(1);
				name = rs.getString(2);
				email_id = rs.getString(3);
				password = rs.getString(4);
				balance = rs.getInt(5);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean register()
	{
		try 
		{
			String sql = "INSERT INTO KODNEST_BANK VALUES(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account_number);
			pst.setString(2, name);
			pst.setString(3, email_id);
			pst.setString(4, password);
			pst.setInt(5, balance);
			int row = pst.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkBalance()
	{
		try 
		{
			String sql = "SELECT * FROM KODNEST_BANK WHERE ACCOUNT_NUMBER=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, account_number);
			rs = pst.executeQuery();
			if(rs.next()==true)
			{
				balance = rs.getInt(5);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changePassword(String np)
	{
		try 
		{
			String sql = "UPDATE KODNEST_BANK SET PASSWORD=? WHERE ACCOUNT_NUMBER=? AND PASSWORD=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, account_number);
			pst.setString(3, password);
			
			int row = pst.executeUpdate();
			if(row == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean transfer(int taccno,int amount)
	{
		try 
		{
			String sql1 = "UPDATE KODNEST_BANK SET BALANCE = BALANCE-? WHERE ACCOUNT_NUMBER=?";
			pst = con.prepareStatement(sql1);
			pst.setInt(1, amount);
			pst.setInt(2, account_number);
			int row1 = pst.executeUpdate();
			
			String sql2 = "UPDATE KODNEST_BANK SET BALANCE = BALANCE+? WHERE ACCOUNT_NUMBER=?";
			pst=con.prepareStatement(sql2);
			pst.setInt(1, amount);
			pst.setInt(2, taccno);
			int row2 = pst.executeUpdate();
			
			if(row1 == 0 || row2 == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean forgotPassword()
	{
		try 
		{ 
			String sql = "UPDATE KODNEST_BANK SET PASSWORD = ? WHERE ACCOUNT_NUMBER=? AND NAME=? AND EMAIL_ID=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, account_number);
			pst.setString(3, name);
			pst.setString(4, email_id);
			int row = pst.executeUpdate();
			if(row == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeName(String nn)
	{
		try 
		{
			String sql = "UPDATE KODNEST_BANK SET NAME=? WHERE ACCOUNT_NUMBER=? AND NAME=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, nn);
			pst.setInt(2, account_number);
			pst.setString(3, name);
			
			int row = pst.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	

}
