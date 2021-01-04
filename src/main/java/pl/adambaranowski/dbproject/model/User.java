package pl.adambaranowski.dbproject.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int user_id;
    private String username;
    private String email;
    private String password_hash;
    private LocalDateTime create_time;
}
