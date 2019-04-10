package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.WardDto;
import com.laptrinhjavaweb.entity.WardEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WardConverter extends AbstractConverter<WardDto, WardEntity> {
    @Autowired
    WardConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
