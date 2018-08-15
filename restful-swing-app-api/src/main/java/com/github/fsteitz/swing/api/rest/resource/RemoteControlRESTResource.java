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
package com.github.fsteitz.swing.api.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.fsteitz.swing.api.rest.request.RESTUpdateMessageLabelRequest;

/**
 * A REST resource that offers endpoints for manipulating the GUI.
 *
 * @author Florian Steitz (fst)
 */
@Path(RemoteControlRESTResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RemoteControlRESTResource extends RESTResource
{
   String PATH = "/remoteControl";

   /**
    * Updates the main window's message label.
    *
    * @param request Request object that contains the text to show in the  main window's message label.
    * @return A response that indicates whether the operation was successful.
    */
   @POST
   @Path("/updateMessageLabel")
   Response updateMessageLabel(RESTUpdateMessageLabelRequest request);

   /**
    * Opens the "hello window".
    *
    * @return A response that indicates whether the operation was successful.
    */
   @POST
   @Path("/openHelloWindow")
   Response openHelloWindow();
}
