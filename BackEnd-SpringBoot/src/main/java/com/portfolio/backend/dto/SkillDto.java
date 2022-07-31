package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SkillDto {
    @NotBlank
    private String nameSkill;
    @NotBlank
    private String dirIcon;
    @NotBlank
    private int percentage;
}
