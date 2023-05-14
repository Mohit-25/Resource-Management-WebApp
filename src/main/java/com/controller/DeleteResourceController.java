package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;

@WebServlet("/deleteresource")
public class DeleteResourceController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		Integer id=Integer.parseInt(req.getParameter("id"));
		
		new HrDao().deleteResource(id);
		
		resp.sendRedirect("ListResource");
		
		
	}
	
	

}
