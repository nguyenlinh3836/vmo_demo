package com.example.vmo_demo.service;

import com.example.vmo_demo.dto.AccountDto;
import java.util.Optional;

public interface AccountService {
  AccountDto createUser(AccountDto userDto);
  Optional<AccountDto> findByUsername(String username);

}
