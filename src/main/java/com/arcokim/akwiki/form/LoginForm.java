package com.arcokim.akwiki.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
