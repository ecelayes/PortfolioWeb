package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PersonDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String title;
    @NotBlank
    private String location;
    @NotBlank
    private String description;
    @NotBlank
    private String dirPhoto;
    @NotBlank
    private String dirBanner;
}
