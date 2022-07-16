package org.ojbv.service1.service;

import org.ojbv.service1.entity.Payment;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

  @Autowired private PaymentRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Payment get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(Payment product) {
    return repository.save(product).getId();
  }

  public Payment update(long id, Payment newPayment) {
    return repository
        .findById(id)
        .map(
            sale -> {
              sale.fillFrom(newPayment);
              return repository.save(sale);
            })
        .orElseGet(
            () -> {
              newPayment.setId(id);
              return repository.save(newPayment);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
