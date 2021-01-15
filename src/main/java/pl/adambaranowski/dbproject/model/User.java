package pl.adambaranowski.dbproject.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer user_id;
    private String username;
    private String email;
    private String password_hash;
    private Timestamp create_time;
}
