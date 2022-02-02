package com.pinhobrunodev.userms.frameworks.adapters.inboud.controllers;

import com.pinhobrunodev.userms.application.domain.UserDomain;
import com.pinhobrunodev.userms.application.ports.UserServicePort;
import com.pinhobrunodev.userms.frameworks.adapters.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    public ModelMapper modelMapper;
    public UserServicePort userServicePort;

    public AuthenticationController(ModelMapper modelMapper, UserServicePort userServicePort) {
        this.modelMapper = modelMapper;
        this.userServicePort = userServicePort;
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<UserDomain> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServicePort.saveUser(modelMapper.map(userDto, UserDomain.class)));
    }


}
