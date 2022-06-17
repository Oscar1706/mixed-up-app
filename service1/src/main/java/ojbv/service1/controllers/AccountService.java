package ojbv.service1.controllers;

import ojbv.service1.entity.Account;
import ojbv.service1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/accounts")
    List<Account> all(){
        return accountRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/accounts")
    Long newAccount(@RequestBody Account account){
        return accountRepository.save(account).getId();
    }

    @GetMapping("/greeting")
    public Account getGreeting(){
        return new Account(1l,"Hi!!");
    }
}
