package controller;

import java.io.IOException;
import java.io.InputStream;
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
public class UpdateServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(UpdateServlet.class.getName());
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException
	{
		 int id = Integer.parseInt(req.getParameter("id"));

	        String name = req.getParameter("name");

	        String email = req.getParameter("email");

	        Part imagePart = req.getPart("image");

	        byte[] imageBytes = null;

	        if(imagePart.getSize() > 0) {

	            InputStream is =
	                    imagePart.getInputStream();

	            imageBytes = is.readAllBytes();
	        }

	        Users u = new Users();

	        u.setId(id);
	        u.setName(name);
	        u.setEmail(email);
	        u.setImage(imageBytes);

	        UsersDao dao = new UsersDao(getServletContext());

	        boolean status = dao.updateUser(u);

	        if(status) {
	        	
	        	res.sendRedirect("viewAll");
	        	String updatemsg = (String)getServletContext().getAttribute("updatemsg");
                req.setAttribute("msg", updatemsg);
	            logger.info(updatemsg);

	        } else {
                    
	        	req.setAttribute("msg", "The User is not updated");
	            logger.severe("Upadate Failed"); // error
	        }
	    }
	}
	


