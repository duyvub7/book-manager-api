package vudd2.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vudd2.app.common.StringUtil;
import vudd2.app.convert.CategoryConvert;
import vudd2.app.dto.CategoryDTO;
import vudd2.app.dto.SortDTO;
import vudd2.app.entities.Category;
import vudd2.app.repository.BookRepository;
import vudd2.app.repository.CategoryRepository;
import vudd2.app.service.CategoryService;
import vudd2.app.util.Validator;

/**
 * Interface contain methods of table Category
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Service
public class CategoryServiceImpl extends CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<CategoryDTO> findAll() {
		return CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAll());
	}

	@Override
	public List<CategoryDTO> findAllAvailable() {
		List<CategoryDTO> listCategoryDTO = CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAllByDeleteFlagFalse());
		for(CategoryDTO categoryDTO: listCategoryDTO) {
			categoryDTO.setAmount(bookRepository.countByCategoryIdAndDeleteFlagFalse(categoryDTO.getId()));
		}
		return listCategoryDTO;
	}
	
	@Override
	public List<CategoryDTO> findAllAvailable(SortDTO sortDTO) {
		if(sortDTO.getColumnName().equals("amount")) {
			return CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAllByDeleteFlagFalse());
		}
		Sort sort = null;
		if(sortDTO.isSortDesc()) {
			sort = Sort.by(Sort.Direction.DESC, sortDTO.getColumnName());
		}else {
			sort = Sort.by(Sort.Direction.ASC, sortDTO.getColumnName());
		}
		List<CategoryDTO> listCategoryDTO = CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAllByDeleteFlagFalse(sort));
		for(CategoryDTO categoryDTO: listCategoryDTO) {
			categoryDTO.setAmount(bookRepository.countByCategoryIdAndDeleteFlagFalse(categoryDTO.getId()));
		}
		return listCategoryDTO;
	}
	
	@Override
	public void getAmountOfBook(CategoryDTO categoryDTO) {
		categoryDTO.setAmount(bookRepository.countByCategoryIdAndDeleteFlagFalse(categoryDTO.getId()));
	}
	
	@Override
	public boolean checkExistById(int categoryId) {
		return categoryRepository.existsByIdAndDeleteFlagFalse(categoryId);
	}

	@Override
	public boolean checkExistByName(String categoryName) {
		return categoryRepository.existsByNameAndDeleteFlagFalseIgnoreCase(categoryName.trim());
	}
	
	@Override
	public CategoryDTO getById(int categoryId) {
		return CategoryConvert.ConvertEntityToDTO(categoryRepository.findByIdAndDeleteFlagFalse(categoryId));
	}
	
	@Override
	public List<CategoryDTO> searchByName(String categoryName) {
		List<CategoryDTO> listCategoryDTO = CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAllByDeleteFlagFalse());
		List<CategoryDTO> result = new ArrayList<>();
		for(CategoryDTO categoryDTO : listCategoryDTO) {
			if( StringUtil.FixString(categoryDTO.getName()).toLowerCase().contains( 
					StringUtil.FixString(categoryName.trim()).toLowerCase() ) ) {
				result.add(categoryDTO);
			}
		}
		return result;
	}
	
	@Override
	public List<CategoryDTO> searchByName(String categoryName, SortDTO sortDTO) {
		Sort sort = null;
		if(sortDTO.isSortDesc()) {
			sort = Sort.by(Sort.Direction.DESC, sortDTO.getColumnName());
		}else {
			sort = Sort.by(Sort.Direction.ASC, sortDTO.getColumnName());
		}
		List<CategoryDTO> listCategoryDTO = CategoryConvert.ConvertListEntityToListDTO(categoryRepository.findAllByDeleteFlagFalse(sort));
		List<CategoryDTO> result = new ArrayList<>();
		for(CategoryDTO categoryDTO : listCategoryDTO) {
			if( StringUtil.FixString(categoryDTO.getName()).toLowerCase().contains( 
					StringUtil.FixString(categoryName.trim()).toLowerCase() ) ) {
				result.add(categoryDTO);
			}
		}
		return result;
	}

	@Override
	public boolean addCategory(CategoryDTO categoryDTO) {
		if(categoryDTO == null || !Validator.CategoryValidate(categoryDTO)) {
			return false;
		}
		categoryRepository.save(CategoryConvert.ConvertDTOToEntityWithoutId(categoryDTO));
		return true;
	}
	
	@Override
	public boolean updateCategory(CategoryDTO categoryDTO) {
		if(categoryDTO == null || !Validator.CategoryValidate(categoryDTO)) {
			return false;
		}
		categoryRepository.save(CategoryConvert.ConvertDTOToEntity(categoryDTO));
		return true;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		Category category = categoryRepository.findByIdAndDeleteFlagFalse(categoryId);
		if(category != null) {
			category.setDeleteFlag(true);
			categoryRepository.save(category);
			return true;
		}
		return false;
	}

}
