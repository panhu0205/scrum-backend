package com.controller;

import javax.validation.Valid;

import com.dto.ApiMessageDto;
import com.dto.LoginDto;
import com.form.account.CreateAccountForm;
import com.form.account.LoginForm;
import com.mapper.AccountMapper;
import com.mapper.UserMapper;
import com.model.Account;
import com.repo.AccountRepository;
import com.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<LoginDto> login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult) {


        ApiMessageDto<LoginDto> apiMessageDto = new ApiMessageDto<>();
        Account account = accountRepository.findAccountByUsername(loginForm.getUsername());
        if (account == null || account.getPassword().equals(loginForm.getPassword())) {
            apiMessageDto.setResult(false);
            apiMessageDto.setMessage("Login fail, check your username or password");
            return apiMessageDto;
        }

        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(loginForm.getUsername());
        loginDto.setPassword(loginForm.getPassword());
        apiMessageDto.setData(loginDto);
        apiMessageDto.setMessage("Login account success");
        //update lastLogin
        return apiMessageDto;

    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<String> Register (@Valid @RequestBody CreateAccountForm createAccountForm, BindingResult bindingResult) {
        ApiMessageDto<String> apiMessageDto = new ApiMessageDto<>();
        Account account = accountRepository.findAccountByUsername(createAccountForm.getUsername());
        if (account != null) {
            apiMessageDto.setResult(false);
            apiMessageDto.setMessage("Username is exist !");
            return apiMessageDto;
        }
        account = accountMapper.fromCreateFormToEntity(createAccountForm);
        accountRepository.save(account);
        userRepository.save(userMapper.fromCreateFormToEntity(createAccountForm));
        apiMessageDto.setMessage("Create account admin success");
        return apiMessageDto;

    }

}
