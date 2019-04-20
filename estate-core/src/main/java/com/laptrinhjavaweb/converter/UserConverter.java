package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDto;
import com.laptrinhjavaweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserDto, UserEntity> {
    @Autowired
    UserConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
