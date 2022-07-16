package org.ojbv.service1.service;

import org.ojbv.service1.entity.Client;
import org.ojbv.service1.errors.EntityNotFoundException;
import org.ojbv.service1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
  @Autowired private ClientRepository repository;

  public List getAll() {
    return repository.findAll();
  }

  public Client get(String id) {
    return repository
        .findById(UUID.fromString(id))
        .orElseThrow(() -> new EntityNotFoundException(id));
  }

  public String create(Client client) {
    return repository.save(client).getId().toString();
  }

  public Client update(String id, Client newClient) {
    return repository
        .findById(UUID.fromString(id))
        .map(
            client -> {
              client.fillFrom(newClient);
              return repository.save(client);
            })
        .orElseGet(
            () -> {
              newClient.setId(UUID.fromString(id));
              return repository.save(newClient);
            });
  }

  public void delete(String id) {
    repository.deleteById(UUID.fromString(id));
  }
}
