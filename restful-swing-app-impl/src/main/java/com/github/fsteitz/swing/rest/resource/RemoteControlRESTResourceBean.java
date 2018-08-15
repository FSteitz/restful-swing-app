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
package com.github.fsteitz.swing.rest.resource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.github.fsteitz.swing.api.rest.request.RESTUpdateMessageLabelRequest;
import com.github.fsteitz.swing.api.rest.resource.RemoteControlRESTResource;
import com.github.fsteitz.swing.core.propagator.UIChangePropagator;
import lombok.NonNull;

/**
 * The default implementation of {@link RemoteControlRESTResource}.
 *
 * @author Florian Steitz (fst)
 */
@Path(RemoteControlRESTResourceBean.PATH) // Must be present, otherwise RESTEasy' auto configuration ignores this class.
public class RemoteControlRESTResourceBean implements RemoteControlRESTResource
{
   /**
    * {@inheritDoc}
    */
   @Override
   public Response updateMessageLabel(@NonNull RESTUpdateMessageLabelRequest request)
   {
      UIChangePropagator.updateMessageLabel(request.getMessage());
      return Response.ok().build();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Response openHelloWindow()
   {
      UIChangePropagator.openHelloWindow();
      return Response.ok().build();
   }
}
