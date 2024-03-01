package com.arcokim.akwiki.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateForm {
    @NotBlank
    private String title;

    @NotBlank
    private String body;
}
