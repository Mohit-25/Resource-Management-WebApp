package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.bean.ResourceBean;
import com.dao.HrDao;

@WebServlet("/addresource")
public class AddResourceController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String firstName=(String)request.getParameter("firstName");
		String lastName=(String)request.getParameter("lastName");
		String emailId=(String)request.getParameter("emailId");
		String contactNo=(String)request.getParameter("contactNo");
		String Gender=(String)request.getParameter("Gender");
		Integer experience=Integer.parseInt(request.getParameter("experience"));
		String qualification=(String)request.getParameter("qualification");
		String resumeUrl=(String)request.getParameter("resumeUrl");
		
		ResourceBean user=new ResourceBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailId(emailId);
		user.setContactNo(contactNo);
		user.setGender(Gender);
		user.setExperience(experience);
		user.setQualification(qualification);
		user.setResumeUrl(resumeUrl);
		
		new HrDao().addResource(user);
		int userid=new HrDao().getIdofResource(contactNo);
		
		String[] mydb = request.getParameterValues("mydb[]");
		
		for(String db:mydb)
		{
			int dbid=new HrDao().getIdFromDb(db);
			new HrDao().setuserdb(userid,dbid);
		}
		
		String[] mylan = request.getParameterValues("mylan[]");
		for(String lan:mylan)
		{
			int lanid=new HrDao().getIdFromLan(lan);
			new HrDao().setuserlan(userid,lanid);
		}
		
		String[] mytech = request.getParameterValues("mytech[]");
		for(String tech:mytech)
		{
			int techid=new HrDao().getIdFromtech(tech);
			new HrDao().setusertech(userid,techid);
		}
		
		response.sendRedirect("ListResource");

		
		
		
		
		
	
	}

}
