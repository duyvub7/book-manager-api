package vudd2.app.service;

import java.util.List;

import vudd2.app.dto.CategoryDTO;
import vudd2.app.dto.SortDTO;

/**
 * Interface define methods of table Category
 *
 * @author VuDD2
 * FPT Software
 *
 */
public abstract class CategoryService {
	public abstract List<CategoryDTO> findAll();
	public abstract List<CategoryDTO> findAllAvailable();
	public abstract List<CategoryDTO> findAllAvailable(SortDTO sortDTO);
	public abstract List<CategoryDTO> searchByName(String categoryName);
	public abstract List<CategoryDTO> searchByName(String categoryName, SortDTO sortDTO);
	public abstract void getAmountOfBook(CategoryDTO categoryDTO);
	public abstract CategoryDTO getById(int categoryId);
	public abstract boolean checkExistById(int categoryId);
	public abstract boolean checkExistByName(String categoryName);
	public abstract boolean addCategory(CategoryDTO categoryDTO);
	public abstract boolean updateCategory(CategoryDTO categoryDTO);
	public abstract boolean deleteCategory(int categoryId);
}
