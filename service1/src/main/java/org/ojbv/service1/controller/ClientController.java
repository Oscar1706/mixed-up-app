package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Client;
import org.ojbv.service1.repository.ClientRepository;
import org.ojbv.service1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
  @Autowired private ClientRepository clientRepository;
  @Autowired private ClientService clientService;

  @GetMapping("/clients")
  ResponseEntity<List<Client>> all() {
    return ResponseEntity.ok(clientService.getAll());
  }

  @GetMapping("/clients/{id}")
  ResponseEntity<Client> findById(@PathVariable String id) {
    return ResponseEntity.ok(
            clientService.get(id));
  }

  @PostMapping("/clients")
  ResponseEntity<String> newClient(@RequestBody Client client) {
    return ResponseEntity.ok(clientService.create(client));
  }

  @PutMapping("/clients/{id}")
  ResponseEntity<Client> replaceOneClient(@PathVariable String id, @RequestBody Client newClient) {
    return ResponseEntity.ok(
            clientService.update(id,newClient));
  }

  @DeleteMapping("/clients/{id}")
  ResponseEntity deleteById(@PathVariable String id) {
    clientService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
