package com.example.vmo_demo.mapper;

import com.example.vmo_demo.dto.AccountDto;
import com.example.vmo_demo.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDto, Account> {

}
