package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.DistrictDto;
import com.laptrinhjavaweb.entity.DistrictEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictConverter extends AbstractConverter<DistrictDto, DistrictEntity> {
    @Autowired
    DistrictConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
