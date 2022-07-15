package ojbv.service1.configuration;

import ojbv.service1.entity.Account;
import ojbv.service1.entity.AccountDebt;
import ojbv.service1.entity.AccountDebtStatus;
import ojbv.service1.repository.AccountDebtRepository;
import ojbv.service1.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository,
                                   AccountDebtRepository accountDebtRepository){
        return args ->{
            //
            accountRepository.save(new Account(1l,"Edgar Muniz"));
            accountRepository.save(new Account(2l,"Pola"));
            accountRepository.findAll().forEach(account -> log.info("Preloaded: "+account));

            // Account Debt
            accountDebtRepository.save(
                    new AccountDebt(1l, AccountDebtStatus.IN_PROGRESS.toString(),1000.0));
            accountDebtRepository.save(
                    new AccountDebt(2l, AccountDebtStatus.IN_PROGRESS.toString(),700.0));
            accountDebtRepository.findAll().forEach(accountDebt -> log.info("Preloaded: "+accountDebt));
        };
    }

}
