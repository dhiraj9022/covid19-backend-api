package com.dhiraj9022.service;

import com.dhiraj9022.dto.UserDto;
import com.dhiraj9022.exception.NotFoundException;
import com.dhiraj9022.repo.UserRepo;
import com.dhiraj9022.service.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthUtil authUtil;

    public UserDto getAuthUser() {
        Optional<UserDto> userDto = userRepo.findDtoByEmail(authUtil.getAuthEmail());
        if (!userDto.isPresent()) throw new NotFoundException("user not found");
        return userDto.get();
    }
}

