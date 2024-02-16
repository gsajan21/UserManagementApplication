package com.sajan.user.service;

import com.sajan.user.dto.UserDto;


public interface UserService {

    // register user
    // verify user exists
    // verify email get the password
    // using userId get specific user information
    // update user information
    // delete user using userId

    public String userRegistration(UserDto userDto);
    public String userLogin(String email, String password);
    public String forgotPassword(String email);
    public UserDto viewUserDetails(Integer userId);
    public String updateUserDetails(UserDto update, Integer userId);
}
