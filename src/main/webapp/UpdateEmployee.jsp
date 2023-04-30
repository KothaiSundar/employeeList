<%@ page import="employee.dto.Employee"%>
 <%@ page import="employee.dto.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeList</title>
</head>
<body>
<%Company company=(Company)session.getAttribute("company"); 
if(company!=null){
Employee employees=(Employee)request.getAttribute("employees"); %>
<form action="saveUpdatedEmployee" method="post">
 <input name ="employeeId" value="<%= employees.getEmployeeId()%>" 
        readonly="readonly" type="text"><br><br>
  
       <input name ="employeeName" value="<%=employees.getEmployeeName()%>" 
        type="text"><br><br>
        
         <input name="employeeEmail" value="<%=employees.getEmployeeEmail()%>"
        type="text"><br><br>
      <input name="employeePhoneNumber" value="<%=employees.getEmployeePhoneNumber()%>" 
      type="text"><br><br>
      
       
       <input name="employeeDesignation" value="<%=employees.getEmployeeDesignation()%>"
        type="text"><br><br>
      <input name="employeeSalary" value="<%=employees.getEmployeeSalary()%>"
        type="text"><br><br>
     
       <input type="submit" value="Update">
       <%}else{
response.sendRedirect("CompanyLogin.jsp");
}%>   
      
     </form>
</body>
</html>