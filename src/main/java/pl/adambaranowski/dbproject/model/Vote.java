package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Vote {
    private Integer vote_id;
    private Integer song_id;
    private Integer user_id;
}
