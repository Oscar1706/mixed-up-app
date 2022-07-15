package org.ojbv.service1.repository;


import org.ojbv.service1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountRepository extends JpaRepository<Account, Long> {
}
