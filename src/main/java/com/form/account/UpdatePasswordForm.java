package com.form.account;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UpdatePasswordForm {
    @NotEmpty(message = "username cant not be null")
    @ApiModelProperty(name = "username", required = true)
    private String username;
    @NotEmpty(message = "password cant not be null")
    @ApiModelProperty(name = "oldpassword", required = true)
    private String oldpassword;
}
