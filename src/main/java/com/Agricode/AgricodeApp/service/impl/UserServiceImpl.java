package com.Agricode.AgricodeApp.service.impl;

import com.Agricode.AgricodeApp.dto.UserDTO;
import com.Agricode.AgricodeApp.entity.User;
import com.Agricode.AgricodeApp.repository.UserRepository;
import com.Agricode.AgricodeApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setXp(user.getXp());
        dto.setLevel(user.getLevel());
        dto.setVerified(user.isVerified());
        dto.setStreet(user.getStreet());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setCountry(user.getCountry());
        dto.setZipCode(user.getZipCode());
        dto.setPhone(user.getPhone());
        return dto;
    }

    private User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setXp(dto.getXp());
        user.setLevel(dto.getLevel());
        user.setVerified(dto.isVerified());
        user.setStreet(dto.getStreet());
        user.setCity(dto.getCity());
        user.setState(dto.getState());
        user.setCountry(dto.getCountry());
        user.setZipCode(dto.getZipCode());
        user.setPhone(dto.getPhone());
        return user;
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::mapToDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setXp(userDTO.getXp());
        user.setLevel(userDTO.getLevel());
        user.setVerified(userDTO.isVerified());
        user.setStreet(userDTO.getStreet());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setCountry(userDTO.getCountry());
        user.setZipCode(userDTO.getZipCode());
        user.setPhone(userDTO.getPhone());
        return mapToDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
} 