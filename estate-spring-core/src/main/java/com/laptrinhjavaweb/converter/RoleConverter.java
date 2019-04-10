package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.RoleDto;
import com.laptrinhjavaweb.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter extends AbstractConverter<RoleDto, RoleEntity> {
    @Autowired
    RoleConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
