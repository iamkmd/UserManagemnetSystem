package Dao;
import model.DbConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

public class UsersDao {
	
	// Logger
	private static final Logger logger = Logger.getLogger(UsersDao.class.getName());
	
	
	//serveletcontext 
	private ServletContext  ctx;
	
	public  UsersDao(ServletContext ctx)
	{
		this.ctx=ctx;
	}
	
	public  boolean saveUser(Users u)
	{
		
		
		boolean status = false;
		
		try
		{
			//connectin from Dbconnection
			Connection con = DbConnection.getConnection(this.ctx);
			
			//create statement
			
			PreparedStatement ps = con.prepareStatement("Insert into Users values(?,?,?,?)");
			
			//setting values
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3,u.getEmail());
			ps.setBytes(4, u.getImage());
			
			//execute Query
			 int rows = ps.executeUpdate();

	            if (rows > 0) {

	                status = true;
	                logger.info("User Saved Succesfully. Id: " + u.getId()); // info
	            }

	        } 
		  catch (Exception e) {

	            logger.severe("Error in  savUser: " + e.getMessage()); //severe
	        }

	        return status;
			
			
		}
	
	
	// get All Users 
	public List<Users> getAll() throws Exception {

	    List<Users> list = new ArrayList<>();

	    try
	    {
	    	//logger
	    	logger.info("Fetching all the Database"); //info
	    	
	    	Connection con = DbConnection.getConnection(this.ctx);
		   
	    	//create statement
		    PreparedStatement ps = con.prepareStatement("Select id,name,email,image from users");
		    ResultSet rs = ps.executeQuery();

		    while (rs.next()) {
		        Users u = new Users();
		        u.setId(rs.getInt("id"));
		        u.setName(rs.getString("name"));
		        u.setEmail(rs.getString("email"));
		        u.setImage(rs.getBytes("image"));
		        list.add(u);
		        
		       
	       }
		    logger.info("Total user fetched: " + list.size()); // info
	    }
		    
		    catch (Exception e) {

	            logger.severe("Error in getAll: " + e.getMessage()); //severe
	        }
	    
		    return list;
	    
	    }


	public Users getUserById(int id) {
		Users u = null;
		try {
			//logger
			logger.info("Fetching user by Id" + id); // info
			
			Connection con = DbConnection.getConnection(this.ctx);
			
			PreparedStatement ps = con.prepareStatement("SELECT id, name, email, image FROM users WHERE id = ?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				u = new Users();
	            u.setId(rs.getInt("id"));
	            u.setName(rs.getString("name"));
	            u.setEmail(rs.getString("email"));
	            u.setImage(rs.getBytes("image"));
				
	            logger.info("Fetched User: " +id); // info
			}
			else
			{
				logger.warning("Oops! user not Found with id: " +id); // warning
				
			}	
		}
		catch (Exception e)
		{
			
	         logger.severe("Error in getUserById " + id);
			
		}
		return u;
	}


	public boolean updateUser(Users u) {
		boolean status = false;
		try {
			
			logger.info("Upadating the User : " + u.getId());
			
			Connection con = DbConnection.getConnection(this.ctx);
			
			PreparedStatement ps;
			
			// if image is not updated
			if(u.getImage() == null)
			{
				ps = con.prepareStatement("update users set name=?, email=? where id=?");
				
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setInt(3, u.getId());
				
				;
			}
			
			else
			{
				ps = con.prepareStatement("update users set name=?, email=?, image =? where id=?");
				
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setBytes(3, u.getImage());
				ps.setInt(4, u.getId());
				
			}
			
			int rows = ps.executeUpdate();
			
			if(rows > 0)
			{
				status = true;
				logger.info("Upadating the User's info : " + u.getId());
			}
			
			
			
		}
		catch(Exception e)
		{
			
			logger.severe("error in updateUser: " + e.getMessage());
		}
		return status;
	}


	public boolean deleteUser(int id) {
		
	       boolean status = false;
	       
	       try {
	    	   logger.info("Deleting the user: " + id);
	    	   
	    	   Connection con = DbConnection.getConnection(this.ctx);
	    	   
	    	   //create statement 
	    	   PreparedStatement ps = con.prepareStatement("delete from users where id=?");
	    	   
	    	   ps.setInt(1, id);
	    	   
	    	   int rows = ps.executeUpdate();
	    	   
	    	   if(rows > 0)
	    	   {
	    		   status = true;
	    		   logger.info("Succesfully Delete the User: " + id);
	    	   }
	    	     
	    	    
	    	   
	       } catch(Exception e)
	       {
	    	   logger.severe("Error in deleteUser: " + e.getMessage());
	       }
		
		return status;
	}
}

	    
	
		
	
	
	
