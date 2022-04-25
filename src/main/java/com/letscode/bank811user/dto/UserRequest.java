package com.letscode.bank811user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {

    @Schema(description = "User's CPF", example = "28236048209")
    private String cpf;
    @Schema(description = "User's name", example = "Maria Giovana Rodrigues")
    private String name;
    @Schema(description = "User's password", example = "978546")
    private String password;
}
