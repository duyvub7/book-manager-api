package vudd2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vudd2.app.entities.Receipt;

/**
 * Interface contain methods to communicate with table Receipt in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}
