package com.dto;

import java.util.Date;

import lombok.Data;

@Data   
public class UserDto {
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private String userPhoneNumber;
    private String userVehiclesType;
    private String userVehiclesNumber;
}
