package ojbv.service1.configuration;

import ojbv.service1.entity.Account;
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
    CommandLineRunner initDatabase(AccountRepository repository){
        return args ->{
            log.info("Preloading "+repository.save(new Account(1l,"Edgar Muniz")));
            log.info("Preloading "+repository.save(new Account(2l,"Pola")));
        };
    }

}
