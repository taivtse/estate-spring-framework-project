package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDto;

public interface UserService extends GenericService<UserDto, Integer> {
    UserDto findLoginUser(String username, String password);
}
