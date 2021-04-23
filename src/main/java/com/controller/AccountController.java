package com.controller;

import javax.validation.Valid;

import com.dto.ApiMessageDto;
import com.dto.LoginDto;
import com.form.user.CreateUserForm;
import com.form.user.LoginForm;
import com.mapper.UserMapper;
import com.model.User;
import com.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<LoginDto> login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult) {

        ApiMessageDto<LoginDto> apiMessageDto = new ApiMessageDto<>();
        User user = userRepository.findAccountByUsername(loginForm.getUsername());
        if (user == null) {
            apiMessageDto.setResult(false);
            apiMessageDto.setMessage("Login fail, check your username or password");
            return apiMessageDto;
        }

        LoginDto loginDto = new LoginDto();
        loginDto.setId(user.getId());
        loginDto.setUsername(loginForm.getUsername());
        apiMessageDto.setData(loginDto);
        apiMessageDto.setMessage("Login account success");
        // update lastLogin
        return apiMessageDto;

    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<String> Register(@Valid @RequestBody CreateUserForm createUserForm,
            BindingResult bindingResult) {
        ApiMessageDto<String> apiMessageDto = new ApiMessageDto<>();
        User user = userRepository.findAccountByUsername(createUserForm.getUsername());
        if (user != null) {
            apiMessageDto.setResult(false);
            apiMessageDto.setMessage("Username is exist !");
            return apiMessageDto;
        }

        userRepository.save(userMapper.fromCreateFormToEntity(createUserForm));
        apiMessageDto.setMessage("Create account admin success");
        return apiMessageDto;
    }
}
