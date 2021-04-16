package com.mapper;

import com.form.account.CreateAccountForm;
import com.model.Account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    Account fromCreateFormToEntity (CreateAccountForm createAccountForm);


}
