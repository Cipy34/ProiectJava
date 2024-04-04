package Java_Project.Formats;

import Java_Project.Song.Song;
import Java_Project.SongCommands.CreateSong;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public final class CSV {
    private final List<Song> songs;

    public CSV(List<Song> songs) {
        this.songs = songs;
    }

    public void read(){
        String csvFilePath = "D:\\facultate\\an 2\\s2\\java\\ProiectJava\\src\\main\\java\\Java_Project\\Input\\songs.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextRecord;
            nextRecord = reader.readNext();
            while ((nextRecord = reader.readNext()) != null) {
                Song song = new Song(nextRecord[0], nextRecord[1], Integer.parseInt(nextRecord[2]));
                CreateSong cs = new CreateSong(songs, song);
                cs.run();
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
