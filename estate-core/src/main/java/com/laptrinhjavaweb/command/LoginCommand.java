package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand extends AbstractCommand<UserDto> {
    private Boolean remember;

    public LoginCommand() {
        this.pojo = new UserDto();
    }
}
