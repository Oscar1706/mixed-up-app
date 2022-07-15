package org.ojbv.service1.repository;

import org.ojbv.service1.entity.AccountEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountEntryRepository extends JpaRepository<AccountEntry, Long> {}
