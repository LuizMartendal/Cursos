package com.crudspring.crudspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CourseDTO {

    private Long id;

    @Length(min = 2, max = 100)
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String category;
}
