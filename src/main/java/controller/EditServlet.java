package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UsersDao;
import model.Users;

/**
 * Servlet implementation class EditServlet
 */

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
    	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
        {
        	int id = Integer.parseInt(req.getParameter("id"));
        	
        	UsersDao ua = new UsersDao(getServletContext());
        	Users u = ua.getUserById(id);
        	
        	
        	req.setAttribute("user", u);
        	
        	
        	req.getRequestDispatcher("/edit.jsp").forward(req,res);
        	
        	
        }


}
