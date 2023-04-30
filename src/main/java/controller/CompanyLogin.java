package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.dao.CompanyDAO;
import employee.dto.Company;


@WebServlet("/login")
public class CompanyLogin  extends HttpServlet
{
		
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
		String email=req.getParameter("companyEmail");
		String password=req.getParameter("companyPassword");
	Company company= new CompanyDAO().CompanyLogin(email,password);
	System.out.println("the company is"+ company);
      if(company!=null)
      {
    	  HttpSession session=req.getSession();
   
    	 session.setAttribute("company",company);
    
    	 req.getRequestDispatcher("Dashboard.jsp").forward(req, res);
  	}
  	else
  	{
  		// if no paritucular data found in database, then goes to again signup that is firstsignup and login
  		res.sendRedirect("CompanySignUp.jsp");
  	}
}}