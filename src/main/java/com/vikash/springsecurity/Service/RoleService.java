package com.vikash.springsecurity.Service;

import com.vikash.springsecurity.Model.Role;
import com.vikash.springsecurity.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {


    final RoleRepo roleRepo;


    public ResponseEntity<?> saveRoles(Role role) {
        roleRepo.save(role);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
