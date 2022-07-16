package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Sale;
import org.ojbv.service1.service.SaleService;
import org.ojbv.service1.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping("/sales")
    ResponseEntity<List<Sale>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/sales/{id}")
    ResponseEntity<Sale> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/sales")
    ResponseEntity<Long> newSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(service.create(sale));
    }

    @PutMapping("/sales/{id}")
    ResponseEntity<Sale> replaceOneSale(
            @PathVariable long id, @RequestBody Sale newSale) {
        return ResponseEntity.ok(service.update(id, newSale));
    }

    @DeleteMapping("/sales/{id}")
    ResponseEntity deleteById(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
