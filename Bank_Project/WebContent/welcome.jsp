<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session = request.getSession();
int accno = (int)session.getAttribute("accno");
String name = (String)session.getAttribute("name");
String email = (String)session.getAttribute("email");
String pass = (String)session.getAttribute("pass");
int balance = (int)session.getAttribute("balance");
out.println("Welcome "+name);
out.println("</br>");
out.println("Your AccountNumber is : "+accno);
out.println("</br>");
out.println("</br>");
%>
<a href="/Bank_Project/Balance">Check Balance</a></br>
<a href="/Bank_Project/loan.jsp">Apply Loan</a></br>
<a href="/Bank_Project/changepassword.html">Change Password</a></br>
<a href="/Bank_Project/changename.html">Change Name</a></br>
<a href="/Bank_Project/transfer.html">Transfer Money</a></br>
<a href="/Bank_Project/logout.jsp">LogOut</a></br>

</body>
</html>