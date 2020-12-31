package control;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bussinessmodel.BillingClerk;
import bussinessmodel.User;

/**
 * Application Lifecycle Listener implementation class AmazonSessionListener
 *
 */
@WebListener
public class AmazonSessionListener implements ServletContextListener, HttpSessionListener {

   

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Sessoin Created...");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("Session Destroyed...");
         HttpSession session = se.getSession();
         Object o = session.getAttribute("uname");
         if(o!=null) {
        	 String uname = (String)o;
        	 User user = new BillingClerk();
        	 user.logout(uname);
         }
    }

   
	
}
