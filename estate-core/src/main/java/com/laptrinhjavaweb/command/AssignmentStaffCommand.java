package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.AssignmentStaffDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentStaffCommand extends AbstractCommand<AssignmentStaffDto> {
    private Integer buildingId;

    public AssignmentStaffCommand() {
        this.pojo = new AssignmentStaffDto();
    }
}
