package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.dao.EmployeeDAO;
import employee.dto.Company;
import employee.dto.Employee;



	@WebServlet("/viewEmployee")
	public class GetAllEmployee extends HttpServlet

	{@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException 
	{HttpSession session=req.getSession();
	Company company=(Company)session.getAttribute("company");

	if(company!=null)
	{
		
		List<Employee> employees= new EmployeeDAO().getAllEmployee(company);
		req.setAttribute("employees", employees);
		System.out.println(employees);
	req.getRequestDispatcher("viewEmployee.jsp").forward(req, resp);
	
	
}
	else 
	{
		resp.sendRedirect("CompanyLogin.jsp");
	}
}}