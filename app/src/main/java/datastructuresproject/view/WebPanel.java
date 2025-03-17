package datastructuresproject.view;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import datastructuresproject.controller.Controller;

public class WebPanel extends JPanel {
   private Controller app; 

   private SpringLayout layout;

   private JPanel mainPanel;
   private JPanel menuPanel;

   private JLabel catLabel;
   private JButton getCatButton;
   private JButton saveCatButton;
   private JRadioButton singleCatRadio;
   private JRadioButton groupCatRadio;
   private ButtonGroup buttonGroup;
   private JScrollPane catPane;
   private JTextArea catTextArea;
   private JTextField catTextField;

   public WebPanel(Controller app){
      super();
      this.app = app;

      this.layout = new SpringLayout();
      this.mainPanel = new JPanel(new GridLayout(1, 0));
      this.menuPanel = new JPanel(new GridLayout(0,1));
      this.catLabel = new JLabel("Cat");
      this.getCatButton = new JButton("Download Cat Data");
      this.saveCatButton = new JButton("Save Cat Data");
      this.singleCatRadio = new JRadioButton("Single Cat");
      this.groupCatRadio = new JRadioButton("Multiple Cats");
      this.buttonGroup = new ButtonGroup();
      this.catPane = new JScrollPane();
      this.catTextArea = new JTextArea();
      this.catTextField = new JTextField();


      setupTextArea();
      setupPanel();
      setupLayout();
      setupListeners();
   }

   private void setupTextArea(){
      catTextArea.setEditable(false);
      catTextArea.setLineWrap(true);
      catTextArea.setWrapStyleWord(true);

      catPane.setViewportView(catTextArea);
      catPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      catPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   }

   private void setupPanel(){
      setBackground(Color.DARK_GRAY);
      setLayout(layout);

      menuPanel.add(singleCatRadio);
      menuPanel.add(groupCatRadio);
      menuPanel.add(catTextField);
      menuPanel.add(getCatButton);
      menuPanel.add(saveCatButton);
      menuPanel.add(catPane);

      mainPanel.add(catLabel);
      mainPanel.add(menuPanel);

      this.add(mainPanel);

      buttonGroup.add(singleCatRadio);
      buttonGroup.add(groupCatRadio);
   }

   private void setupLayout(){
      layout.putConstraint(SpringLayout.NORTH, mainPanel, 20, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, mainPanel, -20, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.SOUTH, mainPanel, -20, SpringLayout.SOUTH, this);
      layout.putConstraint(SpringLayout.WEST, mainPanel, 20, SpringLayout.WEST, this);
   }

   private void setupListeners(){

   }

   private void loadCatImage(String catDetails){
      ImageIcon catPicture = null;

      try {
         BufferedImage image = ImageIO.read(app.getCatImageURL(catDetails));
         if (image != null){
            catPicture = new ImageIcon(image);
         }
      } catch (IOException error){
         app.handleError(error);
      }
      catLabel.setIcon(catPicture);
   }
}
