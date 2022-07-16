package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Payment;
import org.ojbv.service1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping("/payments")
    ResponseEntity<List<Payment>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/payments/{id}")
    ResponseEntity<Payment> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping("/payments")
    ResponseEntity<Long> newPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(service.create(payment));
    }

    @PutMapping("/payments/{id}")
    ResponseEntity<Payment> replaceOnePayment(
            @PathVariable long id, @RequestBody Payment newPayment) {
        return ResponseEntity.ok(service.update(id, newPayment));
    }

    @DeleteMapping("/payments/{id}")
    ResponseEntity deleteById(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
