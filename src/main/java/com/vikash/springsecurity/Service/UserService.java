package com.vikash.springsecurity.Service;
import com.vikash.springsecurity.Model.Role;
import com.vikash.springsecurity.Model.User;
import com.vikash.springsecurity.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepo userRepo;
    final RoleRepo roleRepo;


    public ResponseEntity<?> saveUser(User user) {
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<?> addRoleToUser(Long userId, Long roleId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<Role> optionalRole = roleRepo.findById(roleId);
            if (optionalRole.isPresent()) {
                Role role = optionalRole.get();
                user.getRole().add(role);
                role.setUser(user);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Rle Added");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
