package vudd2.app.convert;

import java.util.ArrayList;
import java.util.List;

import vudd2.app.dto.CategoryDTO;
import vudd2.app.entities.Category;

public class CategoryConvert {
	
	public static Category ConvertDTOToEntity(CategoryDTO categoryDTO) {
		if(categoryDTO == null) {
			return null;
		}
		Category category = new Category(categoryDTO.getId(), categoryDTO.getName().trim(), categoryDTO.getDescription().trim());
		return category;
	}
	
	public static Category ConvertDTOToEntityWithoutId(CategoryDTO categoryDTO) {
		if(categoryDTO == null) {
			return null;
		}
		Category category = new Category(categoryDTO.getName().trim(), categoryDTO.getDescription().trim());
		return category;
	}
	
	public static CategoryDTO ConvertEntityToDTO(Category category) {
		if(category == null) {
			return null;
		}
		CategoryDTO categoryDTO = new CategoryDTO(
				category.getId(), category.getName(), category.getDescription());
		return categoryDTO;
	}
	
	public static List<Category> ConvertListDTOToListEntity(List<CategoryDTO> listCategoryDTO) {
		List<Category> listCategory = new ArrayList<>();
		if(listCategoryDTO != null && listCategoryDTO.size() > 0) {
			for(CategoryDTO categoryDTO : listCategoryDTO) {
				listCategory.add(ConvertDTOToEntity(categoryDTO));
			}
		}
		return listCategory;
	}
	
	public static List<CategoryDTO> ConvertListEntityToListDTO(List<Category> listCategory) {
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		if(listCategory != null && listCategory.size() > 0) {
			for(Category category : listCategory) {
				listCategoryDTO.add(ConvertEntityToDTO(category));
			}
		}
		return listCategoryDTO;
	}
}
