package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EducationDto {
    @NotBlank
    private String institution;
    @NotBlank
    private String degree;
    @NotBlank
    private String career;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private String dirIcon;
}
