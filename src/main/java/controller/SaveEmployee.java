package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.dao.CompanyDAO;
import employee.dao.EmployeeDAO;
import employee.dto.Company;
import employee.dto.Employee;



@WebServlet("/save")


public class SaveEmployee extends HttpServlet
{
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
 {HttpSession session=req.getSession();
	Company company=(Company)session.getAttribute("company");

	if(company!=null)
	{
 String empname=req.getParameter("employeeName");
 String stringPhoneNumber=req.getParameter("employeePhoneNumber");
	String email=req.getParameter("employeeEmail");
	String deg=req.getParameter("employeeDesignation");
    String salary=req.getParameter("employeeSalary");
 
 long phno=Long.parseLong(stringPhoneNumber);
 int sal=Integer.parseInt(salary);
 
 Employee employee=new  Employee();
 
	 employee.setEmployeeName(empname);
	 employee.setEmployeeEmail(email);
	 employee.setEmployeeDesignation(deg);
	 employee.setEmployeeSalary(sal);
	 employee.setEmployeePhoneNumber(phno);
	 employee.setCompany(company);
	 
	 EmployeeDAO em =new EmployeeDAO();
	 em.saveEmployee(employee);
	 List<Employee> employees =company.getEmployees();
	 employees.add(employee);
	 CompanyDAO dao=new CompanyDAO();
	dao.updateEmployeeList(company);
	 res.sendRedirect("Dashboard.jsp");
 }
else 
{
	res.sendRedirect("CompanyLogin.jsp");
}
}
}
