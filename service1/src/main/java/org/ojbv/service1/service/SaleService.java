package org.ojbv.service1.service;

import org.ojbv.service1.entity.Sale;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

  @Autowired private SaleRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Sale get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(Sale product) {
    return repository.save(product).getId();
  }

  public Sale update(long id, Sale newSale) {
    return repository
        .findById(id)
        .map(
            sale -> {
              sale.fillFrom(newSale);
              return repository.save(sale);
            })
        .orElseGet(
            () -> {
              newSale.setId(id);
              return repository.save(newSale);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
