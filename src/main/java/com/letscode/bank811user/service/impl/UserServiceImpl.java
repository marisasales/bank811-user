package com.letscode.bank811user.service.impl;

import com.letscode.bank811user.dto.UserRequest;
import com.letscode.bank811user.dto.UserResponse;
import com.letscode.bank811user.model.User;
import com.letscode.bank811user.repository.UserRepository;
import com.letscode.bank811user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {

        User user = new User(userRequest);
        userRepository.save(user);
        return new UserResponse(user);
    }

    @Override
    public Page<UserResponse> getAll(String name, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

        if (name != null) {
            return new PageImpl<>(
                UserResponse.toResponse(userRepository.findByName(name, pageRequest).getContent()),
                pageRequest,
                userRepository.count());
        }

        return new PageImpl<>(
            UserResponse.toResponse(userRepository.findAll(pageRequest).getContent()),
            pageRequest,
            userRepository.count());
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserResponse update(UserRequest userRequest, Integer id) {
        User user = userRepository.findById(id).orElseThrow();

        user.setName(userRequest.getName());
        user.setCpf(userRequest.getCpf());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);

        return new UserResponse(user);
    }

    @Override
    public void delete(Integer id) { userRepository.deleteById(id); }
}
