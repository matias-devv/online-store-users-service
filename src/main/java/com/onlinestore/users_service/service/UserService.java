package com.onlinestore.users_service.service;

import com.onlinestore.users_service.dto.UserDTO;
import com.onlinestore.users_service.model.User;
import com.onlinestore.users_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public String createUser(UserDTO userDTO) {
        iUserRepository.save( this.convertDTOtoEntity(userDTO));
        return "The user was successfully created";
    }

    private User convertDTOtoEntity(UserDTO userDTO) {
        User user = new User();
        user.setDni(userDTO.getDni());
        user.setGmail(userDTO.getGmail());
        user.setUsername(userDTO.getUsername());
        user.setIds_shopping_cart(userDTO.getIds_shopping_cart());
        return user;
    }

    @Override
    public String createAllUsers(List<User> users) {
        iUserRepository.saveAll(users);
        return "The users have been successfully created";
    }

    //The main function of this method is to update the USER product list
    @Override
    public String updateUser(UserDTO userDTO) {
        User user = iUserRepository.findById(userDTO.getId()).orElse(null);

        if ( user == null){
            return "The user could not be found";
        }

        user.setGmail(userDTO.getGmail());
        user.setUsername(userDTO.getUsername());
        user.setDni(userDTO.getDni());
        user.setIds_shopping_cart(userDTO.getIds_shopping_cart());
        iUserRepository.save(user);
        return "The user was successfully updated";
    }

    @Override
    public String deleteUser(Long id) {
        iUserRepository.deleteById(id);
        return "The user was successfully deleted";
    }

    @Override
    public UserDTO findByUserId(Long id) {
        User user = iUserRepository.findById(id).orElse(null);
        return this.convertUserToDTO(user);
    }

    private UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setDni(user.getDni());
        userDTO.setGmail(user.getGmail());
        return userDTO;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> listUsers = iUserRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : listUsers){
            //convert the user to DTO and add it to the list
            userDTOs.add( convertUserToDTO(user) );
        }
        return userDTOs;
    }
}
