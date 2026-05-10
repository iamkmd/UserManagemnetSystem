package controller;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener  implements ServletContextListener {
	
	private static final Logger logger = Logger.getLogger(AppContextListener.class.getName());
	
	
	 public void contextInitialized(ServletContextEvent sce)
	 
	 {
		 logger.info("Application Started! Loading system.properties...");
		 
		 try {
			 ServletContext ctx = sce.getServletContext();
			 
			 //read the System.prperties file as stream
			 
			 InputStream in = ctx.getResourceAsStream("/WEB-INF/system.properties");
			 
			 //load into properties object
			 Properties props = new Properties();
			 props.load(in);
			 
			 //store in ServletContext so everyone can use it
			 

		        System.out.println("driver   = " + props.getProperty("driver"));
		        System.out.println("url      = " + props.getProperty("url"));
		        System.out.println("username = " + props.getProperty("username"));
		        System.out.println("password = " + props.getProperty("password"));

		        // ← store whole props object in one go
		        ctx.setAttribute("props", props);
			 
			 
			 logger.info("system.properties loaded succesfully");
		 }
		 catch(Exception e)
		 {
			 logger.severe("Failed to load system.properties: " + e.getMessage());
		 }
	 }
		 
		 
		 public void contextDestroyed(ServletContextEvent sce)
		 {
			 logger.info("Application stopped");
		 }
		 
	 
}
