package com.appsdelevoperblog.app.ws.service;

import com.appsdelevoperblog.app.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    UserDto createUser(UserDto userDto);
}
