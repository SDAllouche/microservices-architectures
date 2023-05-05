package ma.enset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.enums.AccountType;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccountRequestDTO {

    private double balance;
    private String currency;
    private AccountType type;

}
