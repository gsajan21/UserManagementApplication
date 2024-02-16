package com.sajan.user.service;

import com.sajan.user.dto.UserDto;
import com.sajan.user.entity.User;
import com.sajan.user.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String userRegistration(UserDto userDto) {
        try {
            User userEmail = userRepo.findByEmail(userDto.getEmail()).get();
        } catch (Exception e) {

//        if (userEmail == null) {
            User saveUser = new User();
            try {
                BeanUtils.copyProperties(userDto, saveUser); // copying model from request body to entity class
                userRepo.save(saveUser);
                return "Registration Successful";
            } catch (Exception exception) {
                return "Registration failed";
            }
        }
        return "duplicate email";
    }

    @Override
    public String userLogin(String email, String password) {
        Optional<User> byEmailAndPassword = userRepo.findByEmailAndPassword(email, password);
        if(byEmailAndPassword.isPresent())
            return "User Login Successful";
        else
            return "Login Unsuccessful";
    }

    @Override
    public String forgotPassword(String email) {
        return null;
    }

    @Override
    public UserDto viewUserDetails(Integer userId) {
        return null;
    }

    @Override
    public String updateUserDetails(UserDto update, Integer userId) {
        return null;
    }
}
