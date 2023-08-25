package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> getById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.create(userModel));
    }
}
