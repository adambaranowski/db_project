package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Album {
    private int album_id;
    private String album_name;
    private String category_id;
}
