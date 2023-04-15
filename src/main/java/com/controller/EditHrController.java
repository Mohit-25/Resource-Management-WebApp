package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;


@WebServlet("/editHrController")
public class EditHrController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer userId=Integer.parseInt(req.getParameter("id"));
        System.out.println("moiht..");
        HrBean user= new AdminDao().getUserById(userId);
		
		req.setAttribute("user", user);

		req.getRequestDispatcher("EditHr.jsp").forward(req, resp);
	
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       
	       Integer id=Integer.valueOf(request.getParameter("id"));
	       String firstName=(String)request.getParameter("firstName");
			String lastName=(String)request.getParameter("lastName");
			String emailId=(String)request.getParameter("emailId");
			String password=(String)request.getParameter("password");
			String gender=(String)request.getParameter("gender");
			String number=(String)request.getParameter("number");
			String date=(String)request.getParameter("date");
			
			HrBean user=new HrBean();
			user.setHrId(id);
			user.setHrFirstName(firstName);
			user.setHrLastName(lastName);
			user.setHrEmail(emailId);
			user.setHrPassword(password);
			user.setHrGender(gender);
			user.setHrContact(number);
			user.setHrJoinDate(date);
			
			  
			new AdminDao().UpdateUser(user);
			
			response.sendRedirect("ListHrController");
	
	
	}

}
