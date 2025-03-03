package datastructuresproject.view;

import datastructuresproject.controller.Controller;

import javax.swing.JFrame;

public class DataFrame extends JFrame {
   private Controller app;
   private JFrame frame;
   
   public DataFrame(Controller app){
      super();
      this.app = app;
   }

   private void setupFrame(){
      this.setTitle("Data Structure Project");
      this.setSize(1920, 1080);
      this.setResizable(false);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      // this.setContentPane(panel);
      this.setVisible(true);
   }
}
