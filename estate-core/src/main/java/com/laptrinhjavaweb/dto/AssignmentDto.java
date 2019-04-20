package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDto extends BaseDto {
    private Integer id;
    private BuildingDto building;
    private UserDto user;
}
