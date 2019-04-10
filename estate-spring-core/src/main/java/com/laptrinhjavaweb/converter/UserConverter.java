package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDto;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserDto, UserEntity> {
}
