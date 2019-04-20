package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WardDto {
    private Integer id;
    private String name;
    private DistrictDto district;
}
