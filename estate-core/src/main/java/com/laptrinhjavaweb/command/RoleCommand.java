package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.RoleDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleCommand extends AbstractCommand<RoleDto> {
    public RoleCommand() {
        this.pojo = new RoleDto();
    }
}
