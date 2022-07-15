package ojbv.service1.repository;

import ojbv.service1.entity.AccountDebt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountDebtRepository extends JpaRepository<AccountDebt, Long> {
}
