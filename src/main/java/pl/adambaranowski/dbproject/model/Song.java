package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Song {
    private Integer song_id;
    private Integer number_of_votes;
    private String title;
    private Integer author_id;
    private Integer length_sec;
    private Integer is_single;
    private Integer album_id;
}
