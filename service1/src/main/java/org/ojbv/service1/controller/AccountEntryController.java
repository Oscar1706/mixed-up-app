package org.ojbv.service1.controller;

import org.ojbv.service1.entity.AccountEntry;
import org.ojbv.service1.service.AccountEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountEntryController {
    @Autowired
    private AccountEntryService service;

    @GetMapping("/account-entries")
    ResponseEntity<List<AccountEntry>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/account-entries/{id}")
    ResponseEntity<AccountEntry> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/account-entries")
    ResponseEntity<Long> newAccountEntry(@RequestBody AccountEntry accountEntry) {
        return ResponseEntity.ok(service.create(accountEntry));
    }

    @PutMapping("/account-entries/{id}")
    ResponseEntity<AccountEntry> replaceOneAccountEntry(
            @PathVariable long id, @RequestBody AccountEntry newAccountEntry) {
        return ResponseEntity.ok(service.update(id, newAccountEntry));
    }

    @DeleteMapping("/account-entries/{id}")
    ResponseEntity deleteById(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
