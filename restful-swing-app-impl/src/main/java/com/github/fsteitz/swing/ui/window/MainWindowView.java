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
import java.awt.Font;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.github.fsteitz.swing.core.view.MVCView;

/**
 * @author Florian Steitz
 */
class MainWindowView extends JFrame implements MVCView
{
   private static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 16);
   private static final int APP_SIZE = 500;

   private JLabel messageLabel;
   private JButton openHelloWindowButton;

   /**
    *
    */
   MainWindowView()
   {
      super("RESTful Swing App");

      // Creating child components.
      messageLabel = new JLabel("Aktuell ist keine Nachricht vorhanden.");
      messageLabel.setFont(DEFAULT_FONT);

      openHelloWindowButton = new JButton("Fenster \"Hallo\" öffnen");
      openHelloWindowButton.addActionListener(event -> showHelloWindow());
      openHelloWindowButton.setFont(DEFAULT_FONT);

      // Adding child components.
      addComponentsInsidePanel(messageLabel, openHelloWindowButton);

      // Configuring the current window.
      applyDefaultWindowSettings(this);
      setSize(APP_SIZE, APP_SIZE);
   }

   /**
    * @param text
    */
   void setMessageLabelText(String text)
   {
      SwingUtilities.invokeLater(() -> messageLabel.setText(text));
   }

   /**
    *
    */
   void clickHelloWindowButton()
   {
      SwingUtilities.invokeLater(openHelloWindowButton::doClick);
   }

   /**
    * @param components
    */
   private void addComponentsInsidePanel(JComponent... components)
   {
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

      Arrays.stream(components).forEach(panel::add);
      add(panel);
   }

   /**
    *
    */
   private void showHelloWindow()
   {
      JFrame window = new JFrame("Hallo!");
      window.setSize(APP_SIZE, 100);
      window.add(createHelloLabel());
      applyDefaultWindowSettings(window);
   }

   /**
    * @return
    */
   private JLabel createHelloLabel()
   {
      JLabel label = new JLabel("Hallo, lieber Anwender!");
      label.setFont(DEFAULT_FONT);

      return label;
   }

   /**
    * @param window
    */
   private void applyDefaultWindowSettings(JFrame window)
   {
      window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      window.setBackground(new Color(250, 250, 250));
      window.setVisible(true);
   }
}
