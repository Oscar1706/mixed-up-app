package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Contractor;
import org.ojbv.service1.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractorController {
    @Autowired
    private ContractorService service;

    @GetMapping("/contractors")
    ResponseEntity<List<Contractor>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/contractors/{id}")
    ResponseEntity<Contractor> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/contractors")
    ResponseEntity<Long> newContractor(@RequestBody Contractor contractor) {
        return ResponseEntity.ok(service.create(contractor));
    }

    @PutMapping("/contractors/{id}")
    ResponseEntity<Contractor> replaceOneContractor(
            @PathVariable long id, @RequestBody Contractor newContractor) {
        return ResponseEntity.ok(service.update(id, newContractor));
    }

    @DeleteMapping("/contractors/{id}")
    ResponseEntity deleteById(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
