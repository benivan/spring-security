package com.vikash.springsecurity.Controller;
import com.vikash.springsecurity.Dto.RoleDto;
import com.vikash.springsecurity.Dto.UserDto;
import com.vikash.springsecurity.Model.Role;
import com.vikash.springsecurity.Model.User;
import com.vikash.springsecurity.Service.RoleService;
import com.vikash.springsecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")

public class InputController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/addUser")
    public ResponseEntity<?> setUserDetail(@RequestBody UserDto userDto){
      return userService.saveUser(new User(userDto));
    }
    @PostMapping("/addRole")
    public ResponseEntity<?> setRoles(@RequestBody RoleDto roleDto){
        return roleService.saveRoles(new Role(roleDto));
    }

    public ResponseEntity<?> setRoleToUser(@PathVariable Long userId, @RequestParam Long roleId){
        return userService.addRoleToUser(userId,roleId);
    }


}
