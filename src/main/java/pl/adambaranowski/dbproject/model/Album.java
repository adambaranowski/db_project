package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Album {
    private Integer album_id;
    private String album_name;
    private Integer category_id;
}
