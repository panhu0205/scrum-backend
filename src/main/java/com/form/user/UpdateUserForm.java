package com.form.user;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UpdateUserForm {
    @NotEmpty(message = "FirstName cant not be null")
    @ApiModelProperty(name = "firstName", required = true)
    private String firstName;
    @NotEmpty(message = "LastName cant not be null")
    @ApiModelProperty(name = "lastName", required = true)
    private String lastName;
    @NotEmpty(message = "PhoneNumber cant not be null")
    @ApiModelProperty(name = "phoneNumber", required = true)
    private String phoneNumber;
    @NotEmpty(message = "DoB cant not be null")
    @ApiModelProperty(name = "dob", required = true)
    private Date dob;
    @NotEmpty(message = "Vehicles Type cant not be null")
    @ApiModelProperty(name = "vehiclesType", required = true)
    private String vehiclesType;
    @NotEmpty(message = "Vehicles Number cant not be null")
    @ApiModelProperty(name = "vehiclesNumber", required = true)
    private String vehiclesNumber;
}
