package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.dto.Company;
@WebServlet("/logout")
public class CompanyLogout extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException

	{HttpSession session=req.getSession();
	Company company=(Company)session.getAttribute("company");
	if(company!=null)
	{
		session.setAttribute("company",null);
	}else
	{
		resp.sendRedirect("CompanyLogin.jsp");
	}
		resp.sendRedirect("CompanyLogin.jsp");
	
	}
}