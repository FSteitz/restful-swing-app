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
package com.github.fsteitz.swing.core.propagator;

import java.util.ArrayList;
import java.util.Collection;

import com.github.fsteitz.swing.core.delegate.UIChangeDelegate;
import lombok.NonNull;

/**
 * Delegates calls that manipulate the GUI to all registered implementations of {@link UIChangeDelegate} that actually perform the manipulations.
 *
 * @author Florian Steitz (fst)
 */
public class UIChangePropagator
{
   private static final Collection<UIChangeDelegate> DELEGATES = new ArrayList<>();

   /**
    * Adds an implementation of {@link UIChangeDelegate} that will be called when the GUI shall be manipulated.
    *
    * @param delegate An implementation of {@link UIChangeDelegate} that will be called when the GUI shall be manipulated
    */
   public static void addDelegate(@NonNull UIChangeDelegate delegate)
   {
      DELEGATES.add(delegate);
   }

   /**
    * Updates the main window's message label by delegating the call to all available implementations of {@link UIChangeDelegate}.
    *
    * @param text The text to show in the  main window's message label.
    */
   public static void updateMessageLabel(@NonNull String text)
   {
      DELEGATES.forEach(delegate -> delegate.updateMessageLabel(text));
   }

   /**
    * Opens the "hello window" by delegating the call to all available implementations of {@link UIChangeDelegate}.
    */
   public static void openHelloWindow()
   {
      DELEGATES.forEach(UIChangeDelegate::openHelloWindow);
   }
}
