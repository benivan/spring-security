package com.vikash.springsecurity.Model;

import com.vikash.springsecurity.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long Id;
    private String fName;
    private String lName;
    private Boolean isActive;
    private String password;

    @OneToMany()
    @JoinTable
    private Set<Role> role;

    public User(UserDto userDto) {
        this.fName = userDto.getFName();
        this.isActive = userDto.getIsActive();
        this.lName = userDto.getLName();
        this.password = userDto.getPassword();
    }
}
