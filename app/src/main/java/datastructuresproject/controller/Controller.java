package datastructuresproject.controller;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import datastructuresproject.view.DataFrame;

public class Controller {
   private DataFrame window;

   public Controller(){
      this.window = new DataFrame(this);
   }

   public void start(){
      setItUp();
   }

   private void setItUp(){
      HashSet<String> testSetExample = new HashSet<String>();

      testSetExample.add("Adding text");
      testSetExample.add("Order not guaranteed");
      String sample = "Some text";
      testSetExample.add(sample);

      JOptionPane.showMessageDialog(window, "Entry count: " + testSetExample.size());

      boolean canAdd = testSetExample.add("Some text");
      JOptionPane.showMessageDialog(window, "Text has been added: " + canAdd);

      for (int count = 0; count < 4; count++){
         testSetExample.add("Hash " + count);
      }

      String result = "";
      Iterator<String> setIterator = testSetExample.iterator();
      
      while(setIterator.hasNext()){
         result += setIterator.next() + "\n";
      }

      JOptionPane.showMessageDialog(window, "Set Items: \n" + result);

   }
   private void hashItOut(){

   }
   public void handleError(Exception error){

   }
}
