package ma.enset.web;

import ma.enset.dto.BankAccountRequestDTO;
import ma.enset.dto.BankAccountResponseDTO;
import ma.enset.entities.BankAccount;
import ma.enset.repositories.BankAcountRepository;
import ma.enset.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {

    private BankAcountRepository bankAcountRepository;
    private AccountService accountService;

    public BankAccountGraphqlController(BankAcountRepository bankAcountRepository, AccountService accountService) {
        this.bankAcountRepository = bankAcountRepository;
        this.accountService = accountService;
    }


    @QueryMapping
    public List<BankAccount> accountsList(){
        return  bankAcountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument int id){
        return  bankAcountRepository.findById(Long.valueOf(id))
                .orElseThrow(()->new RuntimeException(String.format("Account not found")));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
}

/*record BankAccountDTO(Double balance,String type,String currency){

}*/


