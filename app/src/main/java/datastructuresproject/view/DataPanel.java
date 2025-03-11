package datastructuresproject.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import datastructuresproject.controller.Controller;

public class DataPanel extends JPanel {
   private Controller app;
   private SpringLayout layout;
   private JScrollPane scrollPane;
   private JTextArea dataArea;
   private JPanel nonLinearPanel;
   private JPanel linearPanel;

   private  HashMap<String, JButton> nonLinearButtons;
   private  HashMap<String, JButton> linearButtons;
   
   public DataPanel(Controller app){
      super();
      this.app = app;
      this.layout = new SpringLayout();

      this.scrollPane = new JScrollPane();
      this.dataArea = new JTextArea();

      this.nonLinearPanel = new JPanel(new GridLayout(2, 4));
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

      setupDataText();
      setupPanel();
      setupLayout();
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

      this.add(scrollPane);

      repaint();
   }

   private void setupDataText() {
      dataArea.setEditable(false);
      dataArea.setBackground(Color.LIGHT_GRAY);
      dataArea.setLineWrap(true);
      dataArea.setWrapStyleWord(true);

      scrollPane.setViewportView(dataArea);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
   }

   private void setupLayout(){
      layout.putConstraint(SpringLayout.WEST, nonLinearPanel, -300, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.EAST, nonLinearPanel, 0, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.SOUTH, nonLinearPanel, -200, SpringLayout.SOUTH, this);
      layout.putConstraint(SpringLayout.NORTH, nonLinearPanel, 200, SpringLayout.NORTH, this);

      layout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, nonLinearPanel);
      layout.putConstraint(SpringLayout.SOUTH, scrollPane, 400, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, scrollPane, -20, SpringLayout.WEST, nonLinearPanel);
      layout.putConstraint(SpringLayout.WEST, scrollPane, 20, SpringLayout.WEST, this);
   }

   private void loadText(String content){
      String loadedText = app.load(content + ".txt");
      dataArea.setText(loadedText);

      if (content.equals("Linear")){
         dataArea.setBackground(Color.CYAN);
      }
   }
}
