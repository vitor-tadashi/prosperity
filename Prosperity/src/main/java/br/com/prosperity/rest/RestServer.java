
package br.com.prosperity.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class RestServer {
	public static void main(String[] args) {
		ResourceConfig config = new ResourceConfig();
    	config.packages("br.com.verity.rest");
    	ServletHolder servlet = new ServletHolder(new ServletContainer(config));

    	Server server = new Server(2222);
    	ServletContextHandler context = new ServletContextHandler(server, "/*");
    	context.addServlet(servlet, "/*");

    	/*try {
    	     server.start();
    	     server.join();
    	 }  {
    	     server.destroy();
    	 }*/
    	try {
            server.start();
            server.join();
        } catch (Exception e) {
			System.out.println("Ocorreu o seguinte problema: " + e.getLocalizedMessage());
		} finally {
        	server.destroy();
        }
	}
}