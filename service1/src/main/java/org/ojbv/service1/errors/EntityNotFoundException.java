package org.ojbv.service1.errors;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(String id) {
    super("Entity not found with id " + id);
  }
}
