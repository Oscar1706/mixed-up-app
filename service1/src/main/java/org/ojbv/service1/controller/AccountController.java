package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Account;
import org.ojbv.service1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

  @Autowired private AccountService accountService;

  @GetMapping("/accounts")
  ResponseEntity<List<Account>> all() {
    return ResponseEntity.ok(accountService.getAll());
  }

  @GetMapping("/accounts/{id}")
  ResponseEntity<Account> findById(@PathVariable long id) {
    return ResponseEntity.ok(accountService.get(id));
  }

  @PostMapping("/accounts")
  ResponseEntity<Long> newAccount(@RequestBody Account account) {
    return ResponseEntity.ok(accountService.create(account));
  }

  @PutMapping("/accounts/{id}")
  ResponseEntity<Account> replaceOneAccount(
      @PathVariable long id, @RequestBody Account newAccount) {
    return ResponseEntity.ok(accountService.update(id, newAccount));
  }

  @DeleteMapping("/accounts/{id}")
  ResponseEntity deleteById(@PathVariable long id) {
    accountService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
