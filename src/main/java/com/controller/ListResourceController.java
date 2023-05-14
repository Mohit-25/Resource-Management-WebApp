package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.bean.ResourceBean;
import com.dao.AdminDao;
import com.dao.HrDao;

@WebServlet("/ListResource")
public class ListResourceController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userid=0;
        ArrayList<String[]> dblist=new ArrayList<>();
        ArrayList<String[]> lanlist=new ArrayList<>();
        ArrayList<String[]> techlist=new ArrayList<>();
        
		ArrayList<ResourceBean> users=new HrDao().getResourceList();
		req.setAttribute("users", users);
		ServletContext servletContext = getServletContext();
		
		ArrayList<String> dlist=(ArrayList<String>)servletContext.getAttribute("dblist");
		
		ArrayList<String> llist=(ArrayList<String>)servletContext.getAttribute("lanlist");
		ArrayList<String> tlist=(ArrayList<String>)servletContext.getAttribute("techlist");
		
		for(ResourceBean user:users)
		{
			userid=new HrDao().getIdofResource(user.getContactNo());
			
			String[] dbs=new HrDao().getDbList(userid,dlist.size());
			dblist.add(dbs);
			
			String[] lans=new HrDao().getLanList(userid,llist.size());
			lanlist.add(lans);
			
			String[] techs=new HrDao().getTechList(userid,tlist.size());
			techlist.add(techs);
			
			
		}
		

		
	
		
		req.setAttribute("dlist", dblist);
		
		req.setAttribute("llist", lanlist);
		
		req.setAttribute("tlist", techlist);
		
		req.getRequestDispatcher("HrDash.jsp").forward(req, resp);

	
	
	}

}
