package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UsersDao;
import model.Users;



public class ViewUsers extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(ViewUsers.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
	 try {
        UsersDao ua = new UsersDao(getServletContext());
         
         List<Users> list = ua.getAll();
         
         req.setAttribute("list", list);
             

     } 
	 catch (Exception e) {
         
         req.setAttribute("error", "Something went wrong: " + e.getMessage());
         
     } 

     req.getRequestDispatcher("/viewAll.jsp").forward(req, res);
 }
       
    
}
