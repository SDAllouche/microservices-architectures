package ma.enset.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.enums.AccountType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class BankAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
