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
package com.github.fsteitz.swing.rest.application;

import java.util.Set;
import javax.ws.rs.core.Application;

import com.github.fsteitz.swing.rest.resource.RemoteControlRESTResourceBean;
import com.google.common.collect.Sets;

/**
 * @author Florian Steitz (fst)
 */
public class RESTApplication extends Application
{
   /**
    * @return
    */
   @Override
   public Set<Class<?>> getClasses()
   {
      return Sets.newHashSet(RemoteControlRESTResourceBean.class);
   }
}