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



	@WebServlet("/saveUpdatedEmployee")
	public class SaveUpdatedEmployee  extends HttpServlet
	{
		@Override
		 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
		 {HttpSession session=req.getSession();
			Company company=(Company)session.getAttribute("company");

			if(company!=null)
			{
		 
		 String empid=req.getParameter("employeeId");
			String empname=req.getParameter("employeeName");
			 String stringPhoneNumber=req.getParameter("employeePhoneNumber");
				String email=req.getParameter("employeeEmail");
				String deg=req.getParameter("employeeDesignation");
			    String salary=req.getParameter("employeeSalary");
			    
			    
			    int id=Integer.parseInt(empid);
			    long phno=Long.parseLong(stringPhoneNumber);
			    int sal=Integer.parseInt(salary);
			    
			    Employee employee=new  Employee();
			    employee.setEmployeeId(id);
			   	 employee.setEmployeeName(empname);
			   	 employee.setEmployeeEmail(email);
			   	 employee.setEmployeeDesignation(deg);
			   	 employee.setEmployeeSalary(sal);
			   	 employee.setEmployeePhoneNumber(phno);
			   	 
			   	 
			   	 EmployeeDAO dao =new EmployeeDAO();
			   	 dao.updateEmployee(employee);
			     List<Employee> employees=new EmployeeDAO().getAllEmployee(company);
			     req.setAttribute("employees", employees);
			 	
			   	 req.getRequestDispatcher("viewEmployee.jsp").forward(req, res);;
			    }
			
			else 
			{
				res.sendRedirect("CompanyLogin.jsp");
			}
}
}