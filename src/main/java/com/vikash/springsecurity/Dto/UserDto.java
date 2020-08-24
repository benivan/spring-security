package com.vikash.springsecurity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private String fName;
    private String lName;
    private Boolean isActive;
    private String password;
}
