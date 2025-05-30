package datastructuresproject.view;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.net.URL;

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
      this.mainPanel = new JPanel(new GridLayout(3, 0));
      this.catLabel = new JLabel("Cat");
      this.getCatButton = new JButton("Get Cat Data");
      // this.saveCatButton = new JButton("Save Cat Data");
      // this.singleCatRadio = new JRadioButton("Single Cat");
      // this.groupCatRadio = new JRadioButton("Multiple Cats");
      // this.buttonGroup = new ButtonGroup();
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
      // setBackground(Color.DARK_GRAY);
      setLayout(layout);

      // menuPanel.add(singleCatRadio);
      // menuPanel.add(groupCatRadio);
      mainPanel.add(catTextField);
      this.add(getCatButton);
      // menuPanel.add(saveCatButton);
      mainPanel.add(catLabel);
      mainPanel.add(catPane);

      // mainPanel.add(menuPanel);

      this.add(mainPanel);

      // buttonGroup.add(singleCatRadio);
      // buttonGroup.add(groupCatRadio);
   }

   private void setupLayout(){
      layout.putConstraint(SpringLayout.NORTH, mainPanel, 20, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, mainPanel, -600, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.SOUTH, mainPanel, -20, SpringLayout.SOUTH, this);
      layout.putConstraint(SpringLayout.WEST, mainPanel, 20, SpringLayout.WEST, this);
   }

   private void setupListeners(){
      getCatButton.addActionListener(click -> getCats(catTextField.getText()));
   }

   private void loadCatImage(String catDetails){
      ImageIcon catPicture = null;

      try {
         URL catURL = app.getCatImageURL(catDetails);
         BufferedImage image = ImageIO.read(app.getCatImageURL(catDetails));
         if (image != null){
            catPicture = new ImageIcon(image);
         }
      } catch (IOException error){
         app.handleError(error);
      }
      catLabel.setIcon(catPicture);
   }

   private void getCats(String tag){
      String results = app.addCat(tag);
      catTextArea.setText(results);
      loadCatImage(results);
   }
}
