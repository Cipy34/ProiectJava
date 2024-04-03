package Java_Project.Song;

import Java_Project.User.User;

public final class Song {
    private final String songName;
    private final String authorName;
    private final int year;
    private final int id;
    private static int nextid = 0;

    public Song(String songName, String authorName, int year) {
        this.songName = songName;
        this.authorName = authorName;
        this.year = year;
        this.id = nextid++;
    }

    public String getSongName() {
        return songName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getId(){
        return id;
    }

    public int getYear(){
        return year;
    }
}
