package domain.models;

public class Song implements Comparable<Song>{


    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Song another) {
        return getScore() - another.getScore();
    }
}
