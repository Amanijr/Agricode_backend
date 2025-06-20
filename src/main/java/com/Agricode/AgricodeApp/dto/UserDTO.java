package com.Agricode.AgricodeApp.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Role is required")
    private String role;

    @Min(value = 0, message = "XP must be non-negative")
    private int xp;

    @Min(value = 0, message = "Level must be non-negative")
    private int level;

    private boolean isVerified;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Phone number is invalid")
    private String phone;
}
