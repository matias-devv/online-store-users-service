package com.onlinestore.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Long id;
    private String username;
    private String dni;
    private String gmail;
 
    private List<Long> ids_shopping_cart;
}
