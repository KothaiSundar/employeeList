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

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	 {
		HttpSession session=req.getSession();
		Company company=(Company)session.getAttribute("company");

		if(company!=null)
		{

		int id=Integer.parseInt( req.getParameter("employeeId"));
		EmployeeDAO dao=new EmployeeDAO();
		dao.deleteEmployee(id);  //deleteing id
	List<Employee> employee=dao.getAllEmployee(company); //storing in students variable
		req.setAttribute("employees",employee);   //setting that is passing students
		req.getRequestDispatcher("viewEmployee.jsp").forward(req,res);//sending to viewstu.jsp
}
		else 
		{
			res.sendRedirect("CompanyLogin.jsp");
		}
}}