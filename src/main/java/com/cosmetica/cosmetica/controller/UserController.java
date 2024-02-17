package com.cosmetica.cosmetica.controller;

import com.cosmetica.cosmetica.dto.LoginDto;
import com.cosmetica.cosmetica.dto.UserDto;
import com.cosmetica.cosmetica.response.LoginMessage;
import com.cosmetica.cosmetica.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/signup")
    public String saveUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }
}
