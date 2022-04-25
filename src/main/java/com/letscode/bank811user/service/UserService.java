package com.letscode.bank811user.service;

import com.letscode.bank811user.dto.UserRequest;
import com.letscode.bank811user.dto.UserResponse;
import com.letscode.bank811user.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<UserResponse> getAll(String name, int page, int size);

    UserResponse create(UserRequest userRequest);

    User getById(Integer id);

    UserResponse update(UserRequest userRequest, Integer id);

    void delete(Integer id);
}
