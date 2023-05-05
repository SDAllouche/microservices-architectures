package ma.enset.service;

import ma.enset.dto.BankAccountRequestDTO;
import ma.enset.dto.BankAccountResponseDTO;
import ma.enset.entities.BankAccount;
import ma.enset.mappers.AccountMapper;
import ma.enset.repositories.BankAcountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAcountRepository bankAcountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAcountRepository bankAcountRepository, AccountMapper accountMapper) {
        this.bankAcountRepository = bankAcountRepository;
        this.accountMapper = accountMapper;
    }


    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(new Random().nextLong())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        BankAccount saved = bankAcountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(saved);

        return bankAccountResponseDTO;
    }
}
