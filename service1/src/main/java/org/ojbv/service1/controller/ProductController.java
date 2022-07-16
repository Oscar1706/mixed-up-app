package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Product;
import org.ojbv.service1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    ResponseEntity<List<Product>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/products")
    ResponseEntity<Long> newProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.create(product));
    }

    @PutMapping("/products/{id}")
    ResponseEntity<Product> replaceOneProduct(
            @PathVariable long id, @RequestBody Product newProduct) {
        return ResponseEntity.ok(service.update(id, newProduct));
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity deleteById(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
