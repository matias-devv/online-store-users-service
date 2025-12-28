package com.onlinestore.users_service.service;

import com.onlinestore.users_service.dto.UserDTO;
import com.onlinestore.users_service.model.User;

import java.util.List;

public interface IUserService {

    public String createUser(User user);

    public String createAllUsers(List<User> users);

    public String updateUser(User user);

    public String deleteUser(Long id);

    public UserDTO findByUserId(Long id);

    public List<UserDTO> findAllUsers();

}
