package datastructuresproject.model;

public record InternetCat(String[] tags, String mimeType, int size, String createdDate, String editedDare, String _id) {
   InternetCat(){
      this(null, "", 0, "", "", "1");
   }
}
