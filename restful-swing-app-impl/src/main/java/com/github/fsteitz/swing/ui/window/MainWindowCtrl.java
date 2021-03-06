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
package com.github.fsteitz.swing.ui.window;

import com.github.fsteitz.swing.core.controller.AbstractMVCController;
import com.github.fsteitz.swing.core.delegate.UIChangeDelegate;
import lombok.NonNull;

/**
 * The controller for {@link MainWindowView}.
 *
 * @author Florian Steitz
 */
public class MainWindowCtrl extends AbstractMVCController<MainWindowView> implements UIChangeDelegate
{
   /**
    * {@inheritDoc}
    */
   @Override
   public void updateMessageLabel(@NonNull String text)
   {
      getView().setMessageLabelText(text);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void openHelloWindow()
   {
      getView().clickHelloWindowButton();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected MainWindowView createView()
   {
      return new MainWindowView();
   }
}
