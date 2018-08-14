/*
 * Copyright 2018 SHD Einzelhandelssoftware GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
