package datastructuresproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InternetCat(String[] tags, String mimetype, int size, String created_at, String id) {
   InternetCat(){
      this(null, "", 0, "", "1");
   }
}
