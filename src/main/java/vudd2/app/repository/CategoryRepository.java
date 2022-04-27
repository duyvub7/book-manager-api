package vudd2.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vudd2.app.entities.Category;

/**
 * Interface contain methods to communicate with table Category in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	List<Category> findAllByDeleteFlagFalse();
	
	List<Category> findAllByDeleteFlagFalse(Sort sort);
	
	Category findByIdAndDeleteFlagFalse(int id);
	
	boolean existsByIdAndDeleteFlagFalse(int id);
	
	boolean existsByNameAndDeleteFlagFalseIgnoreCase(String name);
}
