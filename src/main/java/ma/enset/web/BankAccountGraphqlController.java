package ma.enset.web;

import ma.enset.entities.BankAccount;
import ma.enset.repositories.BankAcountRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {

    private BankAcountRepository bankAcountRepository;

    public BankAccountGraphqlController(BankAcountRepository bankAcountRepository) {
        this.bankAcountRepository = bankAcountRepository;
    }


    @QueryMapping
    public List<BankAccount> accountsList(){
        return  bankAcountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(Long id){
        return  bankAcountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account not found")));
    }
}