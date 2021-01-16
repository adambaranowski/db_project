package pl.adambaranowski.dbproject.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.adambaranowski.dbproject.model.User;

import java.util.List;

@Service
public class UserService {

    private static final String ADD_USER = "INSERT INTO users (username) VALUE (?);";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id=?;";
    private static final String DELETE_USER_BY_USERNAME = "DELETE FROM users WHERE username=?;";
    private static final String GET_USER_BY_ID = "SELECT * FROM  users WHERE user_id=? LIMIT 1;";
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM users WHERE username=? LIMIT 1;";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";

    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    public UserService(JdbcTemplate template) {
        this.template = template;
    }

    public void addUser(String username){
        template.update(ADD_USER, username);
    }

    public void deleteUserById(int user_id){
        template.update(DELETE_USER_BY_ID, user_id);
    }

    public void deleteUserByUsername(String username){
        template.update(DELETE_USER_BY_USERNAME, username);
    }


    public User getUserById(int user_id){
        List<User> query = template.query(GET_USER_BY_ID, rowMapper, user_id);
        return query.get(0);
    }

    public User getUserByUsername(String username){
        List<User> query = template.query(GET_USER_BY_USERNAME, rowMapper, username);
        return query.get(0);
    }

    public List<User> getAllUsers(){
        List<User> query = template.query(GET_ALL_USERS, rowMapper);
        return query;
    }
}
