package org.ojbv.service1.configuration;

import org.ojbv.service1.entity.Account;
import org.ojbv.service1.entity.AccountEntry;
import org.ojbv.service1.entity.enums.AccountStatus;
import org.ojbv.service1.entity.Client;
import org.ojbv.service1.repository.AccountEntryRepository;
import org.ojbv.service1.repository.AccountRepository;
import org.ojbv.service1.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
public class DBConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository,
                                   AccountRepository accountRepository,
                                   AccountEntryRepository accountEntryRepository){
        return args ->{
            //
            clientRepository.save(new Client(UUID.randomUUID(),"Edgar Muniz", LocalDateTime.now()));
            clientRepository.save(new Client(UUID.randomUUID(),"Pola",LocalDateTime.now()));
            clientRepository.findAll().forEach(client -> log.info("Preloaded: "+client));

            //
            accountRepository.save(new Account(1l,0.0,AccountStatus.OPEN.toString(),LocalDateTime.now(),"Ocho"));
            accountRepository.save(new Account(2l,0.0,AccountStatus.OPEN.toString(),LocalDateTime.now(),"Yo cuando pinches dije"));
            accountRepository.findAll().forEach(account -> log.info("Preloaded: "+account));

            // Account Entry
            accountEntryRepository.save(
                    new AccountEntry(1l,1000.0,"SALE",1000.0,LocalDateTime.now()));
            accountEntryRepository.save(
                    new AccountEntry(2l, 700.0,"SALE",700.0,LocalDateTime.now()));
            accountEntryRepository.findAll().forEach(accountEntry -> log.info("Preloaded: "+accountEntry));
        };
    }

}
