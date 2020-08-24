package com.vikash.springsecurity.Model;

import com.vikash.springsecurity.Dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String roleName;

    @ManyToOne
    private User user;

    public Role(RoleDto roleDto) {
        this.roleName = roleDto.getRoleName();
    }
}
