package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.bean.HrBean;
import com.dao.AdminDao;
import com.dao.HrDao;

@WebServlet("/HrAuthenticationController")
public class HrAuthenticationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailId=(String)request.getParameter("hrEmail");
		String password=(String)request.getParameter("hrPass");
		HrBean hbean=new HrBean();
		hbean.setHrEmail(emailId);
		hbean.setHrPassword(password);
		
	    HrBean user=new AdminDao().hrAuthenticate(emailId,password);
	  
	    if(user!=null)
	    {
	    	ServletContext servletContext = getServletContext();

			ArrayList<String> dblist= new HrDao().getDatabases();
//			req.setAttribute("dblist", dblist);
			servletContext.setAttribute("dblist",dblist);

			
			ArrayList<String> lanlist= new HrDao().getLanguage();
//			req.setAttribute("lanlist", lanlist);
			servletContext.setAttribute("lanlist",lanlist);
			
			ArrayList<String> techlist= new HrDao().getTechnology();
//			req.setAttribute("techlist", techlist);
			servletContext.setAttribute("techlist",techlist);
	    
	    	
	    	response.sendRedirect("ListResource");
	    }
	    else
	    {
	    	request.setAttribute("huser", hbean);
	    	request.setAttribute("error", "Plesae Enter Valid Credentials.....");
	    	request.getRequestDispatcher("HrLogin.jsp").forward(request, response);;
	    }
	
	
	}

}
