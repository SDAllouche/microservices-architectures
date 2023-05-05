package ma.enset.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.enums.AccountType;

import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccountResponseDTO {

    private long id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;
}
