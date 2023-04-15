package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bean.HrBean;

@WebFilter("/editHrController")
public class EditHrFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EditHrFilter::init()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		if(request instanceof HttpServletRequest) {
//            HttpServletRequest httpRequest = (HttpServletRequest) request;
//            if(!(httpRequest.getMethod().equalsIgnoreCase("GET"))) {
            
            	 HttpServletRequest httpRequest = (HttpServletRequest) request;
                 if ("POST".equals(httpRequest.getMethod())) {
                
            	System.out.println("EditHrFilter::doFilter()");
            	String firstName = (String)request.getParameter("firstName");
        		String lastName = (String)request.getParameter("lastName");
        		String emailId = (String)request.getParameter("emailId");
        		String password = (String)request.getParameter("password");
        		String gender = (String)request.getParameter("gender");
        		String number = (String)request.getParameter("number");
        		
        		String fn="[a-zA-Z]+";
        		String em="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
        		String ps="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
        		String contact="\\d{10}";
        		boolean isError=false;
        		
        	
        		
        		if(firstName.trim().length()<=2)
        		{
        			isError=true;
        			request.setAttribute("firstname", "Please Enter Atleast 2 Characters");
        		}
        		else if(firstName.matches(fn)==false)
        		{
        			isError=true;
        			request.setAttribute("firstname", "Please Enter valid First Name");
        			
        		}
        		
        		if(lastName.trim().length()<=2)
        		{
        			isError=true;
        			request.setAttribute("lastname", "Please Enter Atleast 2 Characters");
        		}
        		else if(lastName.matches(fn)==false)
        		{
        			isError=true;
        			request.setAttribute("lastname", "Please Enter valid Last Name");
        		}
        		
        		
        		if(emailId.matches(em)==false)
        		{
        			   isError=true;
        			   request.setAttribute("email", "Please Enter valid Email Address");

        	    }
        			
        		if(password.matches(ps)==false)
        	    {
        			isError=true;
        			request.setAttribute("password", "Please Enter valid Password");

        		}
        			
        		
        		if(gender==null)
        		{
        			isError=true;
        			request.setAttribute("gender", "Please Enter Gender");
        			
        		}
        		
        		if(number.matches(contact)==false)
        		{
        			isError=true;
        			request.setAttribute("number", "Please Enter valid Contact No");
        		}
        		
        		HrBean bean=new HrBean();
        		bean.setHrFirstName(firstName);
        	    bean.setHrLastName(lastName);
        	    bean.setHrEmail(emailId);
        	    bean.setHrPassword(password);
        	    bean.setHrGender(gender);
        	    bean.setHrContact(number);
        	    
        	
        		if(isError) {
        			request.setAttribute("user", bean);     			request.getRequestDispatcher("EditHr.jsp").forward(request, response); 
        		}else {
        			System.out.println("do filter else");
        			chain.doFilter(request, response);
        		}
        	
        	}
             else
             {
            	 System.out.println("do filter else");
     			chain.doFilter(request, response);
     		}

        	
          }
        
	public void destroy() {
		System.out.println("EditHrFilter::destroy()");
		
	}

}
