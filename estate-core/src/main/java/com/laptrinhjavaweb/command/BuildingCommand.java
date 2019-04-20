package com.laptrinhjavaweb.command;

import com.laptrinhjavaweb.dto.BuildingDto;
import com.laptrinhjavaweb.dto.DistrictDto;
import com.laptrinhjavaweb.dto.UserDto;
import com.laptrinhjavaweb.dto.WardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuildingCommand extends AbstractCommand<BuildingDto> {
    private List<DistrictDto> districtDtoList;
    private List<WardDto> wardDtoList;
    private List<UserDto> staffDtoList;
    private BuildingType[] buildingTypeArray = BuildingType.values();

    public BuildingCommand() {
        this.pojo = new BuildingDto();
    }

    public enum BuildingType {
        GROUND_FLOOR("Tầng trệt"),
        APARTMENT("Nguyên căn"),
        FURNITURE("Nội thất");

        private String typeName;

        BuildingType(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }
}
