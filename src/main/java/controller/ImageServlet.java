package controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UsersDao;
import model.Users;


public class ImageServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(ImageServlet.class.getName());
       
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
    	int id = Integer.parseInt(req.getParameter("id"));
    	
    	UsersDao ua = new UsersDao(getServletContext());
    	Users u = ua.getUserById(id);
    	
    	if(u != null && u.getImage() != null)
    	{
    		res.setContentType("image/jpeg");
    		res.getOutputStream().write(u.getImage());
    		logger.info("The Image is retrived from the DB"); //info
    	}
    	else
    	{
    		logger.severe("Error in fetching image from DB"); //error
    	}
    }

}
