package org.ojbv.service1.controller;

import org.ojbv.service1.entity.Client;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {
  @Autowired private ClientRepository clientRepository;

  @GetMapping("/clients")
  ResponseEntity<List<Client>> all() {
    return ResponseEntity.ok(clientRepository.findAll());
  }

  @GetMapping("/clients/{id}")
  ResponseEntity<Client> findById(@PathVariable String id) {
    return ResponseEntity.ok(
        clientRepository
            .findById(UUID.fromString(id))
            .orElseThrow(() -> new EntityNotFoundException(id)));
  }

  @PostMapping("/clients")
  ResponseEntity<String> newClient(@RequestBody Client client) {
    return ResponseEntity.ok(clientRepository.save(client).getId().toString());
  }

  @PutMapping("/clients/{id}")
  ResponseEntity<Client> replaceOneClient(@PathVariable String id, @RequestBody Client newClient) {
    return ResponseEntity.ok(
        clientRepository
            .findById(UUID.fromString(id))
            .map(
                client -> {
                  client.setName(newClient.getName());
                  return clientRepository.save(client);
                })
            .orElseGet(
                () -> {
                  newClient.setId(UUID.fromString(id));
                  return clientRepository.save(newClient);
                }));
  }

  @DeleteMapping("/clients/{id}")
  ResponseEntity deleteById(@PathVariable String id) {
    clientRepository.deleteById(UUID.fromString(id));
    return ResponseEntity.noContent().build();
  }
}
