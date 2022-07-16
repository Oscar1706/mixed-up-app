package org.ojbv.service1.errors;

public class AccountNotFoundException extends RuntimeException {
  public AccountNotFoundException(Long id) {
    super("Account not found with id " + id);
  }
}
