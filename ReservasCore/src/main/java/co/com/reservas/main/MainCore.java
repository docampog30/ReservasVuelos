package co.com.reservas.main;

import javax.enterprise.event.Observes;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import co.com.reservas.application.rest.AdminReservaService;
import co.com.reservas.config.CORSFilter;
public class MainCore {

    private void initServer() {
	try {
	    final ResourceConfig resourceConfig = new ResourceConfig();
	    resourceConfig.register(AdminReservaService.class);
	    resourceConfig.register(JacksonFeature.class);
	    resourceConfig.register(new CORSFilter());

	    final ServletContainer servletContainer = new ServletContainer(resourceConfig);
	    final ServletHolder sh = new ServletHolder(servletContainer);
	    final Server server = new Server(8181);
	    
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/app");
        context.addServlet(sh, "/*");
        
	    
	    server.setHandler(context);
	    server.start();
	    server.join();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public static void main(String[] args) {
    	StartMain.main(args);
    }

    public void start(@Observes final ContainerInitialized event) {
	try {
	    initServer();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
