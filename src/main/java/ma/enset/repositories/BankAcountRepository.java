package ma.enset.repositories;

import ma.enset.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAcountRepository extends JpaRepository<BankAccount, Long> {
}
