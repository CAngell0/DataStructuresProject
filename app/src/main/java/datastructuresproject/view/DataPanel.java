package datastructuresproject.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import datastructuresproject.controller.Controller;
import datastructuresproject.controller.IOController;

public class DataPanel extends JPanel {
   private Controller app;
   private SpringLayout layout;
   private JScrollPane scrollPane;
   private JTextArea dataArea;
   private JPanel nonLinearPanel;
   private JPanel linearPanel;
   private WebPanel webPanel;

   private  HashMap<String, JButton> structureButtons;
   private  HashMap<String, JButton> linearButtons;
   
   public DataPanel(Controller app){
      super();
      this.app = app;
      this.layout = new SpringLayout();

      this.scrollPane = new JScrollPane();
      this.dataArea = new JTextArea();

      this.nonLinearPanel = new JPanel(new GridLayout(2, 3));
      this.linearPanel = new JPanel(new GridLayout(2,2));
      this.structureButtons = new HashMap<String, JButton>();
      this.linearButtons = new HashMap<String, JButton>();

      this.webPanel = new WebPanel(app);

      structureButtons.put("Comparing Objects", new JButton("Comparing Objects"));
      structureButtons.put("Iterators", new JButton("Iterators"));
      structureButtons.put("Sets", new JButton("Sets"));
      structureButtons.put("HashMaps", new JButton("HashMaps"));
      structureButtons.put("Tree", new JButton("Tree"));
      structureButtons.put("2DArray", new JButton("2DArray"));
      // nonLinearButtons.put("Sorting Algorithms", new JButton("Sorting Algorithms"));
      // nonLinearButtons.put("Writing Text", new JButton("Writing Text"));

      // linearButtons.put("Arrays", new JButton("Arrays"));
      // linearButtons.put("ArrayLists", new JButton("ArrayLists"));
      // linearButtons.put("Stacks", new JButton("Stacks"));
      // linearButtons.put("Queues", new JButton("Queues"));

      setupDataText();
      setupPanel();
      setupLayout();
      setupListeners();
   }

   private void setupPanel(){
      this.setLayout(layout);

      for (Map.Entry<String, JButton> entry : structureButtons.entrySet()){
         nonLinearPanel.add(entry.getValue());
      }
      // for (Map.Entry<String, JButton> entry : linearButtons.entrySet()){
      //    linearPanel.add(entry.getValue());
      // }

      this.add(nonLinearPanel);
      // this.add(linearPanel);
      this.add(webPanel);

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


      layout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.SOUTH, scrollPane, 200, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, scrollPane, -20, SpringLayout.WEST, nonLinearPanel);
      layout.putConstraint(SpringLayout.WEST, scrollPane, 20, SpringLayout.WEST, this);

      layout.putConstraint(SpringLayout.NORTH, webPanel, 200, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.SOUTH, webPanel, 20, SpringLayout.SOUTH, this);
      layout.putConstraint(SpringLayout.EAST, webPanel, 200, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.WEST, webPanel, -20, SpringLayout.WEST, this);
   }

   private void setupListeners(){
      structureButtons.get("Comparing Objects").addActionListener(click -> loadText("./Compare"));
      structureButtons.get("Iterators").addActionListener(click -> loadText("./Iterator"));
      structureButtons.get("Sets").addActionListener(click -> loadText("./Set"));
      structureButtons.get("HashMaps").addActionListener(click -> loadText("./Hash"));
      structureButtons.get("Tree").addActionListener(click -> loadText("./Tree"));
      structureButtons.get("2DArray").addActionListener(click -> loadText("./TwoDArray"));
      // nonLinearButtons.get("Iterators").addActionListener(click -> loadText("./Iterators"));
      // nonLinearButtons.get("Iterators").addActionListener(click -> loadText("./Iterators"));
   }

   public void save(String content, String path){
      IOController.writeTextToFile(app, content, path);
   }

   public String load(String path){
      String content = IOController.readTextFromFile(app, path);

      return content;
   }

   private void loadText(String path){
      String loadedText = app.load(path + ".txt");
      dataArea.setText(loadedText);
   }
}
