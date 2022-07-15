package org.ojbv.service1.repository;

import org.ojbv.service1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Component
public interface ClientRepository extends JpaRepository<Client, UUID> {}
