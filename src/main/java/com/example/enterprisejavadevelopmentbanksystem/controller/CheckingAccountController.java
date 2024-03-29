package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.Account;
import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.account.dto.CheckingAccountDto;
import com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checking_accounts")
public class CheckingAccountController {


    private final CheckingAccountService checkingAccountService;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Account newCheckingAccount(@RequestBody CheckingAccountDto checkingAccountDto) {

        return checkingAccountService.newCheckingAccount(checkingAccountDto);

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<CheckingAccount> getAll(){
        return checkingAccountService.getAll();
    }



}
