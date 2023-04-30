 <%@ page import="employee.dto.Company"%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>




<body>
<%Company company=(Company)session.getAttribute("company"); 
if(company!=null){%>
     <form action="save" method="post">
      <input name ="employeeName" placeholder="Enter Employee Name"  type="text"><br><br>
      <input name="employeePhoneNumber" placeholder="Enter EmployeePhonenumber" type="text"><br><br>
       <input name="employeeEmail" placeholder="Enter Employee Email" type="text"><br><br>
       <input name="employeeDesignation" placeholder="Enter Employee designation" type="text"><br><br>
       
        <input name="employeeSalary" placeholder="Enter employee salary" type="text"><br><br>
       
       <input type="submit" value="Save">
     
     <%}else{
response.sendRedirect("CompanyLogin.jsp");
}%>   
     
     
     
     </form>
</body>
</html>