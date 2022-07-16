package org.ojbv.service1.service;

import org.ojbv.service1.entity.AccountEntry;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.AccountEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountEntryService {
  @Autowired private AccountEntryRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public AccountEntry get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(AccountEntry accountEntry) {
    return repository.save(accountEntry).getId();
  }

  public AccountEntry update(long id, AccountEntry newAccountEntry) {
    return repository
        .findById(id)
        .map(
            accountEntry -> {
              accountEntry.fillFrom(newAccountEntry);
              return repository.save(accountEntry);
            })
        .orElseGet(
            () -> {
              newAccountEntry.setId(id);
              return repository.save(newAccountEntry);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
