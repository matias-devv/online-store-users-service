package com.onlinestore.users_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(description = "User information")
public class UserDTO {

    @Schema(description = "Unique user ID", example = "100", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Username", example = "john_doe", required = true)
    private String username;

    @Schema(description = "National Identity Document", example = "12345678", required = true)
    private String dni;

    @Schema(description = "User email address", example = "john.doe@example.com", required = true)
    private String gmail;

    @Schema(description = "List of shopping cart IDs associated with the user")
    private List<Long> ids_shopping_cart;
}