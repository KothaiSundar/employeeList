package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.dao.CompanyDAO;
import employee.dto.Company;

@WebServlet("/companysignup")
public class CompanySignUp extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
	String name=req.getParameter("companyName");
	String email=req.getParameter("companyEmail");
	String password=req.getParameter("companyPassword");
	String location=req.getParameter("companyLocation");
	
	Company company=new Company();
	company.setCompanyName(name);
	company.setCompanyEmail(email);
	company.setCompanyPassword(password);
	company.setCompanyLocation(location);
	
	CompanyDAO dao=new CompanyDAO();
	dao.CompanySignUP(company);
	req.getRequestDispatcher("CompanyLogin.jsp").forward(req, res);
}
}