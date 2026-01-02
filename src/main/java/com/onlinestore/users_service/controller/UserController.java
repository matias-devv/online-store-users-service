package com.onlinestore.users_service.controller;

import com.onlinestore.users_service.dto.UserDTO;
import com.onlinestore.users_service.model.User;
import com.onlinestore.users_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/create")
    public String createUser(@RequestBody UserDTO userDTO){
        return iUserService.createUser(userDTO);
    }

    @PostMapping("/create-all")
    public String createAllUsers(@RequestBody List<User> users){
        return iUserService.createAllUsers(users);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody UserDTO userDTO){
        return iUserService.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return iUserService.deleteUser(id);
    }

    @GetMapping("/find/{id}")
    public UserDTO findByUserId(@PathVariable Long id){
        return iUserService.findByUserId(id);
    }

    @GetMapping("/find-all")
    public List<UserDTO> findAllUsers(){
        return iUserService.findAllUsers();
    }

}
