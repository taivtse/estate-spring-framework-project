package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.RentAreaDto;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter extends AbstractConverter<RentAreaDto, RentAreaEntity> {
    @Autowired
    RentAreaConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
