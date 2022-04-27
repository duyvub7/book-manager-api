package vudd2.app.util;

import java.time.LocalDate;

import vudd2.app.dto.BookDTO;
import vudd2.app.dto.CategoryDTO;

public class Validator {
	
	public static boolean BookValidate(BookDTO bookDTO) {
		if(!isValidName(bookDTO.getName()) || !isValidName(bookDTO.getAuthor()) || !isValidName(bookDTO.getPublisher())
				|| bookDTO.getPrice() < 0 || bookDTO.getPrice() > 2000000000
				|| bookDTO.getPublishYear() <= 0 || bookDTO.getPublishYear() > LocalDate.now().getYear()
				|| bookDTO.getDescription().length() > 1000) {
			return false;
		}
		return true;
	}
	
	public static boolean CategoryValidate(CategoryDTO categoryDTO) {
		if(!isValidName(categoryDTO.getName()) || categoryDTO.getDescription().length() > 1000) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidName(String name) {
		if(name == null || name.length() > 100) {
			return false;
		}
		return true;
	}
	
	
}
