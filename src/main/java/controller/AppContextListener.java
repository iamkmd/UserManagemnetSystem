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
			
		     //store whole props object in one go
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
