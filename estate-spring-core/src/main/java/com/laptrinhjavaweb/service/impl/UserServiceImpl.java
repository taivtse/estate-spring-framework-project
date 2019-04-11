package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDto;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.respository.UserRepository;
import com.laptrinhjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<UserDto, UserEntity, Integer> implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier("userConverter") UserConverter userConverter,
                           @Qualifier("userRepository") UserRepository userRepository) {
        super(userConverter, userRepository);
        this.userRepository = userRepository;
    }
}
