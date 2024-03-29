package Java_Project.Song;

import Java_Project.User.User;

public final class Song {
    private final String songName;
    private final String authorName;
    private final int year;
    private static long id = 0;
    private final User user;

    public Song(String songName, String authorName, int year, User user) {
        this.songName = songName;
        this.authorName = authorName;
        this.year = year;
        this.user = user;
    }

    public static synchronized void CreateId(){
        id += 1;
    }

    public String getSongName() {
        return songName;
    }

    public String getAuthorName() {
        return authorName;
    }
}
