package com.springboot.uberApplication.UberApplication.services;

import com.springboot.uberApplication.UberApplication.dto.DriverDto;
import com.springboot.uberApplication.UberApplication.dto.SignupDto;
import com.springboot.uberApplication.UberApplication.dto.UserDto;

public interface AuthService {

    String[]  login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onBoardNewDriver(Long userId, String vehicleId);


    String refreshToken(String refreshToken);
}
