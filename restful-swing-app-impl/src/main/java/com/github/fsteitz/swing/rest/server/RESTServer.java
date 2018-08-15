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

import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.github.fsteitz.swing.Application;
import com.github.fsteitz.swing.api.rest.resource.RESTResource;
import com.github.fsteitz.swing.rest.application.RESTApplication;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.jboss.resteasy.plugins.servlet.ResteasyServletInitializer;
import org.reflections.Reflections;

/**
 * @author Florian Steitz (fst)
 */
public class RESTServer
{
   private static final String CONTEXT_ROOT = "/";

   private int port;
   private Set<Class<?>> restClasses;

   /**
    * @param port
    */
   public RESTServer(int port)
   {
      this.port = port;
      this.restClasses = new HashSet<>();
      this.restClasses.add(RESTApplication.class);
      this.restClasses.addAll(new Reflections(Application.class.getPackage().getName()).getSubTypesOf(RESTResource.class));
   }

   /**
    * @throws Exception
    */
   public void start() throws Exception
   {
      Server server = new Server(port);

      ServletContextHandler servletContextHandler = new ServletContextHandler(server, CONTEXT_ROOT);
      servletContextHandler.addLifeCycleListener(createServletInitializerListener(servletContextHandler.getServletContext()));

      server.start(); // Start the server.
      server.join(); // Block execution of the current thread until the server stops.
   }

   /**
    *
    */
   private LifeCycle.Listener createServletInitializerListener(ServletContext servletContext)
   {
      return new AbstractLifeCycle.AbstractLifeCycleListener()
      {
         @Override
         public void lifeCycleStarting(LifeCycle lifeCycle)
         {
            try
            {
               new ResteasyServletInitializer().onStartup(restClasses, servletContext);
            }
            catch(ServletException e)
            {
               e.printStackTrace(); // TODO logging
            }
         }
      };
   }
}
