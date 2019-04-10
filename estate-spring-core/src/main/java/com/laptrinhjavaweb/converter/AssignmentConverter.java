package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.AssignmentDto;
import com.laptrinhjavaweb.entity.AssignmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AssignmentConverter extends AbstractConverter<AssignmentDto, AssignmentEntity> {
}
