package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDto extends BaseDto {
    private Integer id;
    private String name;
    private Integer districtId;
    private Integer wardId;
    private String street;
    private String fullAddress;
    private String structure;
    private Integer numberOfBasement;
    private Integer buildingArea;
    private String direction;
    private String level;
    private Integer[] rentalAreaArray;
    private String areaDescription;
    private Integer rentalCost;
    private String costDescription;
    private String serviceCost;
    private String carCost;
    private String motorbikeCost;
    private String overtimeCost;
    private String electricityCost;
    private String deposit;
    private String payment;
    private String timeContract;
    private String timeDecorator;
    private String managerName;
    private String managerPhone;
    private String commissionCost;
    private String note;
    private String link;
    private String location;
    private String[] typeArray;
    private String image;

    //    more searching properties
    private Integer buildingAreaFrom;
    private Integer buildingAreaTo;
    private Integer[] staffArray;
    private Integer rentAreaFrom;
    private Integer rentAreaTo;
    private Integer rentalCostFrom;
    private Integer rentalCostTo;
}
