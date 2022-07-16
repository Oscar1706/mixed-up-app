package org.ojbv.service1.service;

import org.ojbv.service1.entity.Contractor;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {

  @Autowired private ContractorRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Contractor get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(Contractor contractor) {
    return repository.save(contractor).getId();
  }

  public Contractor update(long id, Contractor newContractor) {
    return repository
        .findById(id)
        .map(
            contractor -> {
              contractor.fillFrom(newContractor);
              return repository.save(contractor);
            })
        .orElseGet(
            () -> {
              newContractor.setId(id);
              return repository.save(newContractor);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
