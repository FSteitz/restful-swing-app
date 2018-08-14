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

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.github.fsteitz.swing.core.view.MVCView;

/**
 * @author Florian Steitz
 */
class MainWindowView extends JFrame implements MVCView
{
   /**
    *
    */
   MainWindowView()
   {
      super("RESTful Swing App");

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setBackground(new Color(250, 250, 250));
      setSize(500, 500);
      setVisible(true);
   }
}
