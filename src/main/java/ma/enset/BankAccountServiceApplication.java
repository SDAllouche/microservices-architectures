package ma.enset;

import ma.enset.entities.BankAccount;
import ma.enset.enums.AccountType;
import ma.enset.repositories.BankAcountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAcountRepository bankAccountRepository){
        return args -> {
            for (int i=0;i<10 ; i++) {
                BankAccount bankAccount =BankAccount.builder()
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(10000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();

                bankAccountRepository.save(bankAccount) ;
            }
        };
    }
}
