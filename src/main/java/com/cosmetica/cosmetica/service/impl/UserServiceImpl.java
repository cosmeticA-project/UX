package com.cosmetica.cosmetica.service.impl;

import com.cosmetica.cosmetica.dto.LoginDto;
import com.cosmetica.cosmetica.dto.UserDto;
import com.cosmetica.cosmetica.model.User;
import com.cosmetica.cosmetica.model.UserRole;
import com.cosmetica.cosmetica.repository.UserRepo;
import com.cosmetica.cosmetica.response.LoginMessage;
import com.cosmetica.cosmetica.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(userDto.getPasswordHash()));
        user.setRole(UserRole.CLIENT);

        userRepo.save(user);
        return user.getName();
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {

        String email = loginDto.getEmail();
        String password = loginDto.getPasswordHash();

        User user = userRepo.findByEmail(email);
        if (user != null) {
            String encodedPassword = user.getPasswordHash();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                return new LoginMessage("Login successful", true);
            } else {
                return new LoginMessage("Incorrect password", false);
            }
        } else {
            return new LoginMessage("Email does not exist", false);
        }
    }
}
