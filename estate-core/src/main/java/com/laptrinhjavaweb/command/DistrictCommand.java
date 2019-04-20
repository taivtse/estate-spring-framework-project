package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.DistrictDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictCommand extends AbstractCommand<DistrictDto> {
    public DistrictCommand() {
        this.pojo = new DistrictDto();
    }
}
