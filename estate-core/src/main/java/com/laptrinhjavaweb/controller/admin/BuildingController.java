package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.command.BuildingCommand;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.DistrictDto;
import com.laptrinhjavaweb.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/building")
public class BuildingController {

    @GetMapping("list")
    public ModelAndView list(@ModelAttribute(SystemConstant.COMMAND) BuildingCommand command) {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        DistrictDto districtDto = new DistrictDto();
        districtDto.setId(1);
        districtDto.setName("quan 1");
        command.setDistrictDtoList(new ArrayList<>());
        command.getDistrictDtoList().add(districtDto);

        command.setStaffDtoList(new ArrayList<>());
        UserDto staff = new UserDto();
        staff.setId(1);
        staff.setFullName("vo thanh tai");
        command.getStaffDtoList().add(staff);

        UserDto staff1 = new UserDto();
        staff1.setId(2);
        staff1.setFullName("vo thanh cong");
        command.getStaffDtoList().add(staff1);

        UserDto staff2 = new UserDto();
        staff2.setId(3);
        staff2.setFullName("vo thanh thu");
        command.getStaffDtoList().add(staff2);
        modelAndView.addObject(SystemConstant.COMMAND, command);
        return modelAndView;
    }

    @GetMapping("edit")
    public ModelAndView showEditInfo() {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        return modelAndView;
    }

    @PutMapping
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        return modelAndView;
    }

    @DeleteMapping
    public ModelAndView delete() {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        return modelAndView;
    }
}
