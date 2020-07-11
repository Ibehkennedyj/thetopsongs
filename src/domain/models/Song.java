package domain.models;

 public class Song {


     private int score;
     private String albumName;

     public void setScore(int score) {
         this.score = score;
     }

     public int getScore() {
         return score;
     }

     public String getAlbumName() {
         return albumName;
     }

     public void setAlbumName(String albumName) {
         this.albumName = albumName;
     }
 }
