package com.dhiraj9022.service.utils;

import com.dhiraj9022.entity.User;
import com.dhiraj9022.exception.NotFoundException;
import com.dhiraj9022.exception.UnAuthException;
import com.dhiraj9022.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUtil {

    @Autowired
    private UserRepo userRepo;

    public String getAuthEmail() {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            throw new UnAuthException("UnAuthorized");
        }
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public User getAuthUser() {
        Optional<User> user = userRepo.findByEmail(getAuthEmail());
        if (!user.isPresent()) throw new NotFoundException("user not found");
        return user.get();
    }
}
