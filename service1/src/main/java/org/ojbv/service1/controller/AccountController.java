package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Account;
import org.ojbv.service1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

  @Autowired private AccountService service;

  @GetMapping("/accounts")
  ResponseEntity<List<Account>> all() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/accounts/{id}")
  ResponseEntity<Account> findById(@PathVariable long id) {
    return ResponseEntity.ok(service.get(id));
  }

  @PostMapping("/accounts")
  ResponseEntity<Long> newAccount(@RequestBody Account account) {
    return ResponseEntity.ok(service.create(account));
  }

  @PutMapping("/accounts/{id}")
  ResponseEntity<Account> replaceOneAccount(
      @PathVariable long id, @RequestBody Account newAccount) {
    return ResponseEntity.ok(service.update(id, newAccount));
  }

  @DeleteMapping("/accounts/{id}")
  ResponseEntity deleteById(@PathVariable long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
