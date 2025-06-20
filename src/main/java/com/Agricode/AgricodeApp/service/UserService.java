package com.Agricode.AgricodeApp.service;

import com.Agricode.AgricodeApp.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO getUserById(Long id);
    Optional<UserDTO> getUserByEmail(String email);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
} 