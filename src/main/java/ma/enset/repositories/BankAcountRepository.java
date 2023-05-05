package ma.enset.repositories;

import ma.enset.entities.BankAccount;
import ma.enset.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAcountRepository extends JpaRepository<BankAccount, Long> {

    @RestResource(path="/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
