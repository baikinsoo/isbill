package com.isbill.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BillFormDto {

    @NotBlank
    private String name;
}
