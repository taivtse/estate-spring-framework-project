package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto extends BaseDto {
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private Boolean status;
    private Integer roleId;
    private List<RoleDto> roles;
}
