package datastructuresproject.controller;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;

import datastructuresproject.model.InternetCat;

public class IOController {
   public static String readTextFromFile(Controller app, String path){
      String content = "";

      try (Scanner fileScanner = new Scanner(new File(path))){
         while(fileScanner.hasNext()){
            content += fileScanner.nextLine() + "\n";
         }
      } catch (NullPointerException | FileNotFoundException error){
         app.handleError(error);
      }

      return content;
   }

   public static void writeTextToFile(Controller app, String text, String path){
      try (
         PrintWriter textWriter = new PrintWriter(new File(path));
         Scanner stringScanner = new Scanner(text)
      ){
         while (stringScanner.hasNextLine()){
            textWriter.println(stringScanner.nextLine());
         }
      } catch (FileNotFoundException error){
         app.handleError(error);
      }
   }

   public static Object readSingleJSON(Controller app, String urlBase, String appended){
      ObjectMapper mapper = new ObjectMapper();

      try {
         if (urlBase.contains("cataas")){
            URL catUrl = (new URI(urlBase + appended)).toURL();
            System.out.println(catUrl.toString());
            InternetCat cat = mapper.readValue(catUrl, InternetCat.class);
            return cat;
         }
      } catch(IOException | URISyntaxException | ClassCastException error){
         app.handleError(error);
      }

      return null;
   }
}
