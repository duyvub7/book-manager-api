package vudd2.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vudd2.app.entities.Book;

/**
 * Interface contain methods to communicate with table Book in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findAllByDeleteFlagFalse();
	
	List<Book> findAllByDeleteFlagFalse(Sort sort);
	
	List<Book> findAllByCategoryIdAndDeleteFlagFalse(int id, Sort sort);
	
	Book findByIdAndDeleteFlagFalse(int id);
	
	long countByCategoryIdAndDeleteFlagFalse(@Param("id") int id);
	
	boolean existsByIdAndDeleteFlagFalse(int id);
	
	boolean existsByCategoryIdAndDeleteFlagFalse(int id);
	
	boolean existsByNameAndDeleteFlagFalseIgnoreCase(String name);
	
}
