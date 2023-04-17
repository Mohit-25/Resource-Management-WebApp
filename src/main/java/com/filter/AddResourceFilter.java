package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bean.HrBean;
import com.bean.ResourceBean;

@WebFilter("/addresource")
public class AddResourceFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("AddResourceFilter::init()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AddResourceFilter::doFilter()");
		
		String firstName=(String)request.getParameter("firstName");
		String lastName=(String)request.getParameter("lastName");
		String emailId=(String)request.getParameter("emailId");
		String contactNo=(String)request.getParameter("contactNo");
		String qualification=(String)request.getParameter("qualification");
		Integer experience=Integer.parseInt(request.getParameter("experience"));
		String resumeUrl=(String)request.getParameter("resumeUrl");
		
		String fn="[a-zA-Z]+";
		String em="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
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
		
		if(contactNo.matches(contact)==false)
		{
			isError=true;
			request.setAttribute("number", "Please Enter valid Contact No");
		}
		if(qualification.equals("select"))
		{
			isError=true;
			request.setAttribute("qualification", "Please Enter qualification");
			
		}
		
		ResourceBean user=new ResourceBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailId(emailId);
		user.setContactNo(contactNo);
		user.setExperience(experience);
		user.setResumeUrl(resumeUrl);
	    
	
		if(isError) {
			request.setAttribute("user",user);
			request.getRequestDispatcher("AddResource.jsp").forward(request, response); 
		}else {
			chain.doFilter(request, response);
		}
	
	}

	public void destroy() {
		System.out.println("AddResourceFilter::destroy()");
		
	}

}
