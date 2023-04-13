package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;

@WebServlet("/AddHr")
public class AddHrController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String firstName=(String)request.getParameter("firstName");
		String lastName=(String)request.getParameter("lastName");
		String emailId=(String)request.getParameter("emailId");
		String password=(String)request.getParameter("password");
		String gender=(String)request.getParameter("gender");
		Long number=(Long)Long.parseLong(request.getParameter("number"));
		String date=(String)request.getParameter("date");
		
		HrBean user=new HrBean();
		user.setHrFirstName(firstName);
		user.setHrLastName(lastName);
		user.setHrEmail(emailId);
		user.setHrPassword(password);
		user.setHrGender(gender);
		user.setHrContact(number);
		user.setHrJoinDate(date);
		
		new AdminDao().addHr(user);
		
		response.sendRedirect("AdminDash.jsp");
	}

	
}
