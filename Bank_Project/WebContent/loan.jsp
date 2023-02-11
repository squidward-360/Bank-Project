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
String name = (String)session.getAttribute("name");
out.println("Welcome "+name);
out.println("</br>");
%>

<a href="/Bank_Project/carloan.jsp">Click here to apply for Car Loan @6.5%</a></br></br>
<a href="/Bank_Project/houseloan.jsp">Click here to apply for House Loan @11%</a></br></br>
<a href="/Bank_Project/educationloan.jsp">Click here to apply for Education Loan @8%</a>

</body>
</html>