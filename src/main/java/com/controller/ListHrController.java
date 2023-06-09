package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;

@WebServlet("/ListHrController")
public class ListHrController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      
		ArrayList<HrBean> users=new AdminDao().getHrList();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("AdminDash.jsp").forward(req, resp);
	}

}
