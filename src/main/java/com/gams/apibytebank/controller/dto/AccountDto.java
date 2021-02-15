package com.gams.apibytebank.controller.dto;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;

import java.util.List;
import java.util.stream.Collectors;

public class AccountDto {

    private Integer id;
    private Integer number;
    private Double balance;
    private Client client;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        this.client = account.getClient();
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public static List<AccountDto> convert(List<Account> accounts) {
        return accounts.stream().map(AccountDto::new).collect(Collectors.toList());
    }
}
