<%@ page import="employee.dto.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeList</title>
</head>
<style>
    body
    {
    height:80vh;
    width:100vw;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
       
    }
    a{
    padding:.5em  le,;
    font-size:1.3rem;
    border: 2px solid #565656;
    border-radius:50px;
    text-decoration:none;
    color: #303030;
    margin:.5rem;
    
    }
    h1{
    font-size:5rem;
    color:#565656;}
      h3{
    font-size:1rem;
    color:#565656;}
</style>

<body>
<%Company company=(Company)session.getAttribute("company"); 
if(company!=null){%>

<h1> Welcome to Employee List</h1>
<h1> You can manage Employee list here</h1>



	<div>
	<a href="SaveEmployee.jsp">Save_Employee</a>
	<a href="viewEmployee">View_Employee</a>
	
	</div>
	
	<%}else {
		response.sendRedirect("CompanyLogin.jsp");}%>
	
<div class="logout"><a href="logout">Logout</a></div>
</body>
</html>