package com.appsdelevoperblog.app.ws.ui.controller;

import com.appsdelevoperblog.app.ws.exceptions.UserServiceException;
import com.appsdelevoperblog.app.ws.service.UserService;
import com.appsdelevoperblog.app.ws.shared.dto.UserDto;
import com.appsdelevoperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdelevoperblog.app.ws.ui.model.response.ErrorMessages;
import com.appsdelevoperblog.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE
                                            ,MediaType.APPLICATION_XML_VALUE})
    public  UserRest getUser(@PathVariable String id){
        UserRest returnValue = new UserRest();
        UserDto userDto =  userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);
        return returnValue;
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) throws UserServiceException{

        UserRest returnValue = new UserRest();
        if(userDetails.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
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
