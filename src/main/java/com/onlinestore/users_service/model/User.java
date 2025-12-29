package com.onlinestore.users_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String dni;
    private String gmail;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> ids_shopping_cart;
}
