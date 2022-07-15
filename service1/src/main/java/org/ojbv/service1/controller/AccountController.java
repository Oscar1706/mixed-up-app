package org.ojbv.service1.controller;

import org.ojbv.service1.controller.errors.AccountNotFoundException;
import org.ojbv.service1.entity.Account;
import org.ojbv.service1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

  @Autowired private AccountRepository accountRepository;

  @GetMapping("/accounts")
  ResponseEntity<List<Account>> all() {
    return ResponseEntity.ok(accountRepository.findAll());
  }

  @GetMapping("/accounts/{id}")
  ResponseEntity<Account> findById(@PathVariable long id) {
    return ResponseEntity.ok(
        accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id)));
  }

  @PostMapping("/accounts")
  ResponseEntity<Long> newAccount(@RequestBody Account account) {
    return ResponseEntity.ok(accountRepository.save(account).getId());
  }

  @PutMapping("/accounts/{id}")
  ResponseEntity<Account> replaceOneAccount(
      @PathVariable long id, @RequestBody Account newAccount) {
    return ResponseEntity.ok(
        accountRepository
            .findById(id)
            .map(
                account -> {
                  account.fillFrom(newAccount);
                  return accountRepository.save(account);
                })
            .orElseGet(
                () -> {
                  newAccount.setId(id);
                  return accountRepository.save(newAccount);
                }));
  }

  @DeleteMapping("/accounts/{id}")
  ResponseEntity deleteById(@PathVariable long id) {
    accountRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}