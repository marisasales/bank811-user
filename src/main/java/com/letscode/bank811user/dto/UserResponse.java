package com.letscode.bank811user.dto;

import com.letscode.bank811user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class UserResponse {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.creationDate = user.getCreationDate();
        this.updateDate = user.getUpdateDate();
    }

    public static List<UserResponse> toResponse(List<User> users) {
        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
