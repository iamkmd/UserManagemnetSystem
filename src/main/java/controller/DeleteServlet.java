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

/**
 * Servlet implementation class DeleteServlet
 */

public class DeleteServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(DeleteServlet.class.getName());

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		UsersDao u = new UsersDao(getServletContext());
		boolean status = u.deleteUser(id);
		
		if(status)
		{
			res.sendRedirect("viewAll");
			String deletemsg = (String)getServletContext().getAttribute("deletemsg");
			req.setAttribute("msg", deletemsg);
			logger.info(deletemsg);
		}
		else
		{
			req.setAttribute("msg", "The user Is not deleted: ");
			logger.severe("Error in Deleting the User: " +id);
			
	}
	
  
}
}
