package ma.enset.entities;

import ma.enset.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {

    public Long getId();
    public AccountType getType();

}
