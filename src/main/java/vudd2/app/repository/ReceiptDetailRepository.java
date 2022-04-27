package vudd2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vudd2.app.entities.ReceiptDetail;

/**
 * Interface contain methods to communicate with table ReceiptDetail in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Integer> {

}
