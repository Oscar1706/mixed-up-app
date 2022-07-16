package org.ojbv.service1.service;

import org.ojbv.service1.entity.Account;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

  @Autowired private AccountRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Account get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(Account account) {
    return repository.save(account).getId();
  }

  public Account update(long id, Account newAccount) {
    return repository
        .findById(id)
        .map(
            account -> {
              account.fillFrom(newAccount);
              return repository.save(account);
            })
        .orElseGet(
            () -> {
              newAccount.setId(id);
              return repository.save(newAccount);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
