package org.ojbv.service1.service;

import org.ojbv.service1.entity.Product;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  @Autowired private ProductRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Product get(long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
  }

  public long create(Product product) {
    return repository.save(product).getId();
  }

  public Product update(long id, Product newProduct) {
    return repository
        .findById(id)
        .map(
            product -> {
              product.fillFrom(newProduct);
              return repository.save(product);
            })
        .orElseGet(
            () -> {
              newProduct.setId(id);
              return repository.save(newProduct);
            });
  }

  public void delete(long id) {
    repository.deleteById(id);
  }
}
