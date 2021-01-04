package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Song {
    private int song_id;
    private String title;
    private int author_id;
    private int length_sec;
    private int is_single;
    private int album_id;
}
