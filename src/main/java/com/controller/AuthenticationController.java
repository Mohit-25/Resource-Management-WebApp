package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.dao.AdminDao;


/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailId=(String)request.getParameter("adminEmail");
		String password=(String)request.getParameter("adminPass");
		AdminBean abean=new AdminBean();
		abean.setAdminEmail(emailId);
		abean.setAdminPassword(password);
		
	    AdminBean user=new AdminDao().Authenticate(emailId,password);
	    RequestDispatcher rd=null;
	    if(user!=null)
	    {
	    
	    	request.setAttribute("user", user);
	    	rd=request.getRequestDispatcher("AdminDash.jsp");
	    }
	    else
	    {
	    	request.setAttribute("auser", abean);
	    	request.setAttribute("error", "Plesae Enter Valid Credentials.....");
	    	rd=request.getRequestDispatcher("AdminLogin.jsp");
	    }
	    
	    rd.forward(request, response);
	    

	    
	    
		 
	
	}

}