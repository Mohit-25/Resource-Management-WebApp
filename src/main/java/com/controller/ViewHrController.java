package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;

@WebServlet("/view")
public class ViewHrController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
		Integer id=Integer.parseInt(req.getParameter("id"));
		HrBean user=new AdminDao().getHrById(id);
		
		req.setAttribute("user",user);
		
		req.getRequestDispatcher("ViewHr.jsp").forward(req, resp);
	
	
	}

}
