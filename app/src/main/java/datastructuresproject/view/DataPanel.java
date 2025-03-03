package datastructuresproject.view;

import javax.swing.*;

import datastructuresproject.controller.Controller;

public class DataPanel extends JPanel {
   Controller app;
   
   public DataPanel(Controller app){
      super();
      this.app = app;
   }
}
