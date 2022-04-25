package com.letscode.bank811user.controller;

import com.letscode.bank811user.dto.UserRequest;
import com.letscode.bank811user.dto.UserResponse;
import com.letscode.bank811user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserResponse> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "5") int size) {
        return userService.getAll(name, page, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getById(@PathVariable Integer id) {
        return new UserResponse(userService.getById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return userService.update(userRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { userService.delete(id); }
}
