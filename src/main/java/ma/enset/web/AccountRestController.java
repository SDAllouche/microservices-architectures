package ma.enset.web;

import ma.enset.entities.BankAccount;
import ma.enset.repositories.BankAcountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class AccountRestController {

    private BankAcountRepository bankAccountRepository;
    public AccountRestController(BankAcountRepository bankAccountRepository) {

        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList() {

        return bankAccountRepository.findAll();

    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccountList(@PathVariable long id) {

        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));

    }

    @PostMapping("/bankAccounts")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount){
        if (bankAccount.getId()==0l) bankAccount.setId(new Random().nextLong());
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount,@PathVariable long id){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        account.setBalance(bankAccount.getBalance());
        if(account.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(account.getType()!=null) account.setType(bankAccount.getType());
        if(account.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable long id){
        bankAccountRepository.deleteById(id);
    }
}
