package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<UserModel> getById(UUID id) {
        return this.userRepository.findById(id);
    }

    public UserModel create(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

}
