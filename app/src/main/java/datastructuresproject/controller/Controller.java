package datastructuresproject.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import datastructuresproject.view.DataFrame;
public class Controller {
   private DataFrame window;

   public Controller(){
      this.window = new DataFrame(this);
   }

   public void start(){
      // setItUp();
      // hashItOut();
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
      JOptionPane.showMessageDialog(window, "HashMap Demo:");
      HashMap<String, Integer> mapDemo = new HashMap<String, Integer>();

      mapDemo.put("",1);
      mapDemo.put("text", Integer.valueOf(123));
      int favoriteNumber = 27;
      mapDemo.put("Carson", favoriteNumber);
      mapDemo.put("Key", favoriteNumber);

      for (Map.Entry<String, Integer> mapEntry : mapDemo.entrySet()){
         String key = mapEntry.getKey();
         int value = mapEntry.getValue();

         JOptionPane.showMessageDialog(window, "Key " + key + " : Value " + value);
      }

      String result = "Hashmap Values:";

      Iterator<Map.Entry<String, Integer>> hashInteger = mapDemo.entrySet().iterator();
      while(hashInteger.hasNext()){
         Map.Entry<String, Integer> entry = hashInteger.next();
         result += "\n\"" + entry.getKey() + "\": " + entry.getValue();
   }
      JOptionPane.showMessageDialog(window, result);
   }
   public void handleError(Exception error){
      JOptionPane.showMessageDialog(window, error.getMessage(), "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
   }

   public void save(String content, String filepath){
      IOController.writeTextToFile(this, content, filepath);
   }

   public String load(String filepath){
      return IOController.readTextFromFile(this, filepath);
   }
   
   public String addCat(String tags){
      return "";
   }

   public URL getCatImageURL(String source){
      URL catImageURL = null;

      return catImageURL;
   }
}
