package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDto;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter extends AbstractConverter<BuildingDto, BuildingEntity> {
    @Autowired
    BuildingConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
