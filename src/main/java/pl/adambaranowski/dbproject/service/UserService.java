package pl.adambaranowski.dbproject.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Author;
import pl.adambaranowski.dbproject.model.Category;
import pl.adambaranowski.dbproject.model.Song;
import pl.adambaranowski.dbproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addUser", query = "INSERT INTO users (username) VALUES ?;")
@NamedNativeQuery(name = "deleteUserById", query = "DELETE FROM users WHERE user_id=?;")
@NamedNativeQuery(name = "deleteUserByUsername", query = "DELETE FROM users WHERE username=?;")
@NamedNativeQuery(name = "getUserById", query = "SELECT FROM  users WHERE user_id=? LIMIT 1;")
@NamedNativeQuery(name = "getUserByUsername", query = "SELECT FROM users WHERE username=? LIMIT 1;")
@NamedNativeQuery(name = "getAllUsers", query = "SELECT * FROM users;")
public class UserService {

    private EntityManager entityManager;

    @Autowired
    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addUser(String username){
        Query query = entityManager.createNativeQuery("addUser");
        query.setParameter(1, username);
        query.executeUpdate();
    }

    public void deleteUserById(int user_id){
        Query query = entityManager.createNativeQuery("deleteUserById");
        query.setParameter(1, user_id);
        query.executeUpdate();
    }

    public void deleteUserByUsername(String username){
        Query query = entityManager.createNativeQuery("deleteUserByUsername");
        query.setParameter(1, username);
        query.executeUpdate();
    }


    public User getUserById(int user_id){
        Query query = entityManager.createNativeQuery("getUserById", User.class);
        query.setParameter(1, user_id);
        List resultList = query.getResultList();
        return (User) resultList.get(0);
    }

    public User getUserByUsername(String username){
        Query query = entityManager.createNativeQuery("getUserByUsername", User.class);
        query.setParameter(1, username);
        List resultList = query.getResultList();
        return (User) resultList.get(0);
    }

    public List<User> getAllUsers(){
        Query query = entityManager.createNativeQuery("getAllUsers", User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }
}
