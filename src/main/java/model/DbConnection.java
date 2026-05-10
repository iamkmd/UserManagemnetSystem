package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

public class DbConnection {
	
	private static final Logger logger = Logger.getLogger(DbConnection.class.getName());
	
	 public static Connection getConnection(ServletContext ctx) {

	        Connection con = null;
	        
	       
	        try {
	        	
	        	Properties props = (Properties) ctx.getAttribute("props");
	        	
	        	// get the attributes 
	        	 String driver   = props.getProperty("driver");
	             String url      = props.getProperty("url");
	             String username = props.getProperty("username");
	             String password = props.getProperty("password");
	            
	            
	            //load the drivers
	             Class.forName(driver);
	             
	             //get the connection
	             con = DriverManager.getConnection(url,username,password);
	             
	             logger.info("DB connection succesful");
	            

	        } catch (Exception e) {
	            
	        	logger.severe("DB Connection failed: " +e.getMessage());
	        }

	        return con;
	    }
	}


