package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ExperienceDto {
    @NotBlank
    private String company;
    @NotBlank
    private String position;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private String description;
    @NotBlank
    private String dirIcon;
}
