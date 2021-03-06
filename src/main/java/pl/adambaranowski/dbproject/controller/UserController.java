package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.User;
import pl.adambaranowski.dbproject.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Object> createNewUser(@RequestParam String username){
        userService.addUser(username);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/user-id/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer user_id){
        User userById = userService.getUserById(user_id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        User userByUsername = userService.getUserByUsername(username);
        return new ResponseEntity<>(userByUsername, HttpStatus.OK);
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity deleteUserByUsername(@PathVariable String username){
        userService.deleteUserByUsername(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/user-id/{user_id}")
    public ResponseEntity deleteUserByUsername(@PathVariable Integer user_id){
        userService.deleteUserById(user_id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
