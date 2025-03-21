package datastructuresproject.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import datastructuresproject.model.InternetCat;
import datastructuresproject.view.DataFrame;
public class Controller {
   private DataFrame window;
   private String catURLBase;
   private String appendForJSON;
   private String defaultTag;
   private ArrayList<InternetCat> catList;

   public Controller(){
      this.window = new DataFrame(this);

      this.catURLBase = "https://cataas.com/cat/";
      this.appendForJSON = "?json=true";
      this.defaultTag = "cute";
      this.catList = new ArrayList<InternetCat>();
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
   

   private void testCatAPI(){
      // InternetCat demoCat = new InternetCat(null, "heyo", 0, defaultTag, catURLBase, appendForJSON)
   }
   public String addCat(String tag){
      String details = "";
      if (tag == null || tag.length() < 3){

      }
      return details;
   }

   public URL getCatImageURL(String source){
      URL catImageURL = null;

      return catImageURL;
   }

   private String generateRandomIntsToFile(int count){
      String content = "";

      for (int index = 0; index < count; index++){
         int random = (int) (Math.random() * 1000);
         content += random + "";
         if (index != count - 1){
            content += random + ",";
         }
      }

      save(content, "unsorted_numbers.csv");
      return content;
   }

   private int[] loadNumbers(String path){
      int[] numbers = null;

      String contents = load(path);
      String[] values = contents.split(",");
      numbers = new int[values.length];

      for (int index = 0; index < numbers.length; index++){
         numbers[index] = Integer.parseInt(values[index]);
      }
      return numbers;
   }
}
