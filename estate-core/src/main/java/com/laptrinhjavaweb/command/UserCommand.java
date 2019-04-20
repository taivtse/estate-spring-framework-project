package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCommand extends AbstractCommand<UserDto> {
    public UserCommand() {
        this.pojo = new UserDto();
    }
}
