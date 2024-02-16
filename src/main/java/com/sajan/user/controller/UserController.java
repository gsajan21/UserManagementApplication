package com.sajan.user.controller;

import com.sajan.user.dto.UserDto;
import com.sajan.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserDto userDto){
        String s = userService.userRegistration(userDto);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", s);

        return  new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
