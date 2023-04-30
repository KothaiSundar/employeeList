  <%@ page import="java.util.List"%>
  <%@ page import="employee.dto.Company"%>
 <%@ page import="employee.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeList</title>
</head>
<style>
     body{
     display:flex;
     flex-direction:column;
     align-items:center;
     
     }

</style>
<body>

 <% Company company=(Company)session.getAttribute("company"); 
 if(company!=null){
	 List <Employee> employees = (List) request.getAttribute("employees");%>
 }
<h1>Employees List</h1>
   
   <table border="" cellPadding="10px" cellSpacing="0">
      <tr>
          <th>Employee_Id</th>
          <th>Employee_Name</th>
           <th>Employee_Email</th>
              <th>Employee_Phoneno</th>
                 <th>Employee_Designation</th>
                <th>Employee_Salary</th>  
           <th>Update_Employee</th>
           <th>Delete_Employee</th>
          </tr> 
    <%for(Employee employee : employees){ %>
    
    <tr>
        <td><%= employee.getEmployeeId() %></td>
        <td><%= employee.getEmployeeName() %></td>
        <td><%= employee.getEmployeeEmail() %></td>
        <td><%= employee.getEmployeePhoneNumber() %></td>
        <td><%= employee.getEmployeeDesignation() %></td>
        <td><%= employee.getEmployeeSalary() %></td>
        
        
        <td><a href="updateEmployee?employeeId=<%= employee.getEmployeeId() %>">Update</a></td>
               <td><a href="deleteEmployee?employeeId=<%= employee.getEmployeeId() %>">Delete</a></td>
        
      
            </tr>
        <% }%>
   </table>
         <div><a href="Dashboard.jsp">Home</a></div>
     <%}else{
response.sendRedirect("CompanyLogin.jsp");
}%>   
        
</body>
</html>