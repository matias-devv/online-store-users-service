package com.onlinestore.users_service.controller;

import com.onlinestore.users_service.dto.UserDTO;
import com.onlinestore.users_service.model.User;
import com.onlinestore.users_service.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "API for user management")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @PostMapping("/create")
    @Operation(
            summary = "Create a new user",
            description = "Creates a new user with an empty shopping cart list. Shopping carts are associated later by the Shopping Cart Service."
    )
    @ApiResponse(
            responseCode = "200",
            description = "User created successfully",
            content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
    )
    public String createUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User data to create. Shopping cart list is initialized as empty.",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = UserDTO.class),
                            examples = @ExampleObject(
                                    name = "Create user example",
                                    value = "{\"username\": \"john_doe\", \"dni\": \"12345678\", \"gmail\": \"john.doe@example.com\"}"
                            )
                    )
            )
            @RequestBody UserDTO userDTO
    ){
        return iUserService.createUser(userDTO);
    }


    @PostMapping("/create-all")
    @Operation(
            summary = "Create multiple users",
            description = "Batch creation of users for initial data loading or bulk operations. All users start with empty shopping cart lists."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Users created successfully",
            content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
    )
    public String createAllUsers(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "List of users to create",
                    required = true
            )
            @RequestBody List<User> users
    ){
        return iUserService.createAllUsers(users);
    }


    @PutMapping("/update")
    @Operation(
            summary = "Update user information",
            description = "Updates user data including associated shopping cart IDs"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation completed",
                    content = @Content(
                            mediaType = "text/plain",
                            schema = @Schema(implementation = String.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Success",
                                            value = "The user was successfully updated"
                                    ),
                                    @ExampleObject(
                                            name = "Not found",
                                            value = "The user could not be found"
                                    )
                            }
                    )
            )
    })
    public String updateUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "User data to update. Must include user ID.",
                    required = true
            )
            @RequestBody UserDTO userDTO
    ){
        return iUserService.updateUser(userDTO);
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a user")
    @ApiResponse(
            responseCode = "200",
            description = "User deleted successfully",
            content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
    )
    public String deleteUser(
            @Parameter(description = "User ID to delete", required = true, example = "1")
            @PathVariable Long id
    ){
        return iUserService.deleteUser(id);
    }


    @PostMapping("/find/{id}")
    @Operation(summary = "Find user by ID")
    @ApiResponse(
            responseCode = "200",
            description = "User found",
            content = @Content(schema = @Schema(implementation = UserDTO.class))
    )
    public UserDTO findByUserId(
            @Parameter(description = "User ID", required = true, example = "1")
            @PathVariable Long id
    ){
        return iUserService.findByUserId(id);
    }


    @GetMapping("/find-all")
    @Operation(summary = "Get all users")
    @ApiResponse(
            responseCode = "200",
            description = "List of all users",
            content = @Content(schema = @Schema(implementation = UserDTO.class, type = "array"))
    )
    public List<UserDTO> findAllUsers(){
        return iUserService.findAllUsers();
    }
}
