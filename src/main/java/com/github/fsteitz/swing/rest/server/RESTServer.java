package com.github.fsteitz.swing.rest.server;

import com.github.fsteitz.swing.rest.application.RESTApplication;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyContextParameters;

/**
 * @author Florian Steitz (fst)
 */
public class RESTServer
{
   private static final String CONTEXT_ROOT = "/";
   private static final String REST_API_ROOT = "/api";
   private static final String REST_API_ROOT_MAPPING = REST_API_ROOT + "/*";

   private int port;

   /**
    * @param port
    */
   public RESTServer(int port)
   {
      this.port = port;
   }

   /**
    * @throws Exception
    */
   public void start() throws Exception
   {
      Server server = new Server(port);

      ServletContextHandler servletContextHandler = new ServletContextHandler(server, CONTEXT_ROOT);
      servletContextHandler.addServlet(createRESTEasyServletHolder(), REST_API_ROOT_MAPPING); // Add a RESTEasy servlet for path "/api".
      servletContextHandler.addServlet(createDefaultServletHolder(), CONTEXT_ROOT); // Add a default servlet for path "/".

      server.start(); // Start the server.
      server.join(); // Block execution of the current thread until the server stops.
   }

   /**
    * @return
    */
   private ServletHolder createRESTEasyServletHolder()
   {
      ServletHolder servletHolder = new ServletHolder(new HttpServletDispatcher());
      servletHolder.setInitParameter(ResteasyContextParameters.RESTEASY_SERVLET_MAPPING_PREFIX, REST_API_ROOT);
      servletHolder.setInitParameter("javax.ws.rs.Application", RESTApplication.class.getName());

      return servletHolder;
   }

   /**
    * @return
    */
   private ServletHolder createDefaultServletHolder()
   {
      return new ServletHolder(new DefaultServlet());
   }
}
