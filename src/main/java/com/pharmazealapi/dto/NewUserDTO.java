package com.pharmazealapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewUserDTO {
    private final String name;
    private final String gender;
    private final String contact;
    private final String email;
    private final String password;
    private final String role;
    private final String location;
}
