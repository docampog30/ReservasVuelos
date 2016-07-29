package co.com.reservas.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class MainFront {
	public static void main(String [] args) throws Exception {
		Server server = new Server(8080);         

	    WebAppContext webContext = new WebAppContext();
	    webContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
	    webContext.setResourceBase("src/main/webapp");    
	    webContext.setContextPath("/reservas");
	    webContext.setServer(server);
	    webContext.setParentLoaderPriority(true);
	    server.setHandler(webContext);
	    
	    ServletHolder restServlet = webContext.addServlet(ServletContainer.class,  "/rest/*");
		restServlet.setInitOrder(0);
		restServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, "co.com.reservas");

	    server.start();
	    server.join();
    }
}
