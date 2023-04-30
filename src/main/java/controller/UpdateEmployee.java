package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.dao.EmployeeDAO;
import employee.dto.Employee;
@WebServlet("/updateEmployee")
public class UpdateEmployee extends HttpServlet
{
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	 {
	String id=req.getParameter("employeeId");
	Employee emp=new Employee();
	
	EmployeeDAO dao=new EmployeeDAO();
	
	emp=dao.getEmployee(Integer.parseInt(id));
	req.setAttribute("employees", emp);
	req.getRequestDispatcher("UpdateEmployee.jsp").forward(req,res);
}
}