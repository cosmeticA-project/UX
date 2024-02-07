package com.cosmetica.cosmetica.service;

import com.cosmetica.cosmetica.dto.LoginDto;
import com.cosmetica.cosmetica.dto.UserDto;
import com.cosmetica.cosmetica.response.LoginMessage;

public interface UserService {
     String addUser(UserDto userDto);
     LoginMessage loginUser(LoginDto loginDto);
     LoginMessage loginAdmin(LoginDto loginDto);
}
