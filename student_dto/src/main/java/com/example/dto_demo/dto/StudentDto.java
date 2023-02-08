package com.example.dto_demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class StudentDto {
    private int id;
    private String name;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private String comment;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime now;
}
