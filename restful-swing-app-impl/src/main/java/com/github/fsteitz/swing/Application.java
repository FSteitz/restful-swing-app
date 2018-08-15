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
package com.github.fsteitz.swing;

import com.github.fsteitz.swing.core.propagator.UIChangePropagator;
import com.github.fsteitz.swing.rest.server.RESTServer;
import com.github.fsteitz.swing.ui.window.MainWindowCtrl;

/**
 * Class that bootstraps the application.
 *
 * @author Florian Steitz
 */
public class Application
{
   /**
    * Opens a main window that contains the App's GUI and starts a web server, that makes the GUI controllable via a REST API.
    *
    * @param args Command line arguments passed to this application.
    */
   public static void main(String[] args)
   {
      // When MainWindowCtrl is created, it immediately creates a window. Hence no further methods need to be called in order to show the main window.
      // UIChangePropagator serves as the primary entry point for manipulating the GUI via a REST API. Therefore, it needs the current instance of
      // the main window's controller to be able to manipulate it.
      UIChangePropagator.addDelegate(new MainWindowCtrl());

      try
      {
         new RESTServer(1234).start(); // Start the web server on port 1234.
      }
      catch(Exception e)
      {
         e.printStackTrace(); // TODO Logging
      }
   }
}
