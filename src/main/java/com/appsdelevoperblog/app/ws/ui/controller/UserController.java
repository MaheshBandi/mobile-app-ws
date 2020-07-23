package com.appsdelevoperblog.app.ws.ui.controller;

import com.appsdelevoperblog.app.ws.service.UserService;
import com.appsdelevoperblog.app.ws.shared.dto.UserDto;
import com.appsdelevoperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdelevoperblog.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public  String getUser(){
        return "get user was called";
    }
    @PostMapping
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }
    @PutMapping
    public  String updateUser(){
        return "update user was called";
    }
    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
