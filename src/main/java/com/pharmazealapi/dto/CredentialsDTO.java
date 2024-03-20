package com.pharmazealapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CredentialsDTO {
    private final String email;
    private final String password;
}
