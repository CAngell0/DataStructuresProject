package datastructuresproject.view;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import datastructuresproject.controller.Controller;

public class DataPanel extends JPanel {
   Controller app;
   SpringLayout layout;
   JPanel nonLinearPanel;
   JPanel linearPanel;

   HashMap<String, JButton> nonLinearButtons;
   HashMap<String, JButton> linearButtons;
   
   public DataPanel(Controller app){
      super();
      this.app = app;
      this.layout = new SpringLayout();
      this.nonLinearPanel = new JPanel(new GridLayout(4, 2));
      this.linearPanel = new JPanel(new GridLayout(2,2));
      this.nonLinearButtons = new HashMap<String, JButton>();
      this.linearButtons = new HashMap<String, JButton>();

      nonLinearButtons.put("Comparing Objects", new JButton("Comparing Objects"));
      nonLinearButtons.put("Iterators", new JButton("Iterators"));
      nonLinearButtons.put("Sets", new JButton("Sets"));
      nonLinearButtons.put("HashMaps", new JButton("HashMaps"));
      nonLinearButtons.put("Tree", new JButton("Tree"));
      nonLinearButtons.put("2DArray", new JButton("2DArray"));
      nonLinearButtons.put("Sorting Algorithms", new JButton("Sorting Algorithms"));
      nonLinearButtons.put("Writing Text", new JButton("Writing Text"));

      linearButtons.put("Arrays", new JButton("Arrays"));
      linearButtons.put("ArrayLists", new JButton("ArrayLists"));
      linearButtons.put("Stacks", new JButton("Stacks"));
      linearButtons.put("Queues", new JButton("Queues"));

      setupPanel();
   }

   private void setupPanel(){
      this.setLayout(layout);

      for (Map.Entry<String, JButton> entry : nonLinearButtons.entrySet()){
         nonLinearPanel.add(entry.getValue());
      }
      for (Map.Entry<String, JButton> entry : linearButtons.entrySet()){
         linearPanel.add(entry.getValue());
      }

      this.add(nonLinearPanel);
      this.add(linearPanel);

      repaint();
   }
}
