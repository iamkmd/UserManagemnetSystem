package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.UsersDao;
import model.Users;


@MultipartConfig
public class UserServlet extends HttpServlet {
     
	public static final Logger logger = Logger.getLogger(UserServlet.class.getName());
	
	public void doPost(HttpServletRequest req,  HttpServletResponse res) throws IOException, ServletException
	{
		// form data (name,email,id)
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		// image data 
		Part imagepart = req.getPart("image");
		
		InputStream inputStream = imagepart.getInputStream();
		
		byte[] imageBytes= inputStream.readAllBytes();
		
		
		//crate object
		Users u = new Users();
		
		// set the parameters 
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setImage(imageBytes);
		
		// create object of dao
		UsersDao ua = new UsersDao(getServletContext());
		
		boolean status = ua.saveUser(u);
		
		 Properties props = (Properties) getServletContext().getAttribute("props");
		if(status)
		{
			
			 req.setAttribute("msg", props.getProperty("addmsg"));
			
			logger.info(props.getProperty("addmsg"));
			logger.info("Image size " + imageBytes.length + " bytes");
		}
		else
		{
			req.setAttribute("msg","Failed to Add User");
			logger.severe("Failed upload request User ");
			
		}
		
		
		res.sendRedirect("Register.jsp");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		logger.info("The User  requested  to register ");
        req.getRequestDispatcher("Register.jsp").forward(req, res);
           
          
}
	
	
}
