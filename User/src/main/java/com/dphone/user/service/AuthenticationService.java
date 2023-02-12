package com.dphone.user.service;

import com.dphone.user.controller.AuthenticationRequest;
import com.dphone.user.controller.AuthenticationResponse;
import com.dphone.user.controller.RegisterRequest;
import com.dphone.user.dao.UserDao;
import com.dphone.user.entity.Role;
import com.dphone.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UserDao userDao;

    private final UserService jwtService;
    private final PasswordEncoder passwordEncoder;

    private  final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = UserEntity.builder()
                .userFirstName(request.getUserFirstName())
                .userLastName(request.getUserLastName())
                .userName(request.getUserName())
                .userMobile(request.getUserMobile())
                .userEmail(request.getUserEmail())
                .userPassword(passwordEncoder.encode(request.getUserPassword()))
                .role(Role.USER)
                .build();
        userDao.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

         var user  = userDao.findUserByUserName(request.getUsername())
                 .orElseThrow() ;


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();

    }

}
