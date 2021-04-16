package com.mapper;

import com.dto.UserDto;
import com.form.account.CreateAccountForm;
import com.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    
    // @Mapping(source = "userUsername", target = "username")
    // @Mapping(source = "userFirstName", target = "firstName")
    // @Mapping(source = "userLastName", target = "lastName")
    // @Mapping(source = "userPhoneNumber", target = "phoneNumber")
    // @Mapping(source = "userDob", target = "dob")
    // @Mapping(source = "userVehiclesType", target = "vehiclesType")
    // @Mapping(source = "userVehiclesNumber", target = "vehiclesNumber")
    // User fromDtotoEntity (UserDto userDto);

        
    @Mapping(source = "username", target = "username")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "dob", target = "dob")
    @Mapping(source = "vehiclesType", target = "vehiclesType")
    @Mapping(source = "vehiclesNumber", target = "vehiclesNumber")
    User fromCreateFormToEntity (CreateAccountForm createAccountForm);
}
