package pl.adambaranowski.dbproject.model;

import lombok.Data;

@Data
public class Vote {
    private int vote_id;
    private int song_id;
    private int user_id;
}
