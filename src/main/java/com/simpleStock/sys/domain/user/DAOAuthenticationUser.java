package com.simpleStock.sys.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DAOAuthenticationUser (
        @NotBlank String userName,
        @NotBlank String password
        ){
}
